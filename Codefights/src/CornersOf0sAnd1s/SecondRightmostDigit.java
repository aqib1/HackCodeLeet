package CornersOf0sAnd1s;

public class SecondRightmostDigit {

	static int secondRightmostZeroBit(int n) {
		  return ~(n= n|n+1) & n+1;
		}
	public static void main(String[] args) {
		int value = 37;
		System.out.println(secondRightmostZeroBit(value));

	}

}
