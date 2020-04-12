import java.util.EmptyStackException;
import java.util.Objects;

public class MergeSort {

	public int[] mergeSort(int[] array) {
		if(Objects.isNull(array) || array.length == 0)
			throw new EmptyStackException();
		if(array.length == 1)
			return array;
		
		return null;
	}
}
