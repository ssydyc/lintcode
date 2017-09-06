public class Solution {
    
    /**
     * @param nums an array with positive and negative numbers
     * @param k an integer
     * @return the maximum average
     */
    public double maxAverage(int[] nums, int k) {
        double left = getMin(nums);
        double right = getMax(nums);
        while (right - left > 0.00001) {
            double mid = left + (right - left) / 2;
            if (hasAverage(nums, k, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }
    
    private int getMin(int[] nums) {
        int res = Integer.MAX_VALUE;
        for (int num : nums) {
            if (res > num) {
                res = num;
            }
        }
        return res;
    }
    
    private int getMax(int[] nums) {
        int res = Integer.MIN_VALUE;
        for (int num : nums) {
            if (res < num) {
                res = num;
            }
        }
        return res;
    }
    
    private boolean hasAverage(int[] nums, int k, double mid) {
        int n = nums.length;
        double minPreSum = 0;
        double[] preSum = new double[n + 1];
        preSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + (double) nums[i - 1] - mid;
        }
        for (int i = 0; i + k <= n ; i++) {
            minPreSum = Math.min(minPreSum, preSum[i]);
            if (preSum[i + k] - minPreSum >= 0) {
                return true;
            } 
        }
        return false;
    }
    
}
