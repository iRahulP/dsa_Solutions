package treeUsingQueue;

public class numOfNodesTree {

	public static int numNodes(treeNode<Integer> root) {
		//just an edge case
		if(root == null) {
			return 0;
		}
		
		//count for root
		int count = 1;
		
		for(int i = 0; i < root.children.size(); i++) {
			count = count + numNodes(root.children.get(i));
		}
		return count;
	}
}
