package com.servant.wiki.core.controller;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public List<Integer> sort(List<Integer> input) {
		List<Integer> res = new ArrayList<>();
		Integer min = input.get(0);
		int index = 0;
		while (input.size() > 0) {
			min = input.get(0);
			index = 0;
			for (int i = 1; i < input.size(); i++) {
				if (min > input.get(i)) {
					min = input.get(i);
					index = i;
				}
			}
			input.set(index, input.get(input.size() - 1));
			input = input.subList(0, input.size() - 1);
			res.add(min);
		}
		return res;
	}

	public static void main(String[] args) {
		List<Integer> test = new ArrayList<>();
		test.add(3);
		test.add(2);
		test.add(1);
		test.add(1);
	}
}