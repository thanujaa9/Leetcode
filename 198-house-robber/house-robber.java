class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n+2];
        dp[dp.length-2]=0;
        dp[dp.length-1]=0;

        for(int i=n-1;i>=0;i--){
            int pick=nums[i]+dp[i+2];
            int notPick=dp[i+1];
            dp[i] = Math.max(pick, notPick);
        }
    return dp[0];
    }
    
}