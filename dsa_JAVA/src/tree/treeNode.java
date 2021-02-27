package tree;

import java.util.ArrayList;

public class treeNode<T> {
	T data;
	ArrayList<treeNode<T>> children;
	
	public treeNode(T data) {
		this.data = data;
		children = new ArrayList<>();
	}
	
}
