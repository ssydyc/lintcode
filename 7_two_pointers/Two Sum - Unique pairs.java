public class Solution {
    /*
     * @param nums: an array of integer
     * @param target: An integer
     * @return: An integer
     */
    public int twoSum6(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int res = 0;
        while (left < right) {
            if (left != 0 && nums[left] == nums[left - 1]) {
                left++;
                continue;
            }
            int cur = nums[left] + nums[right];
            if (cur < target) {
                left++;
            } else if (cur > target) {
                right--;
            } else {
                res += 1;
                left++;
            }
        }
        return res;
    }
}
