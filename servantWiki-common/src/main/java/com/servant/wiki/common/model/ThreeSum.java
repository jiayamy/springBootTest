package com.servant.wiki.common.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.servant.wiki.common.util.JsonUtils;

import net.sf.json.JSONArray;

public class ThreeSum {

	private int[] ids;
	
	public ThreeSum(int[] input) {
		ids = input;
		sort();
	}
	
	private void sort(){
		System.out.println("========sort======");
		for(int i = 0; i < ids.length - 1; i++){
			for(int j = 0; j < ids.length - 1 - i; j++){
				if(ids[j] > ids[j+1]){
					int tmp = ids[j];
					ids[j] = ids[j+1];
					ids[j+1] = tmp;
				}
			}
		}
	}
	
	public List<int[]> get(){
		System.out.println("=======get=====" + JSONArray.fromObject(ids));
		List<int[]> list = new ArrayList<>();
		for(int i = 0; i < ids.length; i++){
			for(int j = i+1; j < ids.length; j++){
				int lo = j + 1; 
				int hi = ids.length - 1;
				while(lo <= hi){
					int mid = lo + (hi - lo)/2;
					if(ids[i] + ids[j] + ids[mid] > 0){
						hi = mid - 1;
					} else if (ids[i] + ids[j] + ids[mid] < 0){
						lo = mid + 1;
					} else {
						int[] tmp = new int[]{ids[i], ids[j], ids[mid]};
						list.add(tmp);
						break;
					}
				}
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		int size = 100;
		int [] input = new int[size];
		int min = -100;
		int max = 100;
		for(int i = 0; i < size; i++){
			input[i] = min + ((int) (new Random().nextFloat() * (max - min)));
		}
		Long t1 = System.currentTimeMillis();
		ThreeSum threeSum = new ThreeSum(input);
		System.out.println(JsonUtils.toJson(threeSum.get()));
		System.out.println(System.currentTimeMillis() - t1);
	}
}
