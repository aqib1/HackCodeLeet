public class Sqrt {

    // Time complexity O(Log N)
    // Space complexity O(1)

    public int mySqrt(int x) {
        if(x < 2) return x;

        int start = 2, end = x / 2;

        while(start <= end) {
            int mid = (start + end) / 2;
            long sq = (long)mid * mid;
            if(x > sq) start = mid + 1;
            else if(x < sq) end = mid - 1;
            else return mid;
        }

        return end;
    }

    public static void main(String[] args) {
        Sqrt sq = new Sqrt();
        System.out.println(sq.mySqrt(8));
    }
}
