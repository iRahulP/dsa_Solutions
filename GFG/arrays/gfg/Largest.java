package gfg;

public class Largest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {5,8,20,10};
		System.out.println(largest(arr));
	}

	public static int largest(int arr[]) {
		int res = 0;
		for(int i = 0; i< arr.length; i++) {
			if(arr[i] > arr[res]) {
				res = i;
			}
		}
		return res;
	}
}
