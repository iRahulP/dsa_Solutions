package sorting_Algo;

public class mergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		insertionSort ins = new insertionSort();
		bubbleSort bus = new bubbleSort();
		int arr1[] = {15,1,5,8,21,16,445};
		int arr2[] = {23,65,4,667,22};
		ins.InsertSort(arr1);
		bus.BubbleSort(arr2);
		int arr[] = new int[arr1.length+arr2.length];
		arr = MergeSort(arr1,arr2);
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);			
		}
	}

	private static int[] MergeSort(int[] arr1, int[] arr2) {
		// TODO Auto-generated method stub
		//traverses arr1
		int i = 0;
		//traverses arr2
		int j = 0;
		//traverses result
		int k = 0;
		
		int res[] = new int[arr1.length + arr2.length];		
		
		while (i < arr1.length && j < arr2.length) {
		
			if(arr1[i] < arr2[j]) {
				res[k] = arr1[i];
				k++;
				i++;
			}else {
				res[k] = arr2[j];
				j++;
				k++;
			}
		}
		//checks if any elements remained after earlier operation for arr1 
		while (i < arr1.length ) {
			res[k] = arr1[i];
			k++;
			i++;
		}
		//checks if any elements remained after earlier operation for arr2 		
		while (j < arr2.length ) {
			res[k] = arr2[j];
			k++;
			j++;
		}
		
		return res;
	}


}
