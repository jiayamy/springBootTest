package com.servant.wiki.core.redisDemo.addList.model;

public class ListNode {
	
	private ListNode prev;
	
	private ListNode next;
	
	private Object value;

	public ListNode getPrev() {
		return prev;
	}

	public void setPrev(ListNode prev) {
		this.prev = prev;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	
}
