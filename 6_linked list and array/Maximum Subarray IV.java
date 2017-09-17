public class Solution {
    /*
     * @param nums: an array of integer
     * @param k: an integer
     * @return: the largest sum
     */
    public int maxSubarray4(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return 0;
        }
        int preSum = 0;
        int preKSum = 0;
        int minPreKSum = Integer.MAX_VALUE;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if (i >= k) {
                preKSum += nums[i - k];
            }
            if (i >= k - 1) {
                minPreKSum = Math.min(minPreKSum, preKSum);
                res = Math.max(res, preSum - minPreKSum);
            }
        }
        return res;
    }
}
