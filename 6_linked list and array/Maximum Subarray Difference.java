public class Solution {
    /*
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two substrings
     */
    public int maxDiffSubArrays(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int preSum = 0;
        int maxPreSum = 0;
        int minPreSum = 0;
        int[] maxArraySum = new int[nums.length];
        int[] minArraySum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if (i == 0) {
                maxArraySum[i] = preSum - minPreSum;
                minArraySum[i] = preSum - maxPreSum;
            } else {
                maxArraySum[i] = Math.max(
                    maxArraySum[i - 1], preSum - minPreSum);
                minArraySum[i] = Math.min(
                    minArraySum[i - 1], preSum - maxPreSum);
            }
            maxPreSum = Math.max(preSum, maxPreSum);
            minPreSum = Math.min(preSum, minPreSum);
        }
        
        // Return results.
        int res = Integer.MIN_VALUE;
        preSum = 0;
        maxPreSum = 0;
        minPreSum = 0;
        for (int i = nums.length - 1; i >= 1; i--) {
            preSum += nums[i];
            int curMax = Math.max(Math.abs(maxArraySum[i - 1] - (preSum - maxPreSum)), 
                Math.abs(minArraySum[i - 1] - (preSum - minPreSum)));
            maxPreSum = Math.max(preSum, maxPreSum);
            minPreSum = Math.min(preSum, minPreSum);
            if (res < curMax) {
                res = curMax;
            }
        }
        return res;
    }
}
