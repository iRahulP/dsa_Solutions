package searching_Algo;

public class linearSearch {

	public static int LinearSearch(int arr[], int e) {
		for (int i = 0 ; i < arr.length; i++) {
			if(arr[i] == e) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,5,15,21,78,445};
		int index = LinearSearch(arr, 15);
		System.out.println(index);
		
	}

}
