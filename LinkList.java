package programming;

import java.util.Collections;
import java.util.PriorityQueue;

public class LinkList {

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static Node getList(int[] arr) {
		Node head = new Node(0);
		Node temp = head;
		for (int i : arr) {
			temp.next = new Node(i);
			temp = temp.next;
		}
		return head.next;
	}

	public static void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static Node reverseList(Node head) {
		Node current = head;
		Node prev = null;
		Node next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
		return head;
	}

	// I/P: 12->10->15->6->2->5
	// 1 2 3 4 5 6
	// O/P: 15->6->5

	public static Node removeGreaterRight(Node head) {

		head = reverseList(head);

		Node maxNode = head;
		Node current = head;
		while (current != null && current.next != null) {

			if (current.next.data < maxNode.data) {
				current.next = current.next.next;
			} else {
				current = current.next;
				maxNode = current;
			}
		}
		head = reverseList(head);
		return head;
	}

	public static Node mergeTwoSortedListUsingPriorityQueue(Node n1, Node n2) {
		Node result = new Node(0);
		Node current = result;
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		while (n1 != null) {
			q.add(n1.data);
			n1 = n1.next;
		}

		while (n2 != null) {
			q.add(n2.data);
			n2 = n2.next;
		}

		while (!q.isEmpty()) {
			int data = q.poll();
			Node n = new Node(data);
			current.next = n;
			current = current.next;
		}

		return result.next;

	}
	
	public static Node mergeTwoSortedList(Node n1, Node n2) {
		Node result = new Node(0);
		Node current = result;
		while(n1!=null && n2!=null) {
			if(n1.data<n2.data) {
				current.next = n1;
				n1 = n1.next;
			}else {
				current.next=n2;
				n2=n2.next;
			}
			current = current.next;
			
			if(n1==null) current.next = n2;
			if(n2==null) current.next = n1;
		}
		return result.next;
	}

}
