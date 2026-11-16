class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        int first = solve(nums, 0, n - 2);
        int second = solve(nums, 1, n - 1);

        return Math.max(first, second);
    }

    public int solve(int[] nums, int start, int end) {
        int next2=0,next1=0;

        for (int i = end; i >= start; i--) {
            int pick = nums[i] + next2;
            int notPick = next1;

            int curr = Math.max(pick, notPick);
            next2=next1;
            next1=curr;
        }

        return next1;
    }
}