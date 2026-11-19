class Solution {
    public int fib(int n) {
        return solve(0,1,n);
    }
    public int solve(int prev2,int prev1,int n){
        if(n<=1){
            return n;
        }
        for(int i=2;i<=n;i++){
            int curr=prev2+prev1;
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
}