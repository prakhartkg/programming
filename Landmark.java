package programming;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Landmark {

	
	/**
	 * 
	 * Given two strings, one is a text string and other is a pattern string.
	 * The task is to print the indexes of all the occurences of pattern string in the text string.
	 * For printing, Starting Index of a string should be taken as 1.
	 * 
	 * S = "batmanandrobinarebat", pat = "bat"
	 * 
	 * 1,18  n*m
	 */
	public static List<Integer> findIndex(String text, String pattern){
		List<Integer> result = new ArrayList<>();
		int i =0;
		int j = pattern.length();
		while(i<text.length()+1-j) {
			String s = text.substring(i, i+j);
			if(s.equals(pattern)) {
				result.add(i+1);
			}else i++;
		}
		
		
		return result ;
	}
	
	
	/**
	 * 
	 * @param args
	 * Given two strings s1, s2, find the length of the shortest string that both
	 *  s1 and s2 as subsequences.
		example: s1=land s2=mark, ans= 7 (lmandrk)  lmandrk
		s1=GEEK, s2=EKE    s = GEEKE
		ans : 5
		
		
	 */
	public static int lcs(String s1, String s2) {
		char[] x = s1.toCharArray();
		char[] y = s2.toCharArray();
		int m = x.length;
		int n = y.length;
		int[][] res = new int[m+1][n+1];
		
		for(int i =0;i<=m;i++) {
			for(int j =0; j<=n;j++) {
				if(i==0 || j==0)  
					res[i][j] = 0;
				else if(x[i-1]==y[j-1]) 
					res[i][j]=res[i-1][j-1]+1;
				else 
					res[i][j] =  Math.max(res[i][j-1], res[i-1][j]);
			}
		}
		
		return res[m][n];
	}
	public static int minLengthSubsequence(String s1,String s2) {
		
		return s1.length()+s2.length()-lcs(s1, s2);
	}
	
	public static void main(String[] args) {
		//List<Integer> result  = findIndex("batmanandrobinarebat", "bat");
		//result.stream().forEach(System.out::println);;
		System.out.println(minLengthSubsequence("land", "mark"));
		System.out.println(minLengthSubsequence("GEEK", "EKE"));
	}
}
