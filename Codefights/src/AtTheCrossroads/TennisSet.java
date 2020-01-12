package AtTheCrossroads;

public class TennisSet {

	static boolean tennisSet(int score1, int score2) {
		return (score1 >= 5 && score2 >= 5) ? (score1>=7 || score2>=7) ? false: true : true;
	}

	public static void main(String[] args) {
		
	}

}
