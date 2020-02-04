package kingdomsroads;

import java.util.Arrays;

public class NewRoadSystem {

	static boolean newRoadSystem(boolean[][] roadRegister) {
		int[] incoming = new int[roadRegister.length];
		int[] outgoing = new int[roadRegister.length];

		for (int x = 0; x < roadRegister.length; x++) {
			for (int y = 0; y < roadRegister[x].length; y++) {
				if (roadRegister[x][y]) {
					outgoing[x]++;
					incoming[y]++;
				}
			}
		}

		for(int x=0; x<roadRegister.length; x++) {
			if(incoming[x] != outgoing[x])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(newRoadSystem(new boolean[][] { { false, true, false, false }, { false, false, true, false },
				{ true, false, false, true }, { false, false, true, false } }));
	}

}
