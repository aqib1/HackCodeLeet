package CornersOf0sAnd1s;

public class FindTheDifferentRightMostBit {
	static int differentRightmostBit(int n, int m) {
		return (n^=m) & -n;
	}
	public static void main(String[] args) {
		

	}

}
