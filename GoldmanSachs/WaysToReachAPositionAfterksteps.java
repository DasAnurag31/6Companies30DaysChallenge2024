class Solution {
    int mod = 1000000007;
    private int recursion(int current, int target, int remaining, int[][] dp){
        int diff = Math.abs(target - current);
        if(remaining < diff){
            return 0;
        }
        if(remaining == 0  && current == target){
            return 1;
        }
        if(remaining == 0){
            return 0;
        }
        if(dp[current][remaining] != -1){
            return dp[current][remaining] % mod;
        }
        int left = recursion(current - 1, target, remaining - 1, dp) % mod;
        int right = recursion(current + 1, target, remaining - 1, dp) % mod;
        return dp[current][remaining] = (left + right) % mod;
    }
    public int numberOfWays(int s, int e, int k) {
        int diff = Math.abs(e - s);
        if(k < diff){
            return 0;
        }
        s = k ;
        e = s + diff;
        int[][] dp = new int[3*k+1][k+1];
        for(int[] rows:dp){
            Arrays.fill(rows, -1);
        }
        return recursion(s,e,k,dp) % mod;
    }
}