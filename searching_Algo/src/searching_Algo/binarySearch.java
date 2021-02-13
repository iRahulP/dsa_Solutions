package searching_Algo;

public class binarySearch {
	
	public static int BinarySearch(int arr[], int e) {
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = ( start + end )/2;
			if (e == arr[mid]) {
				return mid; //element found
			}else if (e > arr[mid]) {
				start = mid + 1;
			}else {
				end = mid - 1;
			}
		}
		return -1;//didnt get element
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,5,15,21,78,445};
		int index = BinarySearch(arr, 15);
		System.out.println(index);
	}

}
