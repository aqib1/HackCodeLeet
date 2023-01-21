public class GCDs {
    public static int naiveGCD(int a, int b) {
        int gcd = 0;

        for(int x = 1; x <= (a+b); x++) {
            if(a%x == 0 && b%x == 0) gcd = x;
        }

        return gcd;
    }

    public static void main(String[] args) {
        System.out.println(naiveGCD(4, 10));
    }
}
