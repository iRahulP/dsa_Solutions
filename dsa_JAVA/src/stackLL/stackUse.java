package stackLL;

import stack.StackEmptyException;

public class stackUse {

	public static void main(String[] args) throws StackEmptyException {
		// TODO Auto-generated method stub
		
		StackUsingLL<Integer> sua = new StackUsingLL();
		for(int i = 0; i < 5; i++) {
			sua.push(i);
		}
		System.out.println(sua.size());
		
		while(!sua.isEmpty()){
			try {
				System.out.println(sua.pop());
			} catch (stackLL.StackEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
