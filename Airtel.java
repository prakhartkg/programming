package programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Airtel {
	
	
	/**
	 * {12, 3, 4, 1, 6, 9}
	 * 
	 * target 
	 */
	public static List<Integer> getSumTriplets(int[] nums,int target){
		Map<Integer,Integer> map = new HashMap<>();
		List<Integer> result = new ArrayList<>();
		
		for(int i =0;i<nums.length;i++) {
			for(int j=0;i<nums.length;j++) {
				int sum = nums[i]+nums[j];
				int comp = target-sum;
				if(map.containsKey(comp)) {
					result.add(i);
					result.add(j);
					result.add(map.get(comp));
					return result;
				}else {
					map.put(nums[j], j);
				}
			}
				
		}
		return result;
	}
	
	public static List<Integer> getSumTriplets2(int[] nums,int target){
		Map<Integer,Integer> map = new HashMap<>();
		List<Integer> result = new ArrayList<>();
		
		for(int i =0;i<nums.length;i++) {
			int comp = target-nums[i];
			if(map.containsKey(comp)) {
				for(int j =0;j<nums.length;j++) {
					int sum = nums[i]+nums[j];
					if(comp-sum==0) {
						result.add(i);
						result.add(j);
						result.add(map.get(comp));
						return result;
					}
				}
			}else {
				map.put(comp, i);
			}
		}
		return result;
	}


	
	public static void main(String[] args) {
		
		int[] nums = {12, 3, 4, 1, 6, 9};
		
		getSumTriplets2(nums, 24).forEach(System.out::println);
		
		
		
	}

}
