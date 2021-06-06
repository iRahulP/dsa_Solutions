package gfgSorting;

public class Hoare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {5, 3, 8, 4, 2, 7, 1, 10};
		partition(arr,0,7);
		for(int i = 0; i < arr.length ; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void partition(int arr[], int l , int h) {
		int pivot = arr[l];
		int i = l - 1;
		int j = h + 1;
		while(true) {
			do {
				i++;
			}while(arr[i] < pivot);
			
			do {
				j--;
			}while(arr[j] > pivot);
			
			if(i >= j) {
				return;
			}
			swap(arr, arr[i], arr[j]);
		}
	}

	private static void swap(int arr[],int i, int j) {
		// TODO Auto-generated method stub
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}
}
