package IntroGates;

public class PhoneCall {

	static int phoneCall(int min1, int min2_10, int min11, int s) {
		int count=0;
		if(s >= min1) {
		 count++;
		 int first =  (s - min1);
		 count += (first > (min2_10*9)) ? 9 : (first/min2_10);
		 int second = first - (min2_10 * 9);
		 if(second > min11){
		     count += second / min11;
		 }   
		}
		 return count;
	}

	public static void main(String[] args) {
		System.out.println(phoneCall(2, 2, 1, 2));
	}

}
