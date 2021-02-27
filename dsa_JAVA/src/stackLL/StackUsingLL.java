package stackLL;

public class StackUsingLL<T> {

	//initial head node and maintains top
	private Node<T> head;
	//maintains size of stack
	private int size;
	
	public StackUsingLL(){
		head = null;
		size = 0;
	}
	
	int size() {
		return size;
	}
	
	T top() throws StackEmptyException{
		if(size() == 0) {
			throw new StackEmptyException();
		}
		return head.data;
	}
	
	boolean isEmpty() {
		return size()==0;
	}
	
	void push(T  element) {
		
		Node<T> newNode = new Node<T>(element);
		newNode.next = head;
		head = newNode;
		size++;
	
	}
	
	T pop() throws StackEmptyException{
		
		if(size() == 0) {
			throw new StackEmptyException();
		}
		//retain data to return
		T dataTmp = head.data;
		//point it to next node - breaks current node link
		head = head.next;
		size--;
		return dataTmp;
		
	}
	
}
