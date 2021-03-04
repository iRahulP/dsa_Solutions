package hashmaps;

import java.util.ArrayList;
import java.util.HashMap;

public class RemoveDuplicates {

	public static ArrayList<Integer> removeDuplicates(int a[]){
		ArrayList<Integer> output = new ArrayList<>();
		HashMap<Integer, Boolean> seen = new HashMap<>();
		
		for(int i = 0 ; i < a.length ; i++ ) {
			if(seen.containsKey(a[i])){
				continue;
			}
			output.add(a[i]);
			seen.put(a[i], true);
		}
		return output;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[] = {2,56,23,7865,325,482,1346,872,1,6,8,2,56,23,482,222,6,8,325};
		
		ArrayList<Integer> output = removeDuplicates(a);
		for(int i= 0 ; i < output.size(); i++) {
			System.out.println(output.get(i));
		}
	}

}
