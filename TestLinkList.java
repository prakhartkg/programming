package programming;

public class TestLinkList {

	public static void main(String[] args) {
//		int[] arr = {10,11,12,13};
//		Node head = LinkList.getList(arr);
//		LinkList.printList(head);
//		head = LinkList.reverseList(head);
//		LinkList.printList(head);
//		int a[] = {16,10,15,6,2,5};
//		LinkList.printList(LinkList.removeGreaterRight(LinkList.getList(a)));
		int[] arr1 = {5,10,12};
		int[] arr2 = {2,4,8};
		//LinkList.printList(LinkList.mergeTwoSortedListUsingPriorityQueue(LinkList.getList(arr1), LinkList.getList(arr2)));
		LinkList.printList(LinkList.reverseList(LinkList.mergeTwoSortedList(LinkList.getList(arr1), LinkList.getList(arr2))));
	}

}
