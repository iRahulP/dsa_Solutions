package stack;

public class StackUsingArray {

	
	private int data[];
	private int top; //index of topmost element in stack

	//fixed Stack of size 10
	public StackUsingArray() {		
		data = new int[10];
		top = -1;
	}
	
	//Stack based on given size
	public StackUsingArray(int capacity){
		data = new int[capacity];
		top = -1;
		
	}
	
	public boolean isEmpty(){
		return (top == -1);
	}
	
	public int size(){
		return top + 1;	
	}
	
	
	public int top() {
		if(size() == 0){
			//StackEmptyException
			//StackEmptyException e =  new StackEmptyException();
			//throw e;
			doubleCapacity();
		}
		return data[top];
	}
	
	private void doubleCapacity() {
		int temp[] = data;
		data = new int[2 * temp.length];
		for(int i = 0; i <= top ; i++) {
			data[i] = temp[i];
		}
	}
	
	
	public void push(int temp) throws StackFullException {
		if(size() == data.length) {
			
			throw new StackFullException();
		}
		
		top++;
		data[top] = temp;
	}
	
	public int pop() throws StackEmptyException{
		if(size() == 0) {
			StackEmptyException e = new StackEmptyException();
			throw e;
		}
		int temp = data[top];
		top--;
		
		return temp;
		
	}
	
	
	
}
