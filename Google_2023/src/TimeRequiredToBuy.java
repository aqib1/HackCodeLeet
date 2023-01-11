public class TimeRequiredToBuy {
    public static int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        for (int ticket : tickets) {
            if (ticket <= k) time += ticket;
            else time += k;
        }
        return time;
    }

    public static void main(String[] args) {
        System.out.println(timeRequiredToBuy(new int[] {}, 0));
    }
}
