package programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Sollution {
	
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> maps = new HashMap<>();
        for(String s : strs){
            char[] hash = new char[26];
            for(char ch : s.toCharArray()){
                hash[ch-'a']++;
                System.out.println(hash);
            }
            String str = new String(hash);
            System.out.println(str);
            if(!maps.containsKey(str)){
               maps.put(str,new ArrayList<>());
                
            }
            maps.get(str).add(s);
        } 
        List<List<String>> results = new ArrayList<>();
        results.addAll(maps.values());
        return results;
    }
    
    public static void main(String[] args) {
    	String[] arrs = {"bat","tab","eat"};
    	groupAnagrams(arrs);
    }
}