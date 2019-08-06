package com.test.algorithms;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public int[] twoSum_1 (int[] nums, int target) {
		for (int i = 0; i< nums.length-1;i++) {
			for (int j=i+1; j< nums.length;j++) {
				if ((nums[i] + nums[j]) == target) {
					return new int[]{i,j};
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	public int[] twoSum_2 (int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i=0; i<nums.length;i++) {
			map.put(nums[i], i);
		}
		for (int i=0; i<nums.length;i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement) && map.get(complement) != i) {
				return new int[] {i,map.get(complement)};
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}


	public int[] twoSum_3(int[] nums, int target){
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<nums.length; i++){
			map.put(nums[i], i);
			int b = target - nums[i];

			if(map.containsKey(b) && map.get(b) != i){
				return new int[]{i,map.get(b)};
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	public static void main(String[] args) {
		TwoSum tosum = new TwoSum();
		int[] A = new int[] {1,2,36,23,45,89,15,65,122,69};
		int target = 110;
		try {
			int[] array = tosum.twoSum_1(A,target);
			for (int num: array) {
				System.out.print(num + "  ");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("\n-------------------------------------------------------------------------------------");
		try {
			tosum.twoSum_3(A,target);
			int[] array = tosum.twoSum_1(A,target);
			for (int num: array) {
				System.out.print(num + "  ");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
