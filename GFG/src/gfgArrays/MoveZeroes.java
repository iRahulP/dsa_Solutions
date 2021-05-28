package gfgArrays;

public class MoveZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {10, 5, 0, 0 ,8 ,0, 9, 0};
		moveToEnd(arr);
	}

	public static void moveToEnd(int arr[]) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == 0) {
				for(int j = i+1 ; j < arr.length ; j++) {
					if(arr[j] != 0 ) {
						int temp = arr[j];
						arr[j] = arr[i];
						arr[i] = temp;
					}
				}
			}
		}
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void moveToEndZeroes(int arr[]) {
		int count = 0;
		for(int i = 0 ; i < arr.length; i++) {
				 if(arr[i] != 0) {
					 swap(arr[i],arr[count]);
					 count++;
				 }
		}
	}

	private static void swap(int i, int j) {
		// TODO Auto-generated method stub
		int temp = j;
		j = i;
		i = temp;
	}
	
	
}
