package main;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
	public static void main(String[] args) {
		int[] list = {1, 2, 5, 7};
		int sum = 8;
		
		TwoSum obj = new TwoSum();
		System.out.println(Arrays.toString(obj.twoSumUsingMap(list, sum)));
	}
	
	// Works for both sorted and unsorted array
	// Time Complexity: O(N)
	// Space Complexity: O(N)
	int[] twoSumUsingMap(int[] list, int sum) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < list.length; i++) {
			if(map.containsKey(sum - list[i])){
                return new int[] {sum - list[i], list[i]};
            }else {
            		map.put(list[i], i);
            }
		}
		return null;
	}	
	
	// Works for both sorted and unsorted array
	// Time Complexity: O(N^2)
	// Space Complexity: O(1)
	int[] twoSumTwoLoop(int[] list, int sum) {
		for(int i = 0; i < list.length; i++) {
			for(int j = i + 1; j < list.length; j++) {
				if(list[i] + list[j] == sum)
					return new int[]{list[i], list[j]};
			}
		}
		return null;
	}
	
	// Works only when the array is sorted
	// Binary Search approach
	// Time Complexity: O(NlogN)
	// Space Complexity: O(1)
	int[] twoSumBinarySearh(int[] list, int sum) {
		for(int i = 0; i < list.length - 1; i++) {
			int start = i + 1;
			int end = list.length - 1;
			int searchValue = sum - list[i];
			while(start <= end) {
				int mid = (start + end)/2;
				if(list[mid] < searchValue) {
					start = mid + 1;
				}else if(list[mid] > searchValue) {
					end = mid - 1;
				}else{ 
					return new int[] {list[i], list[mid]};
				}
			}
		}
		return null;
	}
	
	// Works only when the array is sorted
	// Two Pointer approach
	// Time Complexity: O(N)
	// Space Complexity: O(1)
	int[] twoSumTwoPointer(int[] list, int sum) {
		int start = 0;
		int end = list.length - 1;
		while(start < end) {
			if(list[start] + list[end] == sum) {
				return new int[] {list[start], list[end]};
			}else if(list[start] + list[end] < sum) {
				start = start + 1;
			}else {
				end = end - 1;
			}
		}
		return null;
	}
}


