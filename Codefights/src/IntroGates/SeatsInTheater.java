package IntroGates;

public class SeatsInTheater {

	public static int seatsInTheater(int nCols, int nRows, int col, int row) {
		return ((nCols - col) + 1) * (nRows - row);
	}

	public static void main(String[] args) {
		System.out.println(seatsInTheater(13, 6, 8, 3));

	}

}
