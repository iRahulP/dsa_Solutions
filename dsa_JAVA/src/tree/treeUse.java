package tree;

import java.util.Scanner;

public class treeUse {

	public static treeNode<Integer> takeInput(Scanner sc) {
		
		int data;
		System.out.println("Enter next node Data: ");
		data = sc.nextInt();
		treeNode<Integer> root = new treeNode<Integer>(data);
		System.out.println("Enter number of chindren for: "+data);
		int child_count = sc.nextInt();
		
		for(int i = 0; i < child_count; i++) {
			treeNode<Integer> child = takeInput(sc);
			root.children.add(child);
		}
		return root;
	}
	
	public static void print(treeNode<Integer> root) {
		String s = root.data+": ";
		for(int i=0; i< root.children.size(); i++) {
			s = s + ""+root.children.get(i).data+",";
		}
		System.out.println(s);
		for(int i=0; i< root.children.size(); i++) {
			print(root.children.get(i));
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		treeNode<Integer> root = takeInput(sc);
		print(root);
//		treeNode<Integer> root = new treeNode<Integer>(4);
//		treeNode<Integer> node1 = new treeNode<Integer>(2);
//		treeNode<Integer> node2 = new treeNode<Integer>(3);
//		treeNode<Integer> node3 = new treeNode<Integer>(1);
//		treeNode<Integer> node4 = new treeNode<Integer>(5);
//		treeNode<Integer> node5 = new treeNode<Integer>(7);
//			
//		
//		root.children.add(node1);
//		root.children.add(node2);
//		node2.children.add(node3);
//		node2.children.add(node5);
//		node3.children.add(node4);
//		
//		System.out.println(root);
	}

	

	

}
