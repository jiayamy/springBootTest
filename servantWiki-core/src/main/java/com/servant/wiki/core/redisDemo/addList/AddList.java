package com.servant.wiki.core.redisDemo.addList;

import com.servant.wiki.core.redisDemo.addList.method.ListInvok;
import com.servant.wiki.core.redisDemo.addList.model.List;
import com.servant.wiki.core.redisDemo.addList.model.ListIter;
import com.servant.wiki.core.redisDemo.addList.model.ListNode;

public abstract class AddList {

	protected static Integer AL_START_HEAD = 0;

	protected static Integer AL_START_TAIL = 1;

	public Integer listLength(List list) {
		return list.getLength();
	}

	public ListNode listFirst(List list) {
		return list.getHead();
	}

	public ListNode listLast(List list) {
		return list.getTail();
	}

	public ListNode listPrevNode(ListNode listNode) {
		return listNode.getPrev();
	}

	public ListNode listNextNode(ListNode listNode) {
		return listNode.getNext();
	}

	public Object listNodeValue(ListNode listNode) {
		return listNode.getValue();
	}

	public void listSetMethod(List list, ListInvok listInvok) {
		list.setListInvok(listInvok);
	}

	public ListInvok listGetMethod(List list) {
		return list.getListInvok();
	}

	public abstract List listCreate();

	public abstract void listRelease(List list);

	public abstract void listEmpty(List list);

	public abstract List listAddNodeHead(List list, Object value);

	public abstract List listAddNodeTail(List list, Object value);

	public abstract List listInsertNode(List list, ListNode oldNode, Object value, Boolean isAfter);

	public abstract void listDelNode(List list, ListNode node);

	public abstract ListIter listGetIterator(List list, Integer direction);

	public abstract ListNode listNext(ListIter listIter);

	public abstract void listReleaseIterator(ListIter listIter);

	public abstract List listDup(List oriList);

	public abstract ListNode listSearchKey(List list, Object key);

	public abstract ListNode listIndex(List list, Long index);

	public abstract void listRewind(List list, ListIter listIter);

	public abstract void listRewindTail(List list, ListIter listIter);

	public abstract void listRotate(List list);

	public abstract void listJoin(List list, List joinList);
}
