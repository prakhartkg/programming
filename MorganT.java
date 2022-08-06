package programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MorganT {


	public static void main(String[] args) {
		String[] arr = {"ate","eat","tea","but","tub","bat"};
		List<List<String>> results = mapAnnagrams(arr);
		results.forEach(l->{
			System.out.println(Arrays.toString(l.toArray()));
		});
	}

	
	
	private static List<List<String>> mapAnnagrams(String[] arr) {
		Map<String, List<String>> hashResults = new HashMap<>();
		for(String s : arr) {
			char[] hash = new char[26];
			for(char ch : s.toCharArray()) {
				hash[ch-'a']++;
			}
			String strHash = new String(hash);
			if(!hashResults.containsKey(strHash)) {
				hashResults.put(strHash, new ArrayList<>(Arrays.asList(s)));
			}else {
				List<String> list = hashResults.get(strHash);
				list.add(s);
				hashResults.put(strHash, list);
			}
			
		}
		return hashResults.entrySet().stream().map(e->e.getValue()).collect(Collectors.toList());
	}

}
