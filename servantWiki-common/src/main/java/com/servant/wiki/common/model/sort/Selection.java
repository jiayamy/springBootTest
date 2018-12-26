package com.servant.wiki.common.model.sort;

import java.util.Random;

import net.sf.json.JSONArray;

/**
 * N^2 / 2 compares and N exchanges.
 * @author lijia
 *
 */
public class Selection {

	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int min = i;
			for (int j = i + 1; j < N; j++) {
				if (less(a[j], a[min])) {
					min = j;
				}
			}
			exch(a, i, min);
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
		Selection.sort(input);
		System.out.println(JSONArray.fromObject(input));
	}
}
