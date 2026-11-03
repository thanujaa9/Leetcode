class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxavg=0.0;
        double sum=0;
        for(int i=0;i<k;i++){
            sum+=nums[i];

        }
        maxavg=sum;
        for(int i=k;i<nums.length;i++){
            sum=sum-nums[i-k]+nums[i];
            maxavg=Math.max(maxavg,sum);

        }
        return maxavg/k;

    }
}