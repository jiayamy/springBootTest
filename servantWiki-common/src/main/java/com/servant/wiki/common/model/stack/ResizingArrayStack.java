package com.servant.wiki.common.model.stack;

public class ResizingArrayStack<Item> {

	private Item[] items;
	
	private int index = 0;
	
	@SuppressWarnings("unchecked")
	public ResizingArrayStack() {
		items = (Item[]) new Object[1];
	}
	
	public Item pop(){
		Item item = items[--index];
		items[index] = null;
		if(index > 0 && index == items.length/4){
			resize(items.length/2);
		}
		return item;
	}
	
	public boolean isEmpty(){
		return index == 0;
	}
	
	public void push(Item item){
		if(index == items.length){
			resize(2*items.length);
		}
		items[index++] = item;
	}
	
	@SuppressWarnings("unchecked")
	private void resize(int capacity){
		Item[] copy = (Item[]) new Object[capacity];
		for(int i = 0; i < index; i++){
			copy[i] = items[i];
		}
		items = copy;
	}
}
