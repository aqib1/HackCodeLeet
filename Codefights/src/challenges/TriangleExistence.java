package challenges;

public class TriangleExistence {

	static boolean triangleExistence(int[] sides) {
		 return (sides[0] + sides[1] > sides[2] && sides[1] + sides[2] > sides[0] && sides[0] + sides[2] > sides[1]); 
	}

	public static void main(String[] args) {
		

	}

}
