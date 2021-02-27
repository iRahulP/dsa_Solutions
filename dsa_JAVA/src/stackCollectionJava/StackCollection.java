package stackCollectionJava;

import java.util.Stack;

public class StackCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Stack<Integer> sua = new Stack<Integer>();
	for(int i = 0; i < 5; i++) {
		sua.push(i);
	}
	System.out.println(sua.size());
	
	while(!sua.isEmpty()){
		try {
			System.out.println(sua.pop());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	}

}
