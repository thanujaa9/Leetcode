class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used=new boolean[nums.length];
        List<List<Integer>> ans=new ArrayList<>();
        backtrack(used,nums,new ArrayList<>(),ans);
        return ans;
    }
    public void backtrack(boolean[] used,int[] nums,List<Integer> curr,List<List<Integer>> ans){
        if(curr.size()==nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]==true) continue;
            used[i]=true;
            curr.add(nums[i]);
            backtrack(used,nums,curr,ans);
            curr.remove(curr.size()-1);
            used[i]=false;

        }
    }
}