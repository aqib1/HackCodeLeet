package looptunnel;

public class LineUp {

	static int lineUp(String commands) {
		if (commands.isEmpty())
			return 0;
		if (commands.length() == 1) {
			return commands.equals("A") ? 1 : 0;
		}
		int count = 0;
		boolean match = true;
		for (char v : commands.toCharArray()) {
			if (v == 'L' || v == 'R') {
				if (match) {
					match = false;
				} else {
					match = true;
				}
			}
			count += match ? 1 : 0;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(lineUp("LLARL"));
	}

}
