package hashmaps;
import java.util.HashMap;
import java.util.Set;

public class MapUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<>();
		
		//insert
		map.put("abc", 1);
		map.put("def", 2);
		map.put("ghi", 3);
		
		
		//check presence
		if(map.containsKey("def")) {
			System.out.println("has def");
		}
		
		int v = 0;
		//check and store
		if (map.containsKey("abc")) {
			v = map.get("abc");	
		}
		System.out.println(v);
	
		//remove
		int s = map.remove("abc");
		System.out.println(s);
		System.out.println(map);
		
		//check Value O(n)
		if(map.containsValue(2)) {
			System.out.println("Contains 2");			
		}
		
		//imported set to get keys as they are unique
		Set<String> keys = map.keySet();
		for(String str : keys) {
			System.out.println(str);
		}
		
		
	}

}
