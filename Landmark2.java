package programming;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Landmark2 {

	/**
	 * Mpp<Integer,Integer>  sort this according to value in decending order
	 * 
	 * 
	 * wap for you have to complete 4 task  where after completing 3 task together then execute 4th task
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, Integer> map = new HashMap<>();
		map.put(1, 2);
		map.put(2, 8);
		map.put(3, 5);
		map.put(4, 1);
		Map<Integer, Integer> sortedMap = getSortedMap(map);
	}
	
	
	
	
	public static void m1Response() {
		// call microservice 1
		// call microservice 2
		// call microservice 3
		
		// call microservice 4  depends on 1 2 3
		
		
		
	}
	

	private static Map<Integer, Integer> getSortedMap(Map<Integer, Integer> map) {
	//.	map.entrySet().stream().sorted((e1,e2)->e1.getValue()>e2.getValue());
		//Collections.sort(map.entrySet(),(e1,e2)->e.getValue()>e2.getValue());
		
		return map;
	}

}
