class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
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
            return ;
        }
        HashSet<Integer> st=new HashSet<>();
        for(int i=idx;i<nums.length;i++){
            if(st.contains(nums[i])){
                continue;
            }
            st.add(nums[i]);
            swap(idx,i,nums);
            backtrack(idx+1,nums,ans);
            swap(idx,i,nums);
        }
    }
    public void swap(int i,int j,int[] nums){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}