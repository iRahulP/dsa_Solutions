package queueCollection;

import java.util.Queue;
import java.util.LinkedList;

public class QueueCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Queue<Integer> sua = new LinkedList<Integer>();
	for(int i = 0; i < 5; i++) {
		sua.add(i);
	}
	System.out.println(sua.size());
	
	while(!sua.isEmpty()){
		try {
			System.out.println(sua.poll());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	}

}
