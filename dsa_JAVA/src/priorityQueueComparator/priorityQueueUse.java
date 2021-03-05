package priorityQueueComparator;

import java.util.PriorityQueue;
import java.util.Comparator;


class MaxPQComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		if(o1 < o2) {
			return 1;
		}else if(o1 > o2) {
			return -1;
		}
		return 0;
	}
	
}

class MinPQComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		if(o1 < o2) {
			return -1;
		}else if(o1 > o2) {
			return 1;
		}
		return 0;
	}
	
}


class StringLengthComparator implements Comparator<String>{


	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		if(o1.length() < o2.length()) {
			return -1;
		}else if(o1.length() > o2.length()) {
			return 1;
		}
		return 0;
	}
	
}


public class priorityQueueUse {
	
	


	public static void printkLargest(int arr[], int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int i= 0;
		//assuming initial 3 elements as my largest
		for(; i < k ; i++) {
			pq.add(arr[i]);
		}
		
		//updating largest k elements
		for(; i < arr.length; i++) {
			int min = pq.element();//gets minimum element
			if(min < arr[i]) {
				pq.remove();
				pq.add(arr[i]);
			}
		}
		
		while(! pq.isEmpty()) {
			System.out.println(pq.remove());
		}
		
	}
	
	
	
	public static void sortKSorted(int arr[], int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		//initially k elements would have the first element
		//getting first k elem in pq.
		int i =0;
		for(; i < k; i++) {
			pq.add(arr[i]);
		}
		
		//get first element -> minimum as per priority
		for(; i < arr.length; i++) {
			arr[i-k] = pq.remove();
			pq.add(arr[i]);
		}
		
		for(int j = arr.length - k; j < arr.length; j++) {
			arr[j] = pq.remove();
		}
		
		
	}
	
	//using inbuilt Priority Queue
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MaxPQComparator maxComparator = new MaxPQComparator();
		//alternative to MaxComaprator is => Collections.reverseOrder();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(maxComparator);
		int arr[] = {5,1,9,2,0,6};
		for(int i = 0 ; i< arr.length ; i++) {
			pq.add(arr[i]);
		}
	
		while(! pq.isEmpty()) {
			System.out.println(pq.remove()+" ");			
		}
	
		int arrX[] = {2,4,1,9,6,8};
		int k = 3;
		sortKSorted(arrX, k);
		
		System.out.println("\nNext\n");			
		
		for(int i = 0; i < arrX.length ; i++) {
			System.out.println(arrX[i]+" ");			
		}
	
		
		int arrY[] = {2,15,8,9,12,12,20};
		System.out.println("\nGetting top three..\n");
		printkLargest(arrY,3);
		
		
		String arrS[] = { "this", "is" ,"a", "string", "queue"};
		StringLengthComparator stringComparator = new StringLengthComparator();

		PriorityQueue<String> pqS = new PriorityQueue<String>(stringComparator);
		for(int i = 0 ; i< arrS.length ; i++) {
			pqS.add(arrS[i]);
		}
	
		while(! pqS.isEmpty()) {
			System.out.print(pqS.remove()+" ");			
		}
		
	}

}
