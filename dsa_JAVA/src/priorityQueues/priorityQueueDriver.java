package priorityQueues;

public class priorityQueueDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		priorityQueue pq = new priorityQueue();
		int arr[] = {5,1,8,4,2,8,9,0,23,6,223};
	
		for(int i = 0 ; i < arr.length ; i++) {
			pq.insert(arr[i]);
		}
	
//		System.out.println(pq);
		
		while(! pq.isEmpty()) {
			try {
				System.out.println(pq.removeMin()+" - removed!");
			} catch (priorityQueueEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println();
	}

}
