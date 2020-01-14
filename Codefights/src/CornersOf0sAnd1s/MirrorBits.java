package CornersOf0sAnd1s;

public class MirrorBits {
	static int mirrorBits(int a) {
		return Integer.parseInt(new StringBuilder(Integer.toBinaryString(a)).reverse().toString(), 2);
	}

	public static void main(String[] args) {

	}

}
