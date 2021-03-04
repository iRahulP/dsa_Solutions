package binaryTree;

public class binarySearchTree {

	private static binaryTreeNode<Integer> root;
	
	
	public static void main(String[] args) {
		binarySearchTree b1 = new binarySearchTree(); 
		b1.insertData(10);
		b1.insertData(20);
		b1.insertData(5);
		b1.insertData(15);
		b1.insertData(3);
		b1.insertData(7);
		
		b1.printTree();
		
		System.out.println("Updating");
		b1.deleteData(10);
		b1.printTree();
		
		
	}
	
	
	public void printTree() {
		printTree(root);
	}
	
	private static void printTree(binaryTreeNode<Integer> root) {
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
		
		printTree(root.left);

		printTree(root.right);
	
	}
	
	
	public void deleteData(int data) {
		//updates root after deletion 
		root = deleteDataHelper(data, root);
	}
	
	
	
	private binaryTreeNode<Integer> deleteDataHelper(int data, binaryTreeNode<Integer> root) {
		// TODO Auto-generated method stub
		if(root == null) {
			return null;
		}
		
		if(data < root.data) {
			//call delete on left
			root.left = deleteDataHelper(data,root.left);
			return root;
		}
		else if (data > root.data) {
			root.right = deleteDataHelper(data, root.right);
			return root;
		}
		//data == root
		else {
			if(root.left == null && root.right == null) {
				return null;
			}
			else if(root.left == null) {
				return root.right;
			}
			else if(root.right == null) {
				return root.left;
			}
			//case when root contains both children
			//need to decide which one to set root and link other part to new root.
			else {
				//finding minimum from right side
				binaryTreeNode<Integer> minNode = root.right;
				//base case to get the minimum node from right side
				while(minNode.left != null) {
					//sets newer Nodes
					minNode = minNode.left;
				}
				//setting new root data
				root.data = minNode.data;
				root.right = deleteDataHelper(minNode.data, root.right);
			return root;
			}
		}
	
	}



	private static binaryTreeNode<Integer> insertDataHelper(int data, binaryTreeNode<Integer> root){
	
		if(root == null) {
			binaryTreeNode<Integer> newNode = new binaryTreeNode<Integer>(data);
			return newNode;
		}
		
		if(root.data > data) {
			//left part
			//insert to left side
			root.left = insertDataHelper(data, root.left);
		}
		else {
			//right as well as == condition
			root.right = insertDataHelper(data, root.right);
		} 
		
		return root;
		
	}
	
	public void insertData(int data) {
		root = insertDataHelper(data, root);
	}
	
	
	
	
	private boolean hasDataHelper(int data, binaryTreeNode<Integer> root) {
		if(root == null) {
			return false;
		}
		
		if(root.data == data) {
			return true;
		}else if(data > root.data) {
			//call right
			return hasDataHelper(data, root.right);
		}else {
			//call left
			return hasDataHelper(data, root.left);
		}
		
	}
	
	public boolean hasData(int data) {
		return hasDataHelper(data, root);
	}

}
