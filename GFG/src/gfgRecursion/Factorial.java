package gfgRecursion;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fact(4));
	}

	public static int fact(int n) {
		if(n == 0) {
			return 1;
		}
		return n * fact(n-1);
	}
}
