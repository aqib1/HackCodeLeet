public class UniqueBTI {
    public static int numTrees(int numb) {
        int []result = new int [numb + 1];
        result[0] = 1;
        result[1] = 1;
        for(int root = 2; root <= numb; root++) {
            for(int left = 1; left <= root; left++) {
                result[root] += result[left - 1] * result [root - left];
            }
        }
        return result[numb];
    }


    // 2 x (2n + 1) / n + 2 Cn
    // Using catalan number
    public static int numTreesUsingCatalanNumber(int numb) {
       long catalanNumber = 1L;
       for(int n = 1; n < numb; n++) {
           catalanNumber = catalanNumber * 2L * (2L * n + 1L) / (n + 2L);
       }
       return (int)catalanNumber;
    }
    public static void main(String[] args) {
        System.out.println(numTreesUsingCatalanNumber(3));
    }
}
