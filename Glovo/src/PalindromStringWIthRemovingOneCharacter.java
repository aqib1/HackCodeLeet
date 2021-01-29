
public class PalindromStringWIthRemovingOneCharacter {

	public static int possiblePalinByRemovingOneChar(String str) {
		if (str == null || str.isBlank()) {
			return -1;
		}
		int low = 0, heigh = str.length() - 1;
		while(low < heigh) {
			if(str.charAt(low) == str.charAt(heigh) ) {
				low++;
				heigh--;
			} else {
				if(isPalindrome(str, low+1, heigh)) {
					return low;
				}
				if(isPalindrome(str, low, heigh-1)) {
					return heigh;
				}
				return -1;
			}
		}
		
		
		return -2;
	}

	public static boolean isPalindrome(String str, int low, int heigh) {

		while (low < heigh) {
			if (str.charAt(low) != str.charAt(heigh)) {
				return false;
			}
			low++;
			heigh--;
		}

		return true;
	}
	
	public static void main(String[] args) {
		String str = "aebcba"; 
        int idx = possiblePalinByRemovingOneChar(str); 
  
        if (idx == -1) 
            System.out.println("Not Possible"); 
        else if (idx == -2) 
            System.out.println("Possible without " +  
                          "removing any character"); 
        else
            System.out.println("Possible by removing" +  
                               " character at index " + idx); 
	}
}
