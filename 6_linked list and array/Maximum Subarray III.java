public class Solution {
    /*
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
    public int maxSubArray(int[] nums, int k) {
        // global[n][k] = max(global[n - 1][k], local[n][k]);
        // local[n][k] = max(global[n - 1][k - 1] + nums[n], local[n][k]);
        if (nums == null || nums.length == 0 || k > nums.length) {
            return Integer.MIN_VALUE;
        }
        int n = nums.length;
        int[][] global = new int[n][k + 1];
        int[][] local = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k && j <= i + 1; j++) {
                if (i == 0) {
                    local[i][j] = nums[i];
                    global[i][j] = nums[i];
                    continue;
                } 
                if (j == i + 1) {
                    local[i][j] = global[i - 1][j - 1] + nums[i];
                    global[i][j] = local[i][j];
                    continue;
                }
                if (j == 1) {
                    local[i][j] = Math.max(local[i - 1][j], 0) + nums[i];
                } else {
                    local[i][j] =  Math.max(
                        global[i - 1][j - 1], local[i - 1][j]) + nums[i];
                }
                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
            }
        }
        return global[n - 1][k];
    }
}
