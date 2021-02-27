package queue;

public class QueueUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueUsingArray q = new QueueUsingArray();
		
		for(int i = 1; i <= 10; i++) {
			try {
				q.enqueue(i);
			} catch (QueueFullException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			while(! q.isEmpty()){
				try {
					System.out.println(q.dequeue());
				} catch (QueueEmptyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
