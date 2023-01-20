
public class FibonacciNumbers {

    public int fib(int n) {
        if(n < 1) return 0;

        int []res = new int[n + 1];
        res[0] = 0;
        res[1] = 1;

        for(int x=2; x<=n; x++) {
            res[x] = res[x-1] + res[x-2];
        }

        return res[n];
    }

    // Not efficient Time complexity O(2N) and space is O(N)
    public static int fibonacciNumberUsingRecursion(int gen) {
        if(gen <= 1) return gen;

        return fibonacciNumberUsingRecursion(gen - 1)
                + fibonacciNumberUsingRecursion(gen - 2);
    }

    // Time O(N) and space O(N)
    public static int fibonacciNumbers(int generations) {
        int [] fibonacci = new int[generations + 1];
        fibonacci[0] = 0;
        fibonacci[1] = 1;

        for(int x = 2; x <= generations; x++) {
            fibonacci[x] = fibonacci[x - 1] + fibonacci[x - 2];
        }

        return fibonacci[generations];
    }

    public static void main(String[] args) {
        System.out.println(fibonacciNumbers(10));
        System.out.println(fibonacciNumberUsingRecursion(10));
    }

}
