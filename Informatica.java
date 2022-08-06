package programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


class Node{
	Node next;
	int value;
	public Node(int value) {
		this.value = value;
		this.next = null;
	}
	
	public void printNodes() {
		Node head = this;
		while (head.next!=null) {
			System.out.println(head.value);
			head = head.next;
		}
	}
}


public class Informatica {
	
	
	
	public static Node mergeKsortedLinkList(List<Node> lists) {
		
		PriorityQueue<Node> q = new PriorityQueue<>((n1,n2) -> Integer.compare(n1.value, n2.value));
		for(Node n :lists) {
			q.offer(n);
		}
		Node head = new Node(0);
		Node p = head;
		while (!q.isEmpty()) {
			Node n = q.poll();
			p.next = n;
			p=p.next;
			
			if(n.next!=null) {
				q.offer(n.next);
			}
			
		}
		return head.next;
	}

	public static List<Integer> mergeSortedLists(List<List<Integer>> lists){
			
		PriorityQueue<Integer> sortedList = new PriorityQueue<>();
		
		for(List<Integer> l : lists) {
			sortedList.addAll(l);
		}
		List<Integer> results = new ArrayList<>();
		while(!sortedList.isEmpty()) {
				results.add(sortedList.poll());
		}
		return results;
	}
	
	/**
	 * 
	 * Input: intervals = [[1,2],[2,3],[2,4],[4,5],[8,10],[9,10]]
	 *
	 */

	public static int getMinMeetingRooms(int[][] meetings) {
		//Sort on start time
		Arrays.sort(meetings, (m1,m2)->Integer.compare(m1[0], m2[0]));
		
		PriorityQueue<Integer> rooms = new PriorityQueue<>();
		
		for(int[] meeting : meetings) {
			if(rooms.isEmpty()) {
				rooms.add(meeting[1]);
			}else{
				if(rooms.peek()>meeting[0]) {
					rooms.add(meeting[1]);
				}else {
					rooms.remove();
					rooms.add(meeting[1]);
				}
			}
			
		}
		return rooms.size();
	}
	
	public static void main(String[] args) {
		
		/*
		 *	int[][] input  = {{1,2},{2,3},{2,4},{4,5},{8,10},{9,10},{3,7},{4,8}};
		 *	System.out.println(getMinMeetingRooms(input));
		 *
		 */
		
		/*
		 * List<List<Integer>> lists = new ArrayList<>();
		 * 
		 * lists.add(Arrays.asList(new Integer[] {2,5,7,10}));
		 * lists.add(Arrays.asList(new Integer[] {1,4,9})); lists.add(Arrays.asList(new
		 * Integer[] {3,6,8}));
		 * 
		 * List<Integer> results = mergeSortedLists(lists);
		 * results.stream().forEach(System.out::println);
		 */
		
		List<Node> lists = new ArrayList<>();
		Node n1 = new Node(2);
		n1.next = new Node(5);
		n1.next.next= new Node(7);
		n1.next.next.next =new Node(10);
		
		Node n2 = new Node(1);
		n2.next = new Node(4);
		n2.next.next = new Node(9);
		
		Node n3 = new Node(3);
		n3.next=new Node(6);
		n3.next.next = new Node(8);
		lists.add(n1);
		lists.add(n2);
		lists.add(n3);
		mergeKsortedLinkList(lists).printNodes();
		
	}

}
