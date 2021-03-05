package priorityQueues;


//Priority Queues are stored as Array
import java.util.ArrayList;

public class priorityQueue {

	//creating an arraylist which  will store heap
	//heap is a data memeber
	private ArrayList<Integer> heap;


	public priorityQueue() {
		heap = new ArrayList<>();
	}

	
	boolean isEmpty() {
		return (heap.size() == 0);
	}
	
	
	int size() {
		return heap.size();
	}
	
	
	//implementing MinHEAP!!
	//getMin shoudl return data with minimum priority
	int getMin() throws priorityQueueEmptyException{
		if(heap.isEmpty()) {
			throw new priorityQueueEmptyException();
		}
		return heap.get(0);
	}

	
	
	//insertion at last place and heapify!
	void insert(int element) {
		heap.add(element);
		//upward heapify insures heap order property.
		//check prioriy with parent and swap if required.
		int childIndex = heap.size() -1 ;//last element
		int parentIndex = (childIndex - 1)/2; //formula from heap order Balanced tree
		
		//until we reach root
		while(childIndex > 0) {
			if(heap.get(childIndex) < heap.get(parentIndex)){
				//swap
				int temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				//setting childindex for next check in order to heapify the entire tree
				childIndex = parentIndex;
				parentIndex = (childIndex -1)/2;
			}
			else {
				//no need to swap
				return;
			}
		}
	}
	
	
	int removeMin() throws priorityQueueEmptyException {
		if(heap.isEmpty()) {
			throw new priorityQueueEmptyException();
		}
		//set first element as the current last element
		int result = heap.get(0);
		heap.set(0, heap.get(heap.size()-1));
		//now remove the last element
		heap.remove(heap.size()-1);
		
		//assuming minimum at 0 and left and right appropriately as per ArrayList
		int index = 0;//node which we will compare
		int minIndex = index; 
		int leftChildIndex = 1;
		int rightChildIndex = 2;
		
		//loop until we are in range of arrayList!
		while(leftChildIndex < heap.size()) {
			//again heapify as first element has changed
			//traverse till leaf => downward Heapify
			if(heap.get(leftChildIndex) < heap.get(minIndex)){
				minIndex = leftChildIndex;
			}
			if(rightChildIndex < heap.size() && heap.get(rightChildIndex) < heap.get(minIndex)) {
				minIndex = rightChildIndex;
			}
			//if not above two then minIndex will be same as root
			if(minIndex == index) {
				break;
			}
			else {
				//now we have minIndex out of three(minIndex, leftCI, rightCI)
				//get original index which we need to swap with the above minIndex
				int temp = heap.get(index);
				//minIndex will have either left or right or minIndex itself whichever has 
				heap.set(index, heap.get(minIndex));
				heap.set(minIndex, temp);
				
				//next Iteration after swap
				//set indexes
				index = minIndex;
				leftChildIndex = (2 * index) + 1;
				rightChildIndex = (2 * index) + 2;
			}
			
		}
		
		return result;
	}
	
	
	
	
}