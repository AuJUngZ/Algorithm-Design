public class Knapsack {
    public static int knapsack(int[] weights, int[] values,int n, int c) {
        int[][] dp = new int[n + 1][c + 1];
        for(int i = 1 ; i <= n ; i++) {
            for(int j = 1 ; j <= c ; j++) {
                if(j >= weights[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][c];
    }

    public static int knapsack2(int[] w,int[] p,int n,int c,int[][] dp){
        if(n == 0 || c == 0){
            return 0;
        }else{
            if(dp[n][c] != 0){
                return dp[n][c];
            }else{
                if(c >= w[n-1]){
                    dp[n][c] = Math.max(p[n-1]+knapsack2(w,p,n-1,c-w[n-1],dp),knapsack2(w,p,n-1,c,dp));
                }else{
                    dp[n][c] = knapsack2(w,p,n-1,c,dp);
                }
            }
        }
        return dp[n][c];
    }
}
