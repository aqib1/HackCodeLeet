package LandOfLogics;

public class ValidTime {
	static boolean validTime(String time) {
		if (!time.contains(":"))
			return false;
		try {
			String[] numbs = time.split(":");
			int hours = Integer.parseInt(numbs[0]);
			int minutes = Integer.parseInt(numbs[1]);
			if (hours < 0 || hours > 59 || minutes < 0 || minutes > 59)
				return false;
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {

	}

}
