import java.util.HashMap;
import java.util.Map;

public class GCDs {



    public static boolean gcdSort(int[] nums) {
        Map<String, Boolean> record = new HashMap<>();
        for(int x=0; x<nums.length;x++) {
            for (int y = x + 1; y < nums.length; y++) {
                String key = nums[x]+","+nums[y];
                if(!record.containsKey(key)) {
                    record.put(key, false);
                }
                if (!record.get(key) && euclidGCD(nums[x], nums[y]) > 1) {
                    int tmp = nums[x];
                    nums[x] = nums[y];
                    nums[y] = tmp;
                    record.put(key, true);
                }
            }
        }

        for(int x=0; x<nums.length - 1; x++) {
            if(nums[x] > nums[x+1]) return false;
        }
        return true;
    }



    // Time complexity OLog(AB)
    // GCD(a,b) = GCD(a',b) = GCD(b,a')
    public static int GCD(int a, int b) {
        if(a>b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        return euclidGCD(a, b);
    }
    public static int euclidGCD(int a, int b) {
        if(b == 0) return a;
        return euclidGCD(b, a%b);
    }

    // Time complexity O(A+B) which is slow
    public static int naiveGCD(int a, int b) {
        int gcd = 0;

        for(int x = 1; x <= (a+b); x++) {
            if(a%x == 0 && b%x == 0) gcd = x;
        }

        return gcd;
    }

    public static void main(String[] args) {
//        System.out.println(gcdSort(new int[]{10,5,9,3,15}));
        System.out.println(GCD(357,234));
    }
}
