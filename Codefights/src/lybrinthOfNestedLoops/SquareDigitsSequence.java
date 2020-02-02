package lybrinthOfNestedLoops;

import java.util.ArrayList;
import java.util.List;

public class SquareDigitsSequence {
	static int squareDigitsSequence(int a0) {
		String val = String.valueOf(a0);
		if (val.length() == 1)
			return 2;
		int count = 1;
		List<String> data = new ArrayList<>();
		data.add(val);
		do {
			int sum = 0;
			for (int x = 0; x < val.length(); x++) {
				sum += Math.pow(Integer.parseInt(String.valueOf(val.charAt(x))), 2);
			}
			val = String.valueOf(sum);
			count++;
		} while (!data.contains(val));
		return count;
	}
	
	static int squareDigitsSequenceFast(int a0) {
	    int count=1,b=a0;
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(a0);
        while(true){
            int c=0;count++;
            while(b>0){
                c+=(b%10)*(b%10);  
                b/=10;
            }
            if(arr.contains(c)){
                break;
            }
            else{
                arr.add(c);
                b=c;
            }
        }
        return count;
	}

	public static void main(String[] args) {
		System.out.println(squareDigitsSequence(16));

	}

}
