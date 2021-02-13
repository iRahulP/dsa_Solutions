package sorting_Algo;
//swap method and subArrays
public class selectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {15,1,5,8,21,16,445};
		SelectSort(arr);
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);			
		}
	}

	private static void SelectSort(int[] arr) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length - 1; i++ ) {
			int min = arr[i];
			int minIdx = i;
			for(int j = i+1; j< arr.length - 1; j++ ) {
				if(arr[j] < min) {
					min = arr[j];
					minIdx = j;
				}
			}
			if (minIdx != i) {
			arr[minIdx] = arr[i];
			arr[i]= min;
			}
			
		}
	}

}
