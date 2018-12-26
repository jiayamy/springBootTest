package com.servant.wiki.common.model;

public class QuickUnionUF {

	private int[] id;
	
	private int[] sz;
	
	public QuickUnionUF(int size) {
		id = new int[size];
		sz = new int[size];
		for(int i = 0; i < size; i++){
			id[i] = i;
			sz[i] = 1;
		}
	}
	
	private int root(int i){
		while(i != id[i]){
			id[i] = id[id[i]];
			i = id[i];
		}
		return i;
	}
	
	public boolean conntected(int p, int q){
		return root(p) == root(q);
	}
	
	public void union(int p, int q){
		int i = root(p);
		int j = root(q);
		if(i == j){
			return;
		}
		if(sz[i] < sz[j]){
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}
	}
}
