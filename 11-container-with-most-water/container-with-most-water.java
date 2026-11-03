class Solution {
    public int maxArea(int[] height) {
        int left=0,right=height.length-1;
        int maxi=0;

        while(left<right){
            int minheight=Math.min(height[left],height[right]);
            int len=right-left;
            maxi=Math.max(maxi,(minheight*len));
            if(height[left]<height[right]){
                left++;
            }   else{
                right--;
            }   
        }
        return maxi;
    }
}