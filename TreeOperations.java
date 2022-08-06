package programming;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

/**
 * 
 * @author prakharjain
 *
 *			1
 *		2		3
 *	4	   5  6		7
 *
 */
class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	public TreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class TreeOperations{	
	

	public static Vector<Integer> getListOfRootsofSubTreeOnDeletingNode(TreeNode root, int nodeToBeRemoved){
		Vector<Integer> results = new Vector<>();
		
		if(root!=null && root.data!=nodeToBeRemoved) 
			results.add(root.data);
		
		// Recursive 
		removeNode(root, nodeToBeRemoved, results);
		
		
		return results;
	}
	
	public static void printCousins(TreeNode root, int node) {
		
		Queue<TreeNode> q = new LinkedList<>();
		boolean found = false;
		TreeNode tNode;
		q.add(root);
		int size =0;
		while (!q.isEmpty() && !found) {
			size = q.size();
			while(size>0) {
				tNode = q.poll();
				if((tNode.left!=null && tNode.left.data==node) || ( tNode.right!=null && tNode.right.data==node)) {
					found=true;
				}else {
					if (tNode.left != null)
	                    q.add(tNode.left);
	                if (tNode.right!= null)
	                    q.add(tNode.right);
				}
			}
		}
		
		if(found) {
			while (!q.isEmpty()) {
				tNode = q.poll();
				System.out.println(tNode.data);
			}
		}else {
			System.out.println("Node not found");
		}
		
	}
	
	public static TreeNode removeNode(TreeNode root, int nodeToBeRemoved,List<Integer> results) {
		if(root==null) return null;
		
		if(root.data == nodeToBeRemoved) {
			if(root.left!=null) results.add(root.left.data);
			if(root.right!=null) results.add(root.right.data);
			return null;
		}
		root.left = removeNode(root.left,nodeToBeRemoved,results);
		root.right = removeNode(root.right,nodeToBeRemoved,results);
		
		return root;
	}
	
	/**
	 * Delete Given node and return list of roots of subtree formed after removing that node.
	 * @param root
	 * @param nodeToBeRemoved
	 * @return   list of roots of subtree
	 */
	public static List<Integer> getListOfRootsOfSubTreeNonRecursive(TreeNode root,int nodeToBeRemoved){
		List<Integer> results = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		
		if(root!=null && root.data!=nodeToBeRemoved) 
			results.add(root.data);
		
		
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode current = stack.pop();
			if(current.data == nodeToBeRemoved) {
				if(current.left!=null) results.add(current.left.data);
				if(current.right!=null) results.add(current.right.data);
			}
			if(current.right!=null)	stack.push(current.right);
			if(current.left!=null) stack.push(current.left);
		}
		return results;
	}
	
	
	
	public static void main(String[] args) {	
		TreeNode root = buildTree();
		//printResults(getListOfRootsOfSubTreeNonRecursive(root, 4));
		//reverseLevelOrder(root);
		printCousins(root, 5);
	}
	
	public static TreeNode buildTree() {
		
		TreeNode root = new TreeNode(1);  // Root
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		

		//root.right.right = new TreeNode(6);
		
		//root.right.right.left = new TreeNode(7);
		
		return root;
	}
	
	public static void reverseLevelOrder(TreeNode root) {
		List<Integer> results = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		Stack<Integer> s = new Stack<>();
		q.add(root);
		s.add(root.data);
		while (!q.isEmpty()) {
			TreeNode current = q.poll();
			if(current.left!=null) {
				q.add(current.left);
				s.add(current.left.data);
			}
			if(current.right!=null) {
				q.add(current.right);
				s.add(current.right.data);
			}
		}
		while (!s.isEmpty()) {
			System.out.println(s.pop() + " ");
		}
	
	}
	
	public static void printResults(List<Integer> results) {
		results.stream().forEach(n->System.out.print(n+" "));
	}
	

}
