package treeUsingQueue;

import java.util.Scanner;

public class treeUse {
	
		public static void main(String[] args) {
			
			treeNode<Integer> root = takeInputLevelWise();
			printLevelWise(root);
			System.out.println("Total Nodes :"+numOfNodesTree.numNodes(root));
			System.out.println("Largest : "+largest(root));
			System.out.println("Height of Tree : "+height(root));
			System.out.println("Elements at 2nd level : ");
			printAtK(root,2);
			System.out.println("Total leafs :"+leafCount(root));
			preOrder(root);
			System.out.println();
			postOrder(root);
		}
		
		public static void preOrder(treeNode<Integer>root) {
			if(root == null) {
				return;
			}
			System.out.print(root.data);
			
			for(int i = 0; i< root.children.size(); i++) {
				preOrder(root.children.get(i));
			}
		}
		
		public static void postOrder(treeNode<Integer>root) {
			if(root == null) {
				return;
			}
			for(int i = 0; i< root.children.size(); i++) {
				postOrder(root.children.get(i));
			}

			System.out.print(root.data);
		}
		
		
		public static void printAtK(treeNode<Integer> root ,int k) {
			if(k < 0) {
				return;
			}
			if(k == 0) {
				System.out.println(root.data);
			}
			
			for(int i = 0; i < root.children.size(); i++) {
				printAtK(root.children.get(i), k-1);
			}
			
		}
		
		private static int leafCount(treeNode<Integer> root) {
			// TODO Auto-generated method stub
			if(root == null) {
				return 0;
			}
			
			if(root.children.size() == 0) {
				return 1;
			}

			int counter = 0;
			for(int i=0; i < root.children.size(); i++) {
				int childVal= leafCount(root.children.get(i));
				counter = counter + childVal;
			}
			return counter;
		}
		
		
		private static int height(treeNode<Integer> root) {
			// TODO Auto-generated method stub
			if(root == null) {
				return 0;
			}
			int height = 0;
			
			for(int i=0; i < root.children.size(); i++) {
				int childVal= height(root.children.get(i));
				if(childVal > height) {
					height = Math.max(height, childVal);
				}
			}

			return height+1;
			
		}



		public static int largest(treeNode<Integer> root) {
			if(root == null) {
				return Integer.MIN_VALUE;
			}
			
			int largest = root.data;
			
			for(int i=0; i < root.children.size(); i++) {
				int childVal= largest(root.children.get(i));
				if(childVal > largest) {
					largest = childVal;
				}
			}
			
			return largest;
		}
		
		public static void printLevelWise(treeNode<Integer> root) {
			QueueUsingLL<treeNode<Integer>> pendingPrints = new QueueUsingLL<>();
			
			pendingPrints.enqueue(root);
			while(! pendingPrints.isEmpty()) {
				try {
					treeNode<Integer> frontNode = pendingPrints.dequeue();
					String s = frontNode.data+": ";
					for (int i = 0; i < frontNode.children.size() ; i++ ) {
						s = s + ""+frontNode.children.get(i).data+",";
						pendingPrints.enqueue(frontNode.children.get(i));
					}
					System.out.println(s);
					
				} catch (QueueEmptyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

			
		}
		
		public static treeNode<Integer> takeInputLevelWise(){
			Scanner s = new Scanner(System.in);
			System.out.println("Enter root data");
			int rootData = s.nextInt();
			QueueUsingLL<treeNode<Integer>> pendingNodes = new QueueUsingLL<>();
			
			treeNode<Integer> root = new treeNode<Integer>(rootData);
			
			pendingNodes.enqueue(root);
			while(! pendingNodes.isEmpty()) {
				try {
					treeNode<Integer> frontNode = pendingNodes.dequeue();
					System.out.println("Enter no. of children of "+frontNode.data);
					int childOfCurrent =  s.nextInt();
					
					for (int i = 0; i < childOfCurrent ; i++ ) {
						System.out.println("Enter "+(i+1)+"th child of "+frontNode.data);
						int childData = s.nextInt();
						treeNode<Integer> childNode = new treeNode<Integer>(childData);
						frontNode.children.add(childNode);
						pendingNodes.enqueue(childNode);
						
					}
					
				} catch (QueueEmptyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			return root;
		}
		
		

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
		
		
}
