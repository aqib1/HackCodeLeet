
public class Test {

	public static int solution(int N) {
		int smallestNumber = 0;
	    if (N <= 1)
	      return smallestNumber;
	    
	    int numberOfDigitsOriginalN = String.valueOf(N).length();
	    while (N > 0) {
	      N--;
	      if (String.valueOf(N).length() ==
	          (numberOfDigitsOriginalN -1)) {
	        return ++N;
	      }
	    }
	    return smallestNumber;
    }
	
	public static void main(String[] args) {
		System.out.println(solution(9));
	}
}
