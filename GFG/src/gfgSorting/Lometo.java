package gfgSorting;

public class Lometo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10, 80, 30, 90, 40, 50 ,70};
		lpartition(arr,0,6);
		for(int i = 0; i < arr.length ; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void lpartition(int arr[], int l, int h) {
		int pivot = arr[h]; //last element as pivot
		int i = l - 1;
		for(int j = l; j <- h-1 ; j++) {
			if(arr[j] < pivot) {
				i++;
				swap(arr[i], arr[j]);
			}
		}
		swap(arr[i+1], arr[h]);
	}

	private static void swap(int i, int j) {
		// TODO Auto-generated method stub
		int temp = j;
		j = i;
		i = temp;
	}

}
