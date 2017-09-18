public class Solution {
    /*
     * @param nums: an array of integer
     * @param target: An integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int res = 0;
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else {
                res += n - 1 - right;
                left++;
            }
        }
        return res + (n - left) * (n - left - 1) / 2;
    }
    
// n - left - 1 + ..... + 1 
}
