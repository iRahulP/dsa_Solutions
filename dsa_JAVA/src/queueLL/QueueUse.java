package queueLL;

import stackLL.StackUsingLL;

public class QueueUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		QueueUsingLL<Integer> sua = new QueueUsingLL();
		for(int i = 0; i < 5; i++) {
			sua.enqueue(i);
		}
		System.out.println(sua.size());
		
		while(!sua.isEmpty()){
			try {
				System.out.println(sua.dequeue());
			} catch (queueLL.QueueEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	}

}
