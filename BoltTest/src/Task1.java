import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task1 {

	public static char[] reverseWords(char[] input) {
		if (Objects.isNull(input) || input.length == 0)
			return input;
		
		// These are just space pointers
		List<Integer> spaceIndexes = new ArrayList<>();
		
		// Base rules
		spaceIndexes.add(-1);
		spaceIndexes.addAll(IntStream.range(0, input.length).filter(x -> input[x] == ' ').boxed()
				.collect(Collectors.toList()));
		spaceIndexes.add(input.length);
	
		//Swap
		IntStream.range(0, spaceIndexes.size() - 1).forEach(spaceIndex -> {
			swap(input, spaceIndexes.get(spaceIndex) + 1, spaceIndexes.get(spaceIndex + 1) - 1);
		});
		
		return input;
	}

	private static void swap(char[] input, Integer low, Integer high) {
		while (low < high) {
			char temp = input[low];
			input[low] = input[high];
			input[high] = temp;
			low++;
			high--;
		}

	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(reverseWords(
				new char[] {'I',' ','d','r','i','v','e',' ','w','i','t','h'})));
	}
}
