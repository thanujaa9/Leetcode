
class Solution {
    
    public int climbStairs(int n) {
       int  prev1=1;
       int prev2=1;

       if(n<=0){
        return n;
       }
       for(int i=2;i<=n;i++){
        int curri=prev1+prev2;

        prev2=prev1;
        prev1=curri;
        
       }
       return prev1;
        
    }
    
}