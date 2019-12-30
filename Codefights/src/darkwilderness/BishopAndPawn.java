package darkwilderness;

public class BishopAndPawn {

	static boolean bishopAndPawn(String bishop, String pawn) {
		return (Math.abs((int) bishop.charAt(0) - (int) pawn.charAt(0))) == Math
				.abs((Integer.parseInt(Character.toString(bishop.charAt(1)))
						- Integer.parseInt(Character.toString(pawn.charAt(1)))));
	}

	public static void main(String[] args) {
		System.out.println(bishopAndPawn("C3", "B3"));
	}

}
