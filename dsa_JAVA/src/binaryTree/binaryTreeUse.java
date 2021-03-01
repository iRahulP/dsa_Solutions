package binaryTree;
import java.util.Scanner;

public class binaryTreeUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		binaryTreeNode<Integer> root= new binaryTreeNode<Integer>(1);
//		binaryTreeNode<Integer> node1= new binaryTreeNode<Integer>(2);
//		binaryTreeNode<Integer> node2= new binaryTreeNode<Integer>(3);
//		root.left  = node1;
//		root.right = node2;
	//Scanner sc = new Scanner(System.in);
	binaryTreeNode<Integer> root = takeInputLevel();
	print(root);
	//sc.close();
	System.out.println();
	printLevel(root);
	
	System.out.println();
	System.out.println("Total Nodes : "+count(root));
	System.out.println();
		
	System.out.println("Normal : "+diameter(root));
	System.out.println("Optimized Diameter:"+heightDiameter(root).second);

	System.out.println("Optimized Height:"+heightDiameter(root).first);
	
	}
	
	public static int count(binaryTreeNode<Integer> root) {
		
		if(root == null) {
			return 0;
		}
		
		int counter = 1;
		counter += count(root.left);
		counter += count(root.right);		
		return counter;
	}

	public static binaryTreeNode<Integer> takeInputLevel(){
		Scanner sc = new Scanner(System.in);
		
		QueueUsingLL<binaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<binaryTreeNode<Integer>>();
		int rootData;
		System.out.println("Enter root data : ");
		rootData = sc.nextInt();
		if(rootData == -1) {
			return null;
		}
		binaryTreeNode<Integer> root = new binaryTreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);
		while(! pendingNodes.isEmpty()) {
			binaryTreeNode<Integer> frontNode = null;
			try {
				frontNode = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Enter left child of "+frontNode.data);
			int leftChild = sc.nextInt();
			if(leftChild != -1) {
				binaryTreeNode<Integer> child = new binaryTreeNode<Integer>(leftChild);
				pendingNodes.enqueue(child);
				frontNode.left = child;
			}
			
			System.out.println("Enter right child of "+frontNode.data);
			int rightChild = sc.nextInt();
			if(rightChild != -1) {
				binaryTreeNode<Integer> child = new binaryTreeNode<Integer>(rightChild);
				pendingNodes.enqueue(child);
				frontNode.right = child;
			}
			
		}
		
		return root;
	}
	
	
	public static void printLevel(binaryTreeNode<Integer> root) {
		
		QueueUsingLL<binaryTreeNode<Integer>> pendingPrints = new QueueUsingLL<binaryTreeNode<Integer>>();
		pendingPrints.enqueue(root);
		while(! pendingPrints.isEmpty()) {
			try {
				binaryTreeNode<Integer> frontNode = pendingPrints.dequeue();
				String toBePrinted = frontNode.data+" :";
				
				if(frontNode.left != null) {
					toBePrinted = toBePrinted + "L:"+frontNode.left.data+",";
					pendingPrints.enqueue(frontNode.left);
				}
				if(frontNode.right != null) {
					toBePrinted = toBePrinted + "R:"+frontNode.right.data+",";
					pendingPrints.enqueue(frontNode.right);
					}
				System.out.println(toBePrinted);
				
			} catch (QueueEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
	}
	
	
	public static binaryTreeNode<Integer> takeInput(Scanner sc){
		System.out.println("Enter root data : ");
		int rootData = sc.nextInt();
		if(rootData == -1) {
			return null;
		}
		
		binaryTreeNode<Integer> root = new binaryTreeNode<Integer>(rootData);
		root.left = takeInput(sc);
		root.right = takeInput(sc);
		
		
		return root;
	}
	
	
	public static void print(binaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		String toBePrinted = root.data+" :";
		if(root.left != null) {
			toBePrinted = toBePrinted + "L:"+root.left.data+",";
		}
		if(root.right != null) {
			toBePrinted = toBePrinted + "R:"+root.right.data+",";
		}
		System.out.println(toBePrinted);
		
		print(root.left);

		print(root.right);
	
	}
	
	public static int diameter(binaryTreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		
		int option1 = height(root.left) + height(root.right);
		int option2 = diameter(root.left);
		int option3 = diameter(root.right);
		
		
		return Math.max(option1, Math.max(option2, option3));
	}

	private static int height(binaryTreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		
		return 1 + Math.max(height(root.left), height(root.right));
	}
	
	//optimized
	public static Pair<Integer, Integer> heightDiameter(binaryTreeNode<Integer> root){
		if(root == null) {
			Pair<Integer, Integer> op = new Pair<>();
			op.first =0;
			op.second=0;
			return op;
		}
		
		//left height and diam
		Pair<Integer, Integer> lop = heightDiameter(root.left);
		
		//right height and diam
		Pair<Integer, Integer> rop = heightDiameter(root.right);
		
		int height = 1+ Math.max(lop.first, rop.first);
		int op1 = lop.first + rop.first;
		int op2 = lop.second;
		int op3 = rop.second;
		
		int diameter = Math.max(op1, Math.max(op2, op3));
		
		Pair<Integer, Integer> op = new Pair<>();
		op.first =height;
		op.second=diameter;
		
		return op;
	}
	
	public static void inOrder(binaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}

	public static void preOrder(binaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data+" ");
		
		preOrder(root.left);
		preOrder(root.right);
	}

	public static void postOrder(binaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+" ");
		
	}

	public static binaryTreeNode<Integer> buildTreeHelper(int in[], int pre[], int inS, int inE, int preS, int preE){
		if(inS > inE) {
			return null;
		}
		int rootData = pre[preS];
		binaryTreeNode<>
		
	}
	
	public static binaryTreeNode<Integer> buildTree(int in[], int pre[]){
		return buildTreeHelper(in, pre, 0, in.length -1,0, pre.length -1);
	}



}
