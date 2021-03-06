package recursionBase;

public class Fibonacci {

	//Normal recursion
	public static int fibo(int n) {
		if(n == 0 || n ==1) {
			return n;
		}
		return fibo(n-1) + fibo(n -2);
	}
	
	//Fibo Memoization
	public static int fibM(int n) {
		//array of size having unique calls for fibonacci
		int storage[] = new int[n+1];
		//setting initial dummy values 
		for(int i = 0; i < storage.length; i++) {
			storage[i] = -1;
		}
		 
		return fibM(n ,storage);
	}
	//Top Down Approach
	private static int fibM(int n, int[] storage) {
		// TODO Auto-generated method stub
		if(n == 0 || n ==1) {
			//fix for 0 and 1 
			storage[n] = n;
			return storage[n];
		}
		//check if we already have calculated results for (fib-1) and (fib-2)
		//check if storage's index value for current is not -1 => i.e. it must have the value already
		if(storage[n] != -1) {
			return storage[n];
		}
		//if result not present then lets call recursive for n and also store it in storage
		storage[n] = fibM(n-1, storage) + fibM(n-2, storage);
		return storage[n];	
	}
	
	//Fib DP
	//DP Bottom Up Approach=> eliminating recursion wherever we can
	public static int fiboDP(int n) {
		
		int storage[] = new int[n+1];
		storage[0] = 0;
		storage[1] = 1;
		
		for(int i = 2; i < storage.length; i++) {
			storage[i] = storage[i-1] + storage[i-2];
		}
		
		return storage[n];
	}

	//Driver
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 44;
		
		//faster recursion with memorization
		System.out.println(fibM(n));

		//using DynamicP
		System.out.println(fiboDP(n));
		
		//slower recursion O(2^n)
		System.out.println(fibo(n));
	
		
	}

}
 