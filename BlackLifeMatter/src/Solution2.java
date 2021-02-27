import java.io.Serializable;

class Solution2 implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	transient int mod=1000000000+7;
    Integer dp[][];
    int arr[][]= {{1},{0,2},{0,1,3,4},{2,4},{0}};
    int find(int size,int n,int curr){
        if(size==n-1)
            return 1;
        if(dp[size][curr]!=null)
            return dp[size][curr];
        int count=0;
        for(int d : arr[curr]){
            dp[size+1][d]=find(size+1,n,d);
            count=(count+dp[size+1][d])%mod;
        }
        return dp[size][curr]=count;
    }
    
    public int countVowelPermutation(int n) {
    	
        dp=new Integer[n+1][5];
        int count=0;
        for(int i=0;i<5;i++)
        count=(count+find(0,n,i))%mod;
        return count;
    }
}