public class Solution {
    /*
     * @param k: An integer
     * @param nums: An integer array
     * @return: kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
        return helper(k, nums, 0, nums.length);
    }
    
    private int helper(int k, int[] nums, int start, int end) {
        int split = splitArray(nums, start, end, nums[start]);
        if (split - start > k) {
            return helper(k, nums, start + 1, split);
        } else if (split - start < k){
            return helper(k - (split - start), nums, split, end);
        } else {
            return nums[start];
        }
    }
    
    private int splitArray(int[] nums, int start, int end, int pivot) {
        int cur = start;
        for (int i = start; i < end; i++) {
            if (nums[i] <= pivot) {
                int temp = nums[i];
                nums[i] = nums[cur];
                nums[cur++] = temp;
            }
        }
        return cur;
    }
}

// [9, 3, 2, 4, 8], 3
// [3, 2, 4, 8], 3
// 
