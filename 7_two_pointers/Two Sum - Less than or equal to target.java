public class Solution {
    /*
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum5(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int res = 0;
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else {
                res += right - left;
                left++;
            }
        }
        return res;
    }
}
