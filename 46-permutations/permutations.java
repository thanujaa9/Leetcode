class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> ans=new ArrayList<>();
        backtrack(0,nums,ans);
        return ans;
    }
    public void backtrack(int idx,int[] nums,List<List<Integer>> ans){
        if(idx==nums.length){
            List<Integer> curr=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                curr.add(nums[i]);
            }
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=idx;i<nums.length;i++){
            swap(i,idx,nums);
            backtrack(idx+1,nums,ans);
            swap(i,idx,nums);
        }
    }
    private void swap(int i,int j,int[] nums){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}