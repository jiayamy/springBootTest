package com.servant.wiki.common.model.sort;

import java.util.Random;

import net.sf.json.JSONArray;

public class Shell {

	public static void sort(Comparable[] a) {
		int N = a.length;
		int h = 1;
		while (h < N / 3) {
			h = 3 * h + 1;
		}
		// h-sort array
		while (h >= 1) {
			for (int i = 0; i < N; i++) {
				for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
					exch(a, j, j - h);
				}
			}
			h = h / 3;
		}
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
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
	}
}
