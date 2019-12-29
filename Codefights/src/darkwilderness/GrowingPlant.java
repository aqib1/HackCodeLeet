package darkwilderness;

public class GrowingPlant {
	static int growingPlant(int upSpeed, int downSpeed, int desiredHeight) {
		int days = 0;
		int growth = 0;
		while (true) {
			days++;
			growth += upSpeed;
			if (growth >= desiredHeight)
				break;
			growth -= downSpeed;
		}
		return days;
	}

	public static void main(String[] args) {
		System.out.println(growingPlant(100, 10, 910));
	}
}
