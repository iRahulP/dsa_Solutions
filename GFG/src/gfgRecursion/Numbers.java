package gfgRecursion;

public class Numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fun_one(7);

		System.out.println();
		fun_two(7);
		System.out.println();
		fun_three(7,1);
	}


	public static void fun_one(int n) {
		if(n == 0) {
			return;
		}
		System.out.print(n + " ");
		fun_one(n-1);
	}

	public static void fun_two(int n) {
		if(n == 0) {
			return;
		}
		fun_two(n-1);
		System.out.print(n + " ");
	}

	public static void fun_three(int n, int i) {
		if(i > n) {
			return;
		}
		System.out.print(i + " ");
		fun_three(n,i+1);	
	}


	public static int sum_digits(int n) {
		//case for one digit
		if(n < 10) {
			return n;
		}
		return sum_digits(n/10) + n % 10;
	}

}
