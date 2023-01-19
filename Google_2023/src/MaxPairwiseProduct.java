import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProduct(int [] numbers) {
        if(Objects.isNull(numbers) || numbers.length == 0) return 0;
        if(numbers.length == 1) return numbers[0];

        long firstMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;

        for (int number : numbers) {
            if (firstMax <= number) {
                secondMax = firstMax;
                firstMax = number;
            } else if(secondMax <= number) {
                secondMax = number;
            }
        }


        return firstMax * secondMax;
    }
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                        InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
