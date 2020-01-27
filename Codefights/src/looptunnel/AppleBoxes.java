package looptunnel;

public class AppleBoxes {
	static int appleBoxes(int k) {
		int evenSum = 0, oddSum = 0;
		for(int x=1; x<=k; x++)
			if(x%2==0)
				evenSum += (x*x);
			else oddSum += (x*x);
		return (evenSum-oddSum);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
