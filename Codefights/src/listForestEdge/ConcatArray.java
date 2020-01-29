package listForestEdge;

public class ConcatArray {

	static int[] concatenateArrays(int[] a, int[] b) {
		int result[] = new int[a.length + b.length];
		System.arraycopy(a, 0, result, 0, a.length);
		System.arraycopy(b, 0, result, a.length, b.length);
		return result;
	}

	public static void main(String[] args) {

	}

}
