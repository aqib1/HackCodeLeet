public class TimeRequiredToBuy {
    public static int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        for (int i = 0; i < tickets.length; i++) {
            if(tickets[i] < tickets[k])
                time += tickets[i];
            else {
                time += tickets[k];
                if(i > k)
                    time--;
            }
        }
        return time;
    }

    public static void main(String[] args) {
        System.out.println(timeRequiredToBuy(new int[] {15,66,3,47,71,27,54,43,97,34,94,33,54,26,15,52,20,71,88,42,50,6,66,88,36,99,27,82,7,72}, 18));
    }
}
