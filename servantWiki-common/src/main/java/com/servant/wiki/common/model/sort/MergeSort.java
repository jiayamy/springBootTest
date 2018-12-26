package com.servant.wiki.common.model.sort;

import java.util.Random;

import net.sf.json.JSONArray;

public class MergeSort {

	private static int CUTOFF = 7;

	// aux <- a
	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
		if (hi <= lo + CUTOFF - 1) {
			Insertion.sort(a, lo, hi);
			return;
		}
		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				aux[k] = a[j++];
			} else if (j > hi) {
				aux[k] = a[i++];
			} else if (less(aux[j], aux[i])) {
				aux[k] = a[j++];
			} else {
				aux[k] = a[i++];
			}
		}
	}

	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
		if (hi <= lo) {
			return;
		}
		int mid = lo + (hi - lo) / 2;
		sort(aux, a, lo, mid); // a <- aux
		sort(aux, a, mid + 1, hi); // a<- aux
		if (less(aux[mid], aux[mid + 1])) {
			return;
		}
		merge(a, aux, lo, mid, hi); // aux <- a
	}

	public static void sort(Comparable[] a) {
		int N = a.length;
		Comparable[] aux = new Comparable[a.length];
		for (int k = 0; k < N; k++) {
			aux[k] = a[k];
		}
		sort(a, aux, 0, N - 1);
	}
	
	private static void bottomUpMerge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
		if (hi <= lo + CUTOFF - 1) {
			Insertion.sort(a, lo, hi);
			return;
		}
		for (int k = 0; k < hi+1; k++) {
			aux[k] = a[k];
		}
		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				a[k] = aux[j++];
			} else if (j > hi) {
				a[k] = aux[i++];
			} else if (less(aux[j], aux[i])) {
				a[k] = aux[j++];
			} else {
				a[k] = aux[i++];
			}
		}
	}

	public static void bottomUpSort(Comparable[] a) {
		int N = a.length;
		Comparable[] aux = new Comparable[a.length];
		for (int sz = 1; sz < N; sz += sz) {
			for (int lo = 0; lo < N - sz; lo += sz + sz) {
				bottomUpMerge(a, aux, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
			}
		}
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
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
		MergeSort.bottomUpSort(input);
		System.out.println(JSONArray.fromObject(input));
	}
}
