package trie;


class TrieNode{
	
	char data;
	boolean isTerminating;
	TrieNode children[];

	public TrieNode(char data) {
		this.data = data;
		isTerminating = false;
		children = new TrieNode[26];
	}


}


public class Trie {
	private TrieNode root;
	
	public Trie() {
		//creating root with data null
		root = new TrieNode('\0');
	}

	//Add an element in Trie => word
	public void add(TrieNode root, String word) {
		
		//base case
		if(word.length() == 0) {
			//setting termination so that NEWS is valid and not NEW
			root.isTerminating = true;
			return;
		}
		
		//letters index
		//getting index after reducing ascii count
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null) {
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
		}
		//recursion call for leftover word
		add(child, word.substring(1));
				
	}
	
	public void add(String word) {
		add(root, word);
	}
	
	
	
	//Search an Element in Trie
	public boolean search(String word, TrieNode root) {
		
		if(word.length() == 0) {
			return root.isTerminating;
		}
		
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null) {
			return false;
		}
		return search(word.substring(1), child);
	}
	
	public boolean search(String word) {
		return search(word, root);
	}
	
	
	public void remove(String word, TrieNode root) {
		
		if(word.length() == 0) {
			//set to not terminating
			root.isTerminating = false;
			return;
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		//if null then return as no such word
		if(child == null) {
			return;
		}
		//word letter present further
		remove(word.substring(1), child);	
	}
	
	
	public void remove(String word) {
		remove(word, root);
	}
	
	
	
}