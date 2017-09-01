public class Solution {
    
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int left = 0;
        int n = nums.length;
        int right = n - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[n - 1]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return nums[left] < nums[right] ? nums[left] : nums[right];
    }
    
}
