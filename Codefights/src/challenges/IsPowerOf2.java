package challenges;

public class IsPowerOf2 {

	static boolean isPowerOfTwo2(long n) {
		for(int x=0; x<=n; x++) {
			if(Math.pow(2, x) == n) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		System.out.println(isPowerOfTwo2(5));

	}

}
