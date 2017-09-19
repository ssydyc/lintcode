public class Solution {
    /*
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int cur = 0;
        for (int num : nums) {
            if (cur == 0) {
                cur++;
            } else {
                int index = getLargestSmaller(nums, cur, num);
                nums[index + 1] = num;
                if (index + 1 == cur) {
                    cur++;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < cur; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                res++;
            }
        }
        return res;
    }
    
    private int getLargestSmaller(int[] nums, int cur, int num) {
        int left = 0;
        int right = cur - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= num) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[right] <= num) {
            return right;
        } else if (nums[left] <= num){
            return left;
        } else {
            return -1;
        }
    }
}
