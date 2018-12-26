package com.servant.wiki.common.model.list;

public class ListNode2 {

	private Object value;

	private ListNode2 prev;

	private ListNode2 next;

	public ListNode2(Object value) {
		this.value = value;
	}

	public ListNode2() {
		// TODO Auto-generated constructor stub
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public ListNode2 getPrev() {
		return prev;
	}

	public void setPrev(ListNode2 prev) {
		this.prev = prev;
	}

	public ListNode2 getNext() {
		return next;
	}

	public void setNext(ListNode2 next) {
		this.next = next;
	}

	public static ListNode2 reverse(ListNode2 head) {
		ListNode2 dum = new ListNode2(0);
		if (head == null || head.next == null) {
			return head;
		}
		dum.next = head;
		head.prev = dum;
		ListNode2 curr = head.next;
		while (curr != null) {
			ListNode2 tmp = curr.next;
			curr.next = dum.next;
			dum.next.prev = curr;
			dum.next = curr;
			curr.prev = dum;
			curr = tmp;
		}
		return dum.next;
	}

}
