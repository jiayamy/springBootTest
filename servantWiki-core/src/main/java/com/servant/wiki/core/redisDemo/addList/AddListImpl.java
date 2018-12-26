package com.servant.wiki.core.redisDemo.addList;

import com.servant.wiki.core.redisDemo.addList.method.ListInvok;
import com.servant.wiki.core.redisDemo.addList.model.List;
import com.servant.wiki.core.redisDemo.addList.model.ListIter;
import com.servant.wiki.core.redisDemo.addList.model.ListNode;
import com.servant.wiki.core.redisDemo.zmalloc.Zmalloc;
import com.servant.wiki.core.redisDemo.zmalloc.ZmallocImpl;

public class AddListImpl extends AddList {

	private Zmalloc zmalloc;

	public AddListImpl() {
		zmalloc = new ZmallocImpl();
	}

	/*
	 * Create a new list. The created list can be freed with AlFreeList(), but
	 * private value of every node need to be freed by the user before to call
	 * AlFreeList().
	 *
	 * On error, NULL is returned. Otherwise the pointer to the new list.
	 */
	@Override
	public List listCreate() {
		List list = new List();
		list.setHead(null);
		list.setTail(null);
		list.setLength(0);
		list.setListInvok(null);
		return list;
	}

	/*
	 * Free the whole list.
	 *
	 * This function can't fail.
	 */
	@Override
	public void listRelease(List list) {
		listEmpty(list);
		zmalloc.zfree(list);
	}

	/*
	 * Remove all the elements from the list without destroying the list itself.
	 */
	@Override
	public void listEmpty(List list) {
		Integer length;
		ListNode cur, next;

		cur = list.getHead();
		length = list.getLength();
		ListInvok listInvok = list.getListInvok();
		while (0 < length--) {
			next = cur.getNext();
			if (listInvok != null) {
				listInvok.free(cur.getValue());
			}
			zmalloc.zfree(cur);
			cur = next;
		}
		list.setHead(null);
		list.setTail(null);
		list.setLength(0);
	}

	/*
	 * Add a new node to the list, to head, containing the specified 'value'
	 * pointer as value.
	 *
	 * On error, NULL is returned and no operation is performed (i.e. the list
	 * remains unaltered). On success the 'list' pointer you pass to the
	 * function is returned.
	 */
	@Override
	public List listAddNodeHead(List list, Object value) {
		ListNode node = new ListNode();
		node.setValue(value);
		Integer length = list.getLength();
		if (length == 0) {
			list.setHead(node);
			list.setTail(node);
			node.setNext(null);
			node.setPrev(null);
		} else {
			node.setPrev(null);
			node.setNext(list.getHead());
			list.getHead().setPrev(node);
			list.setHead(node);
		}
		list.setLength(length++);
		return list;
	}

	@Override
	public List listAddNodeTail(List list, Object value) {
		ListNode node = new ListNode();
		node.setValue(value);
		Integer length = list.getLength();
		if (length == 0) {
			list.setHead(node);
			list.setTail(node);
			node.setNext(null);
			node.setPrev(null);
		} else {
			node.setPrev(list.getTail());
			node.setNext(null);
			list.getTail().setNext(node);
			list.setTail(node);
		}
		list.setLength(length++);
		return list;
	}

	@Override
	public List listInsertNode(List list, ListNode oldNode, Object value, Boolean isAfter) {
		Integer length = list.getLength();
		ListNode node = new ListNode();
		node.setValue(value);
		if (isAfter) {
			node.setPrev(oldNode);
			node.setNext(oldNode.getNext());
			if (list.getTail() == oldNode) {
				list.setTail(node);
			}
		} else {
			node.setNext(oldNode);
			node.setPrev(oldNode.getPrev());
			if (list.getHead() == oldNode) {
				list.setHead(node);
			}
		}
		if (node.getPrev() != null) {
			node.getPrev().setNext(node);
		}
		if (node.getNext() != null) {
			node.getNext().setPrev(node);
		}
		list.setLength(length++);
		return list;
	}

	/*
	 * Remove the specified node from the specified list. It's up to the caller
	 * to free the private value of the node.
	 *
	 * This function can't fail.
	 */
	@Override
	public void listDelNode(List list, ListNode node) {
		Integer length = list.getLength();
		if (node.getPrev() != null) {
			node.getPrev().setNext(node.getNext());
		} else {
			list.setHead(node.getNext());
		}
		if (node.getNext() != null) {
			node.getNext().setPrev(node.getPrev());
		} else {
			list.setTail(node.getPrev());
		}
		if (list.getListInvok() != null) {
			list.getListInvok().free(node.getValue());
		}
		zmalloc.zfree(node);
		list.setLength(length--);
	}

	/*
	 * Returns a list iterator 'iter'. After the initialization every call to
	 * listNext() will return the next element of the list.
	 *
	 * This function can't fail.
	 */
	@Override
	public ListIter listGetIterator(List list, Integer direction) {
		ListIter iter = new ListIter();
		if (direction == AL_START_HEAD) {
			iter.setNext(list.getHead());
		} else {
			iter.setNext(list.getTail());
		}
		iter.setDirection(direction);
		return iter;
	}

