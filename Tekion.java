package programming;

/**
 * 
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
   Output: [1,1,2,3,4,4,5,6]
	Explanation: The linked-lists are:
	[
  1->4->5,
  1->3->4,
  2->6
	]
	merging them into one sorted list:
	1->1->2->3->4->4->5->6
 *
 */


public class Tekion {

	static class Node{
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public static Node mergeLinkLists(Node first, Node second) {
		Node result = new Node(0);
		Node current = result;
		while(first!=null && second!=null) {
			
			if(first.data<=second.data) {
				current.next = first;
				first = first.next;
			}else {
				current.next = second;
				second=second.next;
			}
			current = current.next;
			current.next=null;
		}
		
		if(first == null) current.next = second;
		if(second == null) current.next = first;
		
		return result.next;
	}
	
	
	/**
	 * Binary Search
	 * 
	 *  1 2 3 4 5 6 7 8
	 *  
	 *  
	 * 
	 */

	public static boolean binSearch(int[] arr, int target) {
		int l = 0;
		int r = arr.length-1;
		while(l<r) {
			int mid = (l+r)/2;  // need to check  l+ r-l/2
			
			if(arr[mid]==target) {
				return true;
			}
			if(target<arr[mid]) {
				r = mid-1;
			}else {
				l = mid+1;
			}
			
		}
		return false;
	}
	
	public static void main(String[] args) {
//		Node n1 = new Node(1);
//		n1.next = new Node(4);
//		n1.next.next = new Node(5);
//		
//		Node n2 = new Node(1);
//		n2.next = new Node(3);
//		n2.next.next = new Node(4);
//		
//		Node n3 = new Node(2);
//		n3.next = new Node(6);
//		
//		Node result = mergeLinkLists(n1, n2);
//		result = mergeLinkLists(n3, result);
//		
//		while(result!=null) {
//			System.out.println(result.data);
//			result = result.next;
//		}
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
		System.out.println(binSearch(arr, 9));
	}
}
