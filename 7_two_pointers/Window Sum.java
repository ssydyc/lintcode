public class Solution {
    /*
     * @param nums: a list of integers.
     * @param k: length of window.
     * @return: the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        if (nums == null || k == 0 || nums.length < k) {
            return new int[0];
        }
        int n = nums.length; 
        int[] res = new int[n - k + 1];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (i < k - 1) {
                continue;
            }
            if (i != k - 1) {
                sum -= nums[i - k];
            }
            res[i - k + 1] = sum;
        }
        return res;
    }
}

// [1, 2, 3], k = 2
// i = 0, sum = 1;
// i = 1, sum = 3, res = {3}
// i = 2, sum = 5, res = {3, 5}
