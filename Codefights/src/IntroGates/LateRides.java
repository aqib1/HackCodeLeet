package IntroGates;

public class LateRides {

	static int lateRide(int n) {
		int div = n/60;
		int remin = n%60;
		String time = div + ""+ remin;
		return time.chars().map(x -> Integer.parseInt(Character.toString((char)x))).sum();
	}
	
	public static void main(String[] args) {
		System.out.println(lateRide(808));

	}

}
