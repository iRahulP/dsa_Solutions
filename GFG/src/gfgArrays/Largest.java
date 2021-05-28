package gfgArrays;


public class Largest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {5,8,20,10};
		System.out.println(largest(arr));
	}

	public static int largest(int arr[]) {
		int res = 0;
		for(int i = 0; i< arr.length; i++) {
			if(arr[i] > arr[res]) {
				res = i;
			}
		}
		return res;
	}
	
	public static int secondNonEffLargest(int arr[]) {
		int largest  = largest(arr);
		
		int res = -1;
		for(int i = 0 ; i < arr.length; i++) {
			if(arr[i] != arr[largest]) {
				if(res == -1) {
					res = i;
				}
				else if (arr[i] > arr[res]) {
					res = i;
				}
			}
		}
		return res;
	}
	
	public static int secondEffLargest(int arr[]) {
		//tracks earlier largest
		int res= -1, largest = 0;
		for(int i = 1; i < arr.length ; i++) {
			if(arr[i] > arr[largest]) {
				res = largest;
				largest = i;
			}
			else if (arr[i] != arr[largest]) {
				if(res == -1 || arr[i] > arr[res]) {
					res =  i;
				}
			}
		}
		return res;
	}
}
