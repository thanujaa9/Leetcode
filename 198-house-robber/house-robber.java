class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        
        int next2=0;
       int next1=0;

        for(int i=n-1;i>=0;i--){
            int pick=nums[i]+next2;
            int notPick=next1;
            next2=next1;
            next1= Math.max(pick, notPick);

        }
    return next1;
    }
    
}