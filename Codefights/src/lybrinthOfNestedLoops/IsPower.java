package lybrinthOfNestedLoops;

public class IsPower {

	static boolean isPower(int n) {
		 if(n==1) return true;
		for (int x = 2; x < Math.sqrt(n); x++) {
			int y = 2;
			double pow = Math.pow(x, y);
			while(pow <= n && pow > 0) {
				if(pow == n)
					return true;
			 pow = Math.pow(x, ++y);
			}
		}

		return false;
	}

	public static void main(String[] args) {
		System.out.println(Math.sqrt(25));

	}

}
