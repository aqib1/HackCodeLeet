public class UniqueBinaryTree {
    public int numTrees(int n) {
        int []result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;

        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                result[i] += result[j - 1] * result[i - j];
            }
        }
        return result[n];
    }

    public int numTreesByCatalanNumber(int numb) {
        long Cn = 1L;
        for (int n = 0; n <= numb; n++) {
            Cn = Cn * 2L * (2L * n + 1L) / (n + 2L);
        }
        return (int)Cn;
    }
}
