public class Solution {
    /*
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(List<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return Integer.MIN_VALUE;
        }
        int[] maxPreSum = new int[nums.size()];
        int preSum = 0;
        int minPreSum = 0;
        for (int i = 0; i < nums.size(); i++) {
            preSum += nums.get(i);
            if (i == 0) {
                maxPreSum[0] = preSum - minPreSum;
            } else {
                maxPreSum[i] = Math.max(maxPreSum[i - 1], preSum - minPreSum);
            }
            minPreSum = Math.min(minPreSum, preSum);
        }
        
        int res = Integer.MIN_VALUE;
        preSum = 0;
        minPreSum = 0;
        for (int i = nums.size() - 1; i > 0; i--) {
            preSum += nums.get(i);
            res = Math.max(preSum - minPreSum + maxPreSum[i - 1], res);
            minPreSum = Math.min(minPreSum, preSum);
        }
        return res;
    }
}
