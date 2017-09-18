public class Solution {
    /*
     * @param nums: an integer array
     * @param target: An integer
     * @return: the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int res = Integer.MAX_VALUE;
        
        while (left < right) {
            int cur = nums[left] + nums[right];
            if (cur < target) {
                left++;
            } else if (cur > target) {
                right--;
            } else {
                return 0;
            } 
            res = Math.min(res, Math.abs(target - cur));
        }
        return res;
    }
}
