package com.servant.wiki.common.model.stack;

public class FixCapacityStack<Item> {

	private Item[] items;
	
	private Integer index = 0;
	
	@SuppressWarnings("unchecked")
	public FixCapacityStack(Integer capacity) {
		items = (Item[]) new Object[capacity];
	}
	
	public boolean isEmpty(){
		return index == 0;
	}
	
	public void push(Item item) {
		items[index++] = item;
	}
	
	public Item pop(){
		Item item = items[--index];
		items[index] = null;
		return item;
	}
}
