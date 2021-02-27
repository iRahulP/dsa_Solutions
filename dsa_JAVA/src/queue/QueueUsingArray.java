package queue;

public class QueueUsingArray {

	
	private int data[];
	//index at which front element is stored
	private int front;
	//index at which rear element is stored
	private int rear;
	private int size;
	
	public QueueUsingArray(int capacity) {
		//default array created
		data = new int[capacity];
		//queue empty initially
		front = -1;
		rear = -1;		
		size = 0;
	}

	public QueueUsingArray() {
		//default array created
		data = new int[5];
		//queue empty initially
		front = -1;
		rear = -1;		
		size = 0;
	}

	
	int size() {
		return size;
	}
	
	boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		return false;
	}
	
	int front() throws QueueEmptyException {
		if(size() == 0) {
			throw new QueueEmptyException();
		}
		return data[front];
	}
	
	void enqueue(int element) throws QueueFullException{
		
		if(size() == data.length) {
			doubleCapacity();
			//throw new QueueFullException();
		}
		
		if(size() == 0) {
			front = 0;
		}
		
		size++;
		
		//adding circular insertions
		//setting range of rear to (0 - data.length-1)
		//rear = (rear + 1) % data.length;
		rear++;
		if(rear == data.length) {
			rear = 0;
		}
		
		data[rear] = element;
	
	}
	
	
	private void doubleCapacity() {
		int temp[] = data;
		int idx = 0;
		data = new int[ 2 * temp.length];
		//adding elements from front pointer till end of earlier array
		for(int i = front; i<= temp.length;i++) {
			data[idx] = temp[i];
			idx++;
		}
		//adding further elements in sequence
		for(int i = 0; i <= front - 1; i++) {
			data[idx] = temp[i];
			idx++;
		}
		//setting indexes for new array
		front = 0;
		rear = temp.length - 1;
	}

	int dequeue() throws QueueEmptyException{
		if(size == 0) {
			throw new QueueEmptyException();
		}
		int temp = data[front];
		
		//setting same thing for dequeue
		//front = (front + 1) % data.length;
		front++;
		if(front == data.length) {
			front = 0;
		}
		
		size--;
		if(size == 0) {
			front = -1;
			rear = -1;
		}
	
		return temp;
	}
	
	
}
