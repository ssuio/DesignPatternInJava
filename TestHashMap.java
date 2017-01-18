import java.util.HashMap;
import java.util.Map;

public class TestHashMap {
	public static void main(String[] args) {
		Map<Integer, Integer> hm = new HashMap<>();
		hm.put(1, 11);
		hm.put(2, 22);
		hm.put(3, 33);
		
		System.out.println(hm);
		
		System.out.println(hm.get(1));
	}
}
