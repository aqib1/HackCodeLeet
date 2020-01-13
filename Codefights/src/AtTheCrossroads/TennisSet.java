package AtTheCrossroads;

public class TennisSet {

	boolean tennisSet(int score1, int score2) {
		int w = Math.max(score1, score2), l = Math.min(score1, score2);
		return w == 6 && l < 5 || w == 7 && (l == 5 || l == 6);
	}

	public static void main(String[] args) {

	}

}
