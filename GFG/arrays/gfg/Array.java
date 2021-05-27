package gfg;

public class Array {
	
	public static void main(String [] args) {
		int arr[] = {3,8,12,6};
		System.out.println(search(arr,arr.length,12));
	}

	public static int search(int arr[], int n, int x) {
		for(int i = 0; i < n; i++) {
			if(arr[i] == x) {
				return i;
			}
		}
		return -1;
	}
	
	public int insert(int arr[], int n, int x, int cap, int pos) {
		//if no space
		if(n == cap) {
			return n;
		}
		
		int idx = pos -1;
		for(int i = n-1; i>= idx; i++) {
			arr[i+1] = arr[i];
		}
		arr[idx] = x;
		return n+1;
	}
	
	public int delete(int arr[], int n, int x) {
		int i;
		for(i = 0; i < n; i++) {
			if(arr[i] == x) {
				break;
			}
		}
		if(i == n) {
			return n;
		}
		for(int j = i; j< n-1; j++) {
			arr[j] = arr[j+1];
		}
		return n-1;
	}
	
}

