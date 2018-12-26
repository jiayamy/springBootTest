package com.servant.wiki.common.model.sort;

import java.util.Random;

import net.sf.json.JSONArray;

public class SetRandom {

	public static void shuffle(Comparable[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int r = new Random().nextInt(i+1);
			exch(a, i, r);
		}
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	
	public static void main(String[] args) {
		int size = 20;
		Integer[] input = new Integer[size];
		int min = -100;
		int max = 100;
		for(int i = 0; i < size; i++){
			input[i] = min + ((int) (new Random().nextFloat() * (max - min)));
		}
		System.out.println(JSONArray.fromObject(input));
		Shell.sort(input);
		System.out.println(JSONArray.fromObject(input));
		SetRandom.shuffle(input);
		System.out.println(JSONArray.fromObject(input));
	}
}
