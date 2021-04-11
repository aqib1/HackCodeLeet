import java.util.HashSet;
import java.util.Set;

public class Task1 {
	
	  public static int vowelsubstring(String s) {
	        int count = 0;
	        int j=0;
	        for(int i=0;i<=s.length()-5;i++){
	            if(isVowel(s.charAt(i))){
	                if(j<=i)
	                    j=i+1;
	                for(;j<s.length();j++){
	                    if(!isVowel(s.charAt(j)))
	                        break;
	                }
	                if(j-i<5)
	                    continue;
	                count += countValidSubStrings(s.substring(i,j));
	                i=j;
	            }
	        }
	        return count;
	     }
	public static int countValidSubStrings(String substr){
	        int len = substr.length();
	        int count=0;
	        for(int i=0;i<=substr.length()-5;i++){
	            for(int j=i+5; j<=substr.length();j++){
	                if(validateSubString(substr.substring(i,j))){
	                    count+=(len-j)+1;
	                    break;
	                }
	                
	            }
	        }
	        return count;
	    }

	    public static boolean validateSubString(String substr){
	        if(substr.length()<5)
	            return false;
	        Set<Character> set = new HashSet<>();
	        set.add('a');
	        set.add('e');
	        set.add('i');
	        set.add('o');
	        set.add('u');
	        for(char c:substr.toCharArray()){
	            if(set.contains(c))
	                set.remove(c);
	        }
	        if(set.size()>0)
	            return false;
	        return true;
	    }

	    public static boolean isVowel(char c){
	        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
	            return true;
	        return false;
	    }
	   
	
	public static void main(String[] args) {
		System.out.println(vowelsubstring("aaeiouxa"));
	}
}
