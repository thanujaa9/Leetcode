class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> st=new HashSet<>();
        int maxlen=0;

        int left=0;
        for(int right =0;right<s.length();right++){
            char ch=s.charAt(right);

            if(st.contains(ch)){

                while(st.contains(ch)){
                    st.remove(s.charAt(left));
                    left++;
                }
            }
            st.add(ch);
            maxlen= Math.max(maxlen,right-left+1);


        }
        return maxlen;

    }
}