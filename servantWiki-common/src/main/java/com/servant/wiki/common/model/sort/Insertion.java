package com.servant.wiki.common.model.sort;

import java.util.Random;

import net.sf.json.JSONArray;

/**
 * uses ~ 1⁄4 N^2 compares and ~ 1⁄4 N^2 exchanges on average.
 * 
 * @author lijia
 *
 */
public class Insertion {

	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			for (int j = i; j >= 0; j--) {
				if (j > 0 && less(a[j], a[j - 1])) {
					exch(a, j, j - 1);
				} else {
					break;
				}
			}
		}
	}

	public static void sort(Comparable[] a, int lo, int hi) {
		for (int i = lo; i <= hi; i++) {
			for (int j = i; j >=lo; j--) {
				if (j > lo && less(a[j], a[j - 1])) {
					exch(a, j, j - 1);
				} else {
					break;
				}
			}
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
		for (int i = 0; i < size; i++) {
			input[i] = min + ((int) (new Random().nextFloat() * (max - min)));
		}
		System.out.println(JSONArray.fromObject(input));
		Insertion.sort(input);
		System.out.println(JSONArray.fromObject(input));
	}
}
