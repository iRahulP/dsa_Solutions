package NumberToOne;

public class TakeNumberToOne {

	
	//basic recursion
	public static int levelsCount(int n) {
		
		//base case taking 1 to 1
		if(n == 1) {
			//no level
			return 0;
		}
		
		//subtract option by 1
		int op1 = levelsCount(n - 1);
		int minSteps = op1;
				
		//divide option by 3
		if(n % 3 == 0) {
			int op2 = levelsCount(n/3);
			if(op2 < minSteps) {
				minSteps = op2;
			}
		}
		
		//divide option by 2
		if(n % 2 == 0) {
			int op3 = levelsCount(n/2);
			if(op3 < minSteps) {
				minSteps = op3;
			}
		}
		
		return 1 + minSteps;
	}
	
	
	
	//Memoization 
	static int countStepsM(int n) {
		int storage[] = new int[n+1];
		return countStepsM(n, storage);
	}
	
	
	
	private static int countStepsM(int n, int[] storage) {
		// TODO Auto-generated method stub
		//base case
		if(n == 1) {
			storage[n] = 0;
			return storage[n];
		}
		if(storage[n] != 0) {
			return storage[n];
		}
	
		//subtract option by 1
		int op1 = countStepsM(n - 1,storage);
		int minSteps = op1;
				
		//divide option by 3
		if(n % 3 == 0) {
			int  op2 = countStepsM(n/3 , storage);
			if(op2 < minSteps) {
				minSteps = op2;
			}
		}
		
		//divide option by 2
		if(n % 2 == 0) {
			int op3 = countStepsM(n/2, storage);
			if(op3 < minSteps) {
				minSteps = op3;
			}
		}
		storage[n] = 1+minSteps;
		return storage[n];
	}
	
	
	
	//DP
	public static int countStepsDP(int n) {
		int storage[] = new int[n+1];
		
		//storage 0 and 1 will already be 0
		storage[1] = 0;
		for(int i=2; i< storage.length; i++) {
			 int min = storage[i-1];
			 if(i % 3 == 0) {
				 if(min > storage[i/3]) {
					 min = storage[i/3];
				 }
				 if(min > storage[i/2]) {
					 min = storage[i/2];
				 } 
			 }
			 storage[i] = 1+min;
		}
		return storage[n];
	}
	

	public static void main(String[] args) {
		
		int n = 1000;	
		
		System.out.println(countStepsDP(n));
		
		System.out.println(countStepsM(n));
		
		System.out.println(levelsCount(n));
		
	}
}
