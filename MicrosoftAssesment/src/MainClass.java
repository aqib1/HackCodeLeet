import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class MainClass {

	public static int ArrayChallenge(int[] arr) {
	    // code goes here  
		Set<Integer> uniqueElements = new HashSet<>();
		IntStream.range(0, arr.length).forEach(x -> uniqueElements.add(arr[x]));
		List<Integer> elementsList = new ArrayList<>(uniqueElements);
		Collections.sort(elementsList);
		int MAX_SEQUENCE = Integer.MIN_VALUE;
		int sequenceCount = 1;
		for(int x=0; x < elementsList.size() - 1; x++) {
			if(elementsList.get(x) + 1 == elementsList.get(x + 1)) {
				sequenceCount++;
			} else  {
				MAX_SEQUENCE = Math.max(MAX_SEQUENCE, sequenceCount);
				sequenceCount = 1;
			}
		}
		if(sequenceCount != 1) MAX_SEQUENCE = Math.max(MAX_SEQUENCE, sequenceCount);
	    return MAX_SEQUENCE;
	  }
	
	public static void main(String[] args) {
		System.out.println("Hi There");
		ArrayChallenge(new int[] {5, 6, 1, 2, 8, 9, 7});
	}
}
