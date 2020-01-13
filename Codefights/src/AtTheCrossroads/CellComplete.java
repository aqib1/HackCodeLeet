package AtTheCrossroads;

import java.util.Arrays;
import java.util.Objects;

public class CellComplete {

	public static int[] cellComplete(int[] states, int days) {
		if (Objects.isNull(states) || states.length < 2 || days <= 0) {
			throw new IllegalArgumentException("Illegal params found");
		}
		int cellCompletes[] = null;
		for (int c = 0; c < days; c++) {
			cellCompletes = new int[states.length];
			for (int stat = 0; stat < states.length; stat++) {
				cellCompletes[stat] = getStatVal(states, stat);
			}
			states = cellCompletes;
		}
		return cellCompletes;
	}

	private static int getStatVal(int[] states, int index) {
		return (index == 0) ? (states[index + 1] == 1) ? 1 : 0
				: (index == (states.length - 1)) ? (states[index - 1] == 1) ? 1 : 0
						: (states[index - 1] == states[index + 1]) ? 0 : 1;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(cellComplete(new int[] {1,0}, 2)));

	}

}
