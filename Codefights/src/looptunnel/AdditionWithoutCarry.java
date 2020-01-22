package looptunnel;

public class AdditionWithoutCarry {
	static int getSumWithoutCarry(int param1, int param2) {
		return ((param1 % 10) + (param2 % 10)) % 10;
	}

	static int additionWithoutCarrying(int param1, int param2) {
		int multify = 10;
		int sum = getSumWithoutCarry(param1, param2);
		while (param1 != 0 || param2 != 0) {
			param1 /= 10;
			param2 /= 10;
			int tempSum = getSumWithoutCarry(param1, param2);
			sum = (tempSum * multify) + sum;
			multify *= 10;
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(additionWithoutCarrying(452, 169));
	}

}
