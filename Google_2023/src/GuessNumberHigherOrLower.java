interface GuessGame {
    int guess(int num);
}
public class GuessNumberHigherOrLower implements GuessGame {

    // Time complexity O(Log N)
    // Space complexity O(1)
    public int guessNumber(int n) {
        if(n == 1) return 1;

        int start = 0, end = n;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            int result = guess(mid);
            if(result == 0) return mid;
            if(result == 1) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }

    @Override
    public int guess(int num) {
        return Integer.compare(2126753390, num);
    }

    public static void main(String[] args) {
        GuessNumberHigherOrLower i = new GuessNumberHigherOrLower();
        System.out.println(i.guessNumber(2126753390));
    }
}
