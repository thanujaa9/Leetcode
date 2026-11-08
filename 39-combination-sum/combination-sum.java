class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();

        backtrack(0,candidates,target,curr,ans);
        return ans;
    }
    public void backtrack(int idx,int[] cand,int target,List<Integer> curr,List<List<Integer>> ans){

        if(target==0){
            ans.add(new ArrayList<>(curr));

        }
        if(target<0){
            return ;
        }
        for(int i=idx;i<cand.length;i++){
            curr.add(cand[i]);
            backtrack(i,cand,target-cand[i],curr,ans);
            curr.remove(curr.size()-1);
        }
    }
}