package gfgRecursion;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Fibo(4));
	}

	public static int Fibo(int n) {
		if(n == 0 || n ==1) {
			return n;
		}
		return Fibo(n-1) + Fibo(n-2);
	}
}
