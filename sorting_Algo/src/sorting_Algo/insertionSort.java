package sorting_Algo;

public class insertionSort {
//sorted|unsorted sections! 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {15,1,5,8,21,16,445};
		InsertSort(arr);
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);			
		}
	}

	public static void InsertSort(int[] arr) {
		// TODO Auto-generated method stub
		
		//starting with index 1 for unsorted subArray
		for(int i = 1; i < arr.length; i++) {
			//first comparison to be done with index i-1
			int j = i - 1;
			//keeping the value which needs to be exchanged
			int temp = arr[i];
			
			while (j>=0 && arr[j] > temp) {
				//shift
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j+1] = temp;
		}
	}

}
