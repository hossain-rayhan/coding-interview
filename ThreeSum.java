package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {
		int[] nums = {2, 5, 1, -3, 7, -4, -1};
		ThreeSum obj = new ThreeSum();
		
		for( List<Integer> l: obj.threeSumSortAndTwoPointer(nums)) {
			System.out.println(l.toString());
		}
	}
	
	// Using 3 loop approach
	// Time Complexity: O(N^3)
	// Space Complexity: O(1)
	public List<List<Integer>> threeSumThreeLoop(int[] nums){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for(int i = 0; i < nums.length - 2; i++) {
			for(int j = i+1; j < nums.length - 1; j++) {
				for(int k = j+1; k < nums.length; k++) {
					if(nums[i] + nums[j] + nums[k] == 0) {
						List<Integer> temp = new ArrayList<>();
		                temp.add(nums[i]);
		                temp.add(nums[j]);
		                temp.add(nums[k]);
		                list.add(temp);
					}
				}
			}
		}
		return list;
	}
	
	// Using HashMap
	// Time Complexity: O(N^2)
	// Space Complexity: O(N)
	public List<List<Integer>> threeSumUsingMap(int[] nums){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		
		// Map of (number, index)
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		
		for(int i = 0; i < nums.length - 2; i++) {
			for(int j = i+1; j < nums.length - 1; j++) {
				int searchValue = 0 - (nums[i] + nums[j]);
				if(map.containsKey(searchValue)) {
					// We want to add only one triple with same values
					int index = map.get(searchValue);
					if(index > j) {
						List<Integer> temp = new ArrayList<>();
	                    temp.add(nums[i]);
	                    temp.add(nums[j]);
	                    temp.add(searchValue);
	                    list.add(temp);
					}
				}
			}
		}
		return list;
	}
	
	// Efficient one for LeetCode- 15
	// Sort the array and use 2-pointer approach
	// Time Complexity: O(N^2)
	// Space Complexity: O(1)
	public List<List<Integer>> threeSumSortAndTwoPointer(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        
        Arrays.sort(nums);
        for(int i = 0; i <= nums.length - 3; i++){
        		// If the number at this index is > 0, there is no possibility
        		// we will get a triple whose sum is zero. Because, the array is sorted.
        		if(nums[i] > 0)
        			return list;
        		// If current index number is same to the previous one, skip
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            
            int left = i + 1;
            int right = nums.length - 1;
                      
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum > 0){
                    right--;
                }else if(sum < 0){
                    left++;
                }else{
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    list.add(temp);
                    left++;
                    right--;
                    while( left < nums.length && nums[left] == nums[left-1]){
                        left++;
                    }
                    while(right > i && nums[right] == nums[right+1]){
                        right--;
                    }
                }
            }
        }
        return list;
    }
}

