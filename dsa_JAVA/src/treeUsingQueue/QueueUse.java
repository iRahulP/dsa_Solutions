package treeUsingQueue;

public class QueueUse {

	public static void main(String[] args) throws QueueEmptyException {
		// TODO Auto-generated method stub

		QueueUsingLL<Integer> sua = new QueueUsingLL();
		for(int i = 0; i < 5; i++) {
			sua.enqueue(i);
		}
		System.out.println(sua.size());
		
		while(!sua.isEmpty()){
			System.out.println(sua.dequeue());
		}

		
	}

}
