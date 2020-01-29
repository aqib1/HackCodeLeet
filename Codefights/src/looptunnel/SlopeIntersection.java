package looptunnel;

public class SlopeIntersection {
	static int countBlackCells(int n, int m) {

		 return n + m + gcd(n,m) - 2;
}

	static int gcd(int n, int m) {
		int gcd = 0;
		
		for(int x=1; x<=n && x<=m; x++) {
			if(x%n ==0 && x%m==0)
				gcd = x;
		}
		
		return gcd;
	}
	public static void main(String[] args) {

	}

}
