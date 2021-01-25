import java.util.stream.IntStream;

public class Task2 {

	public static int solution(int []A, int []B) {
		int count = 0;
		int range = A.length;
		for(int x=1; x<range; x++) {
			long leftSumA = IntStream.range(0, x).map(y-> A[y]).sum();
			long rightSumA = IntStream.range(x, range).map(y-> A[y]).sum();
			
			long leftSumB = IntStream.range(0, x).map(y-> B[y]).sum();
			long rightSumB = IntStream.range(x, range).map(y-> B[y]).sum();
			
			if(leftSumA == rightSumA && leftSumB == rightSumB && 
					leftSumA == leftSumB && rightSumA == rightSumB) {
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 4, 2, -2, 5}, new int[] {7, -2, -2, 2, 5}));
	}
}
