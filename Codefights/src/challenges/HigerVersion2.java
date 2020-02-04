package challenges;

public class HigerVersion2 {

	static int higherVersion2(String ver1, String ver2) {
		if (!ver1.contains(".") && !ver2.contains(".")) {
			return Integer.parseInt(ver1) > (Integer.parseInt(ver2)) ? 1
					: Integer.parseInt(ver1) == Integer.parseInt(ver2) ? 0 : -1;
		}
		String[] val1 = ver1.split("\\.");
		String[] val2 = ver2.split("\\.");
		for (int x = 0; x < val1.length; x++) {
			int v1 = Integer.parseInt(val1[x]);
			int v2 = Integer.parseInt(val2[x]);
			if (v1 != v2) {
				return v1 > v2 ? 1 : -1;
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		System.out.println(higherVersion2("1.0.5", "1.00.05"));
	}

}
