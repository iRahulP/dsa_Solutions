package gfgSorting;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {5, 7, 20, 10};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));

		//Sorts from index 1 to index 2.
		int arr2[] = {5, 7, 20, 10};
		Arrays.sort(arr2, 1, 3);
		System.out.println(Arrays.toString(arr2));
	}
}