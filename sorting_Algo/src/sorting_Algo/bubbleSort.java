package sorting_Algo;

public class bubbleSort {
//Pairs of bubbles in Rounds with sorts if needed
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {15,1,5,8,21,16,445};
		BubbleSort(arr);
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);			
		}
	}

	public static void BubbleSort(int[] arr) {
		// TODO Auto-generated method stub
		int temp = 0;
		for (int i = 0; i < arr.length - 1; i++ ) {
			//j traverses until n-2 
			for (int j = 0; j < arr.length -i -1 ; j++ ) {
				if (arr[j+1] < arr[j]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
}
