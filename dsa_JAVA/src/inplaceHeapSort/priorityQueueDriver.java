package inplaceHeapSort;

public class priorityQueueDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {5,1,9,2,0,6};
		//using same array => reducing space complexity- LOL
		for(int i = 0; i < arr.length ; i++) {
			insertIntoVirtualHeap(arr,i);
		}
		
		for(int i = 0; i < arr.length ; i++) {
			System.out.print("["+arr[i]+"]");
		}
		
		System.out.println("\nAfter Removals ...SORTED desc");
		
		for(int i = 0; i < arr.length ; i++) {
			//sending arr and size of virtual heap
			//We will be storing the removed elements at heapSize + 1!
			arr[(arr.length -1) -i] =  removeFromVirtualHeap(arr, arr.length - i);
		}	
		
		for(int i = 0; i < arr.length ; i++) {
			System.out.print("["+arr[i]+"]");
		}
		
	}

	private static int removeFromVirtualHeap(int[] arr, int heapSize) {
		// TODO Auto-generated method stub
		//min element
		int resTemp = arr[0];
		arr[0] = arr[heapSize - 1];
		heapSize--;
		
		int index = 0;
		int leftChildIndex = 2 * index + 1;
		int rightChildIndex = 2 * index + 2;
	
		while(leftChildIndex < heapSize) {
			int minIndex = index;
			if(arr[leftChildIndex] < arr[minIndex]) {
				minIndex = leftChildIndex;
			}
			if(rightChildIndex < heapSize && arr[rightChildIndex] < arr[minIndex]) {
				minIndex = rightChildIndex;
			}
			if(minIndex != index) {
				//swap
				int temp = arr[index];
				arr[index] = arr[minIndex];
				arr[minIndex] = temp;
				
				//for next Iter
				index= minIndex;
				leftChildIndex = 2 * index + 1;
				rightChildIndex = 2 * index + 2;
				
			}else {
				break;
			}
			
		}
		return resTemp;
	}

	private static void insertIntoVirtualHeap(int[] arr, int i) {
		// TODO Auto-generated method stub
		int childIndex = i;
		int parentIndex = (childIndex - 1) / 2;
		//checking priority until childIndex == 0
		//upward heapify
		while(childIndex > 0) {
			if(arr[childIndex] < arr[parentIndex]) {
				//swap with parent as less priority
				int temp = arr[childIndex];
				arr[childIndex] = arr[parentIndex];
				arr[parentIndex] = temp;
				childIndex = parentIndex;
				parentIndex = (childIndex - 1) / 2;
			}
			else {
				return;
			}
		}
	}

}
