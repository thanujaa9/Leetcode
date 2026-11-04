class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;

        int[] prefix=new int[n];
        int[] suffix=new int[n];
        int prod=nums[0];
        prefix[0]=1;
        for(int i=1;i<n;i++){
            prefix[i]=prod;
            prod*=nums[i];  
        }
        suffix[n-1]=1;
        prod=nums[n-1];
        for(int i=n-2;i>=0;i--){
            suffix[i]=prod;
            prod*=nums[i];  
        }

        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=prefix[i]*suffix[i];
        }
        return ans;
    }
}