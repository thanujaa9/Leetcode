class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res=new int[nums.length];
        int left=0,right=nums.length-1,k=nums.length-1;


        while(left<=right){
            int l=Math.abs(nums[left]);
            int r=Math.abs(nums[right]);

            if(l>r){
                res[k]=nums[left]*nums[left];
                left++;
            }
            else{
                res[k]=nums[right]*nums[right];
                right--;
            }
            k--;
        }
        return res;
    }
}