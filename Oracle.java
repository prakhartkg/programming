package programming;

import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class Oracle {

	// -2,-3,4,-1,-2,1,5,3
	public static int getMax(int[] arr) {
		int maxSum = Integer.MIN_VALUE;
		int sum = arr[0];
		for(int i=1;i<arr.length;i++) {
			sum+=arr[i];
			maxSum = Math.max(maxSum, sum);		
			if(sum<0) {
				sum = 0;
			}	
		}
		return maxSum;
	}
	
	//   1->2->4->5->6-null
	/**
	 *  
	 *    Node current =node;
	 *    Node prev = current;
	 *    Node next = current.next;
	 *    while(current.next!=null){
	 *    	current.data = next.data;
	 *    	next = next.next;
	 *    	current = current.next;
	 *    }
	 *    previous.next =null;
	 *    
	 *    return node;
	 *    
	 *    
	 *    node.data = node.next.data;
	 *    node.next = node.next.next;
	 */
	enum Animals {
		LOIN,
		COW,
		DOG
	}
	private static class Test{
		
	}
	public static void main(String[] args) {
		Test test = new Oracle.Test();
		Animals[] animals = Animals.values();
		System.out.println(animals[1]);
		Comparator<Integer> numComp = (n1,n2)->n2.compareTo(n1);
		Integer arr[] = {4,2,1,3};
		Arrays.sort(arr,numComp);
		for(int i : arr) System.out.println(i);
		
		new HashSet<Exception>();
		new TreeSet<RuntimeException>();
		new TreeSet<FileNotFoundException>();
		//int[] input = {-2,-3,4,-1,-2,1,5,3};
		//System.out.println(getMax(input));
//		String s1 = "Hello";
//		s1+="world";
//		String s2 = "Hello";
//		s2+="";
//		s2+="world";
//		String s5 = new String("Helloworld");
//		String s6 = s5.intern();
//		String s3 = s1.intern();
//		String s4 = s2.intern();
//		System.out.println(s3==s4);
//		System.out.println(s3.equals(s4));
//		System.out.println(s3==s5);
//		System.out.println(s3==s6);
//		Display1 d = new Display1();
//		Display2 d2 = new Display2();
//		d.x=0;
//		d2.x=0;
//		d.cal(2);
//		d2.cal(2);
//		System.out.println(d.x+" "+d2.x);
		Integer n = 10;
		n++;
		assert n!=null;
		System.out.println(n);
	}

}

interface calculate{
	void cal(int item);
}
class Display1 implements calculate{
	int x;
	@Override
	public void cal(int item) {
		// TODO Auto-generated method stub
		x = item*item;
	}
	
}
class Display2 implements calculate{
	int x;
	@Override
	public void cal(int item) {
		// TODO Auto-generated method stub
		x = item/item;
	}
	
}