	/*
	 * Return the next element of an iterator. It's valid to remove the
	 * currently returned element using listDelNode(), but not to remove other
	 * elements.
	 *
	 * The function returns a pointer to the next element of the list, or NULL
	 * if there are no more elements, so the classical usage patter is:
	 *
	 * iter = listGetIterator(list,<direction>); while ((node = listNext(iter))
	 * != NULL) { doSomethingWith(listNodeValue(node)); }
	 *
	 */
	@Override
	public ListNode listNext(ListIter iter) {
		ListNode current = iter.getNext();
		if (current != null) {
			if (iter.getDirection() == AL_START_HEAD) {
				iter.setNext(current.getNext());
			} else {
				iter.setNext(current.getPrev());
			}
		}
		return current;
	}

	/* Release the iterator memory */
	@Override
	public void listReleaseIterator(ListIter listIter) {
		zmalloc.zfree(listIter);
	}

	/*
	 * Duplicate the whole list. On out of memory NULL is returned. On success a
	 * copy of the original list is returned.
	 *
	 * The 'Dup' method set with listSetDupMethod() function is used to copy the
	 * node value. Otherwise the same pointer value of the original node is used
	 * as value of the copied node.
	 *
	 * The original list both on success or error is never modified.
	 */
	@Override
	public List listDup(List orig) {
		List copy = listCreate();
		ListIter iter = new ListIter();
		ListNode node;
		if (copy == null) {
			return null;
		}
		copy.setListInvok(orig.getListInvok());
		listRewind(orig, iter);
		while ((node = listNext(iter)) != null) {
			Object value;
			if (copy.getListInvok() != null) {
				value = copy.getListInvok().dup(node.getValue());
				if (value == null) {
					listRelease(copy);
					return null;
				}
			} else {
				value = node.getValue();
			}
			if (listAddNodeTail(copy, value) == null) {
				listRelease(copy);
				return null;
			}
		}
		return copy;
	}

	/*
	 * Search the list for a node matching a given key. The match is performed
	 * using the 'match' method set with listSetMatchMethod(). If no 'match'
	 * method is set, the 'value' pointer of every node is directly compared
	 * with the 'key' pointer.
	 *
	 * On success the first matching node pointer is returned (search starts
	 * from head). If no matching node exists NULL is returned.
	 */

	@Override
	public ListNode listSearchKey(List list, Object key) {
		ListIter iter = new ListIter();
		ListNode node;
		listRewind(list, iter);
		while ((node = listNext(iter)) != null) {
			if (list.getListInvok() != null) {
				if (list.getListInvok().match(node, key)) {
					return node;
				}
			} else {
				if (key == node.getValue()) {
					return node;
				}
			}
		}
		return null;
	}

	/*
	 * Return the element at the specified zero-based index where 0 is the head,
	 * 1 is the element next to head and so on. Negative integers are used in
	 * order to count from the tail, -1 is the last element, -2 the penultimate
	 * and so on. If the index is out of range NULL is returned.
	 */
	@Override
	public ListNode listIndex(List list, Long index) {
		ListNode node = new ListNode();
		if (index < 0) {
			index = (-index) - 1;
			node = list.getTail();
			while ((index-- > 0) && node != null) {
				node = node.getPrev();
			}
		} else {
			node = list.getHead();
			while ((index-- > 0) && node != null) {
				node = node.getNext();
			}
		}
		return node;
	}

	/* Create an iterator in the list private iterator structure */
	@Override
	public void listRewind(List list, ListIter iter) {
		iter.setNext(list.getHead());
		iter.setDirection(AL_START_HEAD);
	}

	@Override
	public void listRewindTail(List list, ListIter iter) {
		iter.setNext(list.getTail());
		iter.setDirection(AL_START_TAIL);
	}

	/* Rotate the list removing the tail node and inserting it to the head. */
	@Override
	public void listRotate(List list) {
		ListNode tail = list.getTail();
		if (listLength(list) <= 1) {
			return;
		}
		/* Detach current tail */
		list.setTail(tail.getPrev());
		list.getTail().setNext(null);
		/* Move it as head */
		list.getHead().setPrev(tail);
		tail.setPrev(null);
		tail.setNext(list.getHead());
		list.setHead(tail);
	}

	/*
	 * Add all the elements of the list 'o' at the end of the list 'l'. The list
	 * 'other' remains empty but otherwise valid.
	 */
	@Override
	public void listJoin(List l, List o) {
		if (o.getHead() != null) {
			o.getHead().setPrev(l.getTail());
		}
		if (l.getTail() != null) {
			l.getTail().setNext(o.getHead());
		} else {
			l.setHead(o.getHead());
		}
		if (o.getTail() != null) {
			l.setTail(o.getTail());
		}
		Integer length = l.getLength();
		l.setLength(length += o.getLength());
		/* Setup other as an empty list. */
		o.setHead(null);
		o.setTail(null);
		o.setLength(0);
	}

}
