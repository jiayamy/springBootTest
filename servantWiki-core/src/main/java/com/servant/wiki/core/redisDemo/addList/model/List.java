package com.servant.wiki.core.redisDemo.addList.model;

import com.servant.wiki.core.redisDemo.addList.method.ListInvok;

public class List {

	private ListNode head;

	private ListNode tail;

	private Integer length;
	
	private ListInvok listInvok;

	public ListNode getHead() {
		return head;
	}

	public void setHead(ListNode head) {
		this.head = head;
	}

	public ListNode getTail() {
		return tail;
	}

	public void setTail(ListNode tail) {
		this.tail = tail;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public ListInvok getListInvok() {
		return listInvok;
	}

	public void setListInvok(ListInvok listInvok) {
		this.listInvok = listInvok;
	}
	
}
