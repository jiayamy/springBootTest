package com.servant.wiki.common.model.list;

public class ListNode {

	private Object value;

	private ListNode next;

	public ListNode(Object value) {
		this.value = value;
	}

	public ListNode() {
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((next == null) ? 0 : next.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListNode other = (ListNode) obj;
		if (next == null) {
			if (other.next != null)
				return false;
		} else if (!next.equals(other.next))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	public static ListNode reverse(ListNode head) {
		ListNode dum = new ListNode(0);
		dum.next = head;
		if (head == null || head.next == null) {
			return head;
		}
		ListNode curr = head.next;
		head.next = null;
		while (curr != null) {
			ListNode tmp = curr.next;
			curr.next = dum.next;
			dum.next = curr;
			curr = tmp;
		}
		return dum.next;
	}

}
