package CornersOf0sAnd1s;

public class FindEqualBitOnMostRight {
	static int equalPairOfBits(int n, int m) {
		return Integer.lowestOneBit(~(n^m)) ;
	}
	public static void main(String[] args) {

	}

}
