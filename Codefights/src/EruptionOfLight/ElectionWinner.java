package EruptionOfLight;

import java.util.Arrays;

public class ElectionWinner {
	static int electionsWinners(int[] votes, int k) {
		int count = 0;
		Arrays.sort(votes);
		int maxVal = votes[votes.length - 1];
		for (int x = 0; x < votes.length - 1; x++)
			if (votes[x] + k > maxVal)
				count++;
		if (maxVal + k > votes[votes.length - 2])
			count++;
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(electionsWinners(new int[] { 2, 3, 5, 2 }, 3));
	}

}
