package stack;

public class StackUse {
	
	public static void main(String[] args) throws StackFullException {
		StackUsingArray sua = new StackUsingArray();
		for(int i = 0; i < 5; i++) {
			sua.push(i);
		}
		System.out.println(sua.size());
		
		while(!sua.isEmpty()){
			try {
				System.out.println(sua.pop());
				
			} catch (StackEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
