package Throughthefog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class V {
	public String value;
	public int occurence;
	public V next;

	@Override
	public String toString() {
		return "V [value=" + value + ", occurence=" + occurence + "]";
	}

}

public class StringRearrangement {

	static boolean stringsRearrangement(String[] inputArray) {
		Arrays.sort(inputArray);
		System.out.println(Arrays.toString(inputArray));
		List<V> li = new ArrayList<>();
		String va1l = inputArray[0];
		V v = new V();
		v.value = va1l;
		v.occurence++;
		for (int x = 1; x < inputArray.length; x++) {
			va1l = inputArray[x - 1];
			String va12 = inputArray[x];
			if (va1l.equals(va12)) {
				v.occurence++;
			} else {
				li.add(v);
				v = new V();
				v.value = va12;
				v.occurence++;
			}
		}
		if (!li.contains(v))
			li.add(v);
		// even
		if (li.size() == 1)
			return false;
		for (int x = 0; x < li.size() - 1;) {
			V v1 = li.get(x);
			V v2 = li.get(x + 1);
			if (v1.occurence != v2.occurence || !differByOne(v1.value, v2.value)) {
				return false;
			}
			x += 2;
			// back-check
			if(x < li.size() - 1) {
			v1 = li.get(x);
			v2 = li.get(x - 1);
			if (!differByOne(v1.value, v2.value))
				return false;
			}
		}
		return true;
	}

	static boolean differByOne(String a, String b) {
		int count = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) {
				count++;
			}
		}
		return count == 1;
	}

	public static void main(String[] args) {
		System.out.println(stringsRearrangement(new String[] {"ff", 
				 "gf", 
				 "af", 
				 "ar", 
				 "hf" }));
	}
}
