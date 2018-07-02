package com.servant.wiki.core.controller;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public String convert(String s, int numRows) {
		int men = numRows + (numRows -2);
		int l = s.length();
		int c = numRows - 1;
		int size = c*(l/men) + ((l%men) > 0 ? 1 : 0) + (((l%men)-numRows) > 0?((l%men)-numRows): 0)%numRows;
		List<List> demo = new ArrayList<>();
		for(int i = 0 ; i < size; i++){
			for(int j = 0; j < numRows; j++){
				if(i%c == 0){
				}
			}
		}
		return null;
	}
	
}