public class Solution {
    /*
     * @param nums: an integer unsorted array
     * @param k: an integer from 1 to n
     * @return: the kth largest element
     */
// Use quickSort to find results.
    public int kthLargestElement2(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) {
            return 0;
        }
        return helper(nums, 0, nums.length, k);
    }
    
    private int helper(int[] nums, int start, int end, int k) {
        int splitIndex = split(nums, start, end, nums[end - 1]);
        if (end - splitIndex > k) {
            return helper(nums, splitIndex, end - 1, k);
        } else if (end - splitIndex < k) {
            return helper(nums, start, splitIndex, k - (end - splitIndex));
        } else {
            return nums[end - 1];
        }
    }
    
    private int split(int[] nums, int start, int end, int pivot) {
        int cur = start;
        for (int i = start; i < end; i++) {
            if (nums[i] < pivot) {
                int temp = nums[i];
                nums[i] = nums[cur];
                nums[cur++] = temp;
            }
        }
        return cur;
    }
}
