public class Solution {
    /*
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int minPreSum = 0;
        int curPreSum = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            curPreSum += nums[i];
            res = Math.max(res, curPreSum - minPreSum);
            minPreSum = Math.min(curPreSum, minPreSum);
        }
        return res;
    }
}
