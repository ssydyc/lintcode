public class Solution {
    /*
     * @param nums: an integer array
     * @param low: An integer
     * @param high: An integer
     * @return: 
     */
    public void partition2(int[] nums, int low, int high) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int n = nums.length;
        int leftSplit = 0;
        int rightSplit = n - 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] < low) {
                swap(nums, leftSplit++, i);
            }
            if (nums[i] > high) {
                swap(nums, rightSplit--, i);
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
