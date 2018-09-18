package com.test.algorithms;

public class MonotonicArray {

	public boolean isMonotonicArray (int[] nums) {
		return this.isIncreasingArray(nums) || this.isDecreasingArray(nums);
	}
	
	public boolean isIncreasingArray (int[] nums) {
		for (int i=0;i<nums.length-1;i++) {
			int j=i+1;
			if (nums[i] > nums[j]) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isDecreasingArray(int[] nums) {
		for (int i=0;i<nums.length-1;i++) {
		int j=i+1;
		if (nums[i] < nums[j]) {
			return false;
			}
		}
		return true;
	}
	
	public static void main (String[] args) {
		int[] nums = new int[] {1,2,3,3,4,4,5,6,8};
		MonotonicArray monotonicArray = new MonotonicArray();
		System.out.println(monotonicArray.isMonotonicArray(nums));;
	}
}
