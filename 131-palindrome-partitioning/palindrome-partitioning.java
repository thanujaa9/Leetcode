class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        List<String> curr=new ArrayList<>();

        backtrack(0,s,curr,ans);
        return ans;
    }
    public void backtrack(int idx,String s,List<String> curr,List<List<String>> ans){
        if(idx==s.length()){
            ans.add(new ArrayList<>(curr));
            return ;
        }
        for(int i=idx;i<s.length();i++){
            if(isPalindrome(idx,i,s)){
                curr.add(s.substring(idx,i+1));
                backtrack(i+1,s,curr,ans);
                curr.remove(curr.size()-1);
            }
        }
    }
    public boolean isPalindrome(int left,int right,String s){
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
            
        }
        return true;
    }
}