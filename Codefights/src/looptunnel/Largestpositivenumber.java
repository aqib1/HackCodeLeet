package looptunnel;

import java.util.ArrayList;

public class Largestpositivenumber {

	public static int getLargestNumber(int input) {
		String val = String.valueOf(input);
		ArrayList<Integer> data = new ArrayList<>();
		for (char c : val.toCharArray())
			data.add(Integer.parseInt(String.valueOf(c)));
		data.sort((x, y) -> y.compareTo(x));
		val = String.valueOf(data.get(0));
		for (int x = 1; x < data.size(); x++)
			val += data.get(x);
		return Integer.parseInt(val);
	}

	public static void main(String[] args) {
		System.out.println(getLargestNumber(989));
	}
}
