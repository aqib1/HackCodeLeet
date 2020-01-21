package looptunnel;

public class MagicWell {

	static int magicalWell(int a, int b, int n) {
		int money = 0;
		for (int x = n; x > 0; x--)
			money += (a++ * b++);
		return money;
	}

	public static void main(String[] args) {
		System.out.println(magicalWell(1, 2, 2));

	}

}
