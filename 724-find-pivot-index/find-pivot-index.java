class Solution {
    public int pivotIndex(int[] nums) {
        int n=nums.length;
        int[] prefix=new int[n];
        int idx=-1;
        
        prefix[0]=0;

        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+nums[i-1];
           
        }
        int suffix=0;
        for(int i=n-1;i>=0;i--){
         
            if(suffix==prefix[i]){
                idx=i;

            }
            suffix=suffix+nums[i];
        }
        return idx==-1?-1:idx;
    }
}