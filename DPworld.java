package programming;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class DPworld {

	
	
	
	/*
	 * 5 5 4
	 * input =  5 5 6 2 3 4 2 5 7 9 ​ k = 3
	 * output = 6 6 4 5 7 9
	 * 
	 * max = 6
	 * 
	 *  6 2 3  
	 *  
	 *  
	 *  6
	 *  
	 * 
	 */
	
	
	
	public static List<Integer> getMax(List<Integer> list, int k){
		List<Integer> results = new ArrayList<>();
		Deque<Integer> q = new LinkedList<>();
		
		
		return results;
		
	}
	
	
	
	
	// Input: String="oidbcaf", Pattern="abc"
	
	// ab      //aab
	
	public static boolean matchWordPerm(String input, String pattern) {
		
		Map<Character, Integer> f = new HashMap<>();
		for(char ch : input.toCharArray()) {
				f.put(ch, f.getOrDefault(ch, 0)+1);
		}
		
		for(char ch : pattern.toCharArray()) {
				
			if(!f.containsKey(ch)) return false;
			else {
				int count = f.get(ch);
				f.put(ch, --count);
				if(count<0) return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(matchWordPerm("zbhcwa", "abc"));
	}

}
