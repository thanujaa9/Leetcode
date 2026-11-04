class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;

        HashSet<Integer> st=new HashSet<>();
        for(int i=0;i<n;i++){
            st.add(nums[i]);
        }
        int longest=0;

        for(int num:st ){
            if(!st.contains(num-1)){
                
                int i=1;
                while(st.contains(num+i)){
                    
                    i++;
                }
                longest=Math.max(longest,i);
            }
        }
        return longest;
    }
}