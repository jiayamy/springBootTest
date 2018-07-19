package com.servant.wiki.core.controller;

public class Solution {

	public boolean isPalindrome(int x) {
		StringBuffer sb = new StringBuffer().append(x);
		try {
			Integer y = Integer.valueOf(sb.reverse().toString());
			if(x == y){
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

}