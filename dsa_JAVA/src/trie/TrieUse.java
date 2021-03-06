package trie;

public class TrieUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie tr = new Trie();
		tr.add("this");
		tr.add("news");
		
		System.out.println(tr.search("news"));

		tr.remove("news");
		System.out.println(tr.search("news"));
	
	}

}
