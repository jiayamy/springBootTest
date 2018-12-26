package com.servant.wiki.common.model.queue;

@SuppressWarnings("unchecked")
public class ResizingArrayQueue<Item> {

	private Item[] items;

	private int head = 0, tail = 0;

	public ResizingArrayQueue() {
		items = (Item[]) new Object[1];
	}

	public boolean isEmpty() {
		return head == tail;
	}

	public void enqueue(Item item) {
		if (tail == items.length) {
			reSize(2 * items.length);
		}
		items[tail++] = item;
	}

	public Item dequeue() {
		System.out.println(items.length+"======");
		Item item = items[head];
		items[head] = null;
		head++;
		if(!isEmpty()){
			if ((tail - head) == items.length / 4) {
				reSize(items.length / 2);
			}
		} else{
			reSize(1);
		}
		
		return item;
	}

	private void reSize(int capacity) {
		Item[] oldItems = items;
		items = (Item[]) new Object[capacity];
		int index = head;
		for (int i = 0; i < tail - head; i++) {
			items[i] = oldItems[index + i];
		}
		tail -= head;
		head = 0;
	}

	public static void main(String[] args) {
		ResizingArrayQueue<Integer> tmp = new ResizingArrayQueue<>();
		System.out.println(tmp.isEmpty());
		tmp.enqueue(1);
		System.out.println(tmp.isEmpty());
		System.out.println(tmp.dequeue());
		System.out.println(tmp.isEmpty());
		for(int i = 2; i < 10; i++){
			tmp.enqueue(i);
		}
		while(!tmp.isEmpty()){
			System.out.println(tmp.dequeue());
		}
	}
}
