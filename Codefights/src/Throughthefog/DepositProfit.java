package Throughthefog;

public class DepositProfit {
	public static double calculatePercentage(double obtained, double total) {
		return (obtained * total) / 100;
	}

	static int depositProfit(int deposit, int rate, int threshold) {
		int years = 0;
		while (deposit < threshold) {
			years++;
			deposit += calculatePercentage(rate, deposit);
		}
		return years;
	}

	public static void main(String[] args) {
		System.out.println(depositProfit(100, 20, 170));
	}
}
