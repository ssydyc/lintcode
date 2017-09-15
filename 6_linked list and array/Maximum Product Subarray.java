public class Solution {
    /*
     * @param nums: An array of integers
     * @return: An integer
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int res = nums[0];
        int maxLoc = nums[0];
        int minLoc = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tempMax = Math.max(
                Math.max(maxLoc * nums[i], nums[i]), minLoc * nums[i]);
            minLoc = Math.min(
                Math.min(maxLoc * nums[i], nums[i]), minLoc * nums[i]);
            maxLoc = tempMax;
            res = Math.max(maxLoc, res);
        }
        return res;
    }
}
