package programming;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class ATMQueue {

	static class Person{
		int position;
		int amount;
		public Person(int position, int amount) {
			super();
			this.position = position;
			this.amount = amount;
		}
		
	}
	
	public static int[] getOrder(int[] amount, int k) {
		int[] result = new int[amount.length];
		Queue<Person> q = new LinkedList<>();
		for(int i =0;i<amount.length;i++) {
			q.offer(new Person(i, amount[i]));
		}
		int i=0;
		while(!q.isEmpty()) {
			Person p = q.poll();
			int remaining = p.amount-k;
			if(remaining>=0) {
				p.amount = remaining;
				q.offer(p);
			}else{
				result[i]=p.position+1;
				i++;
			}
		}
		
		return result;
	}
	public static void main(String[] args) {
		int[] results = getOrder(new int[] {2,5,1}, 2);
		IntStream.of(results).forEach(System.out::print);
	}
}
