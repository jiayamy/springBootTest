package com.servant.wiki.core.redisDemo.addList.method;

import com.servant.wiki.core.redisDemo.addList.model.ListNode;

public interface ListInvok {

	public Object dup(Object value);

	public void free(Object value);

	public boolean match(ListNode listNode, Object value);
}
