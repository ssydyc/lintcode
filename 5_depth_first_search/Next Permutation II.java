public class Solution {
    /*
     * @param nums: An array of integers
     * @return: nothing
     */
    public void nextPermutation(int[] nums) {
       if (nums == null || nums.length <= 1) {
            return;
        }
        
        int swapIndex1 = -1;
        int swapIndex2 = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                swapIndex1 = i - 1;
                break;
            }
        }
        
        if (swapIndex1 != -1) {
            for (int i = nums.length - 1; i > swapIndex1; i--) {
                if (nums[i] > nums[swapIndex1]) {
                    swapIndex2 = i;
                    break;
                }
            }
            swap(nums, swapIndex1, swapIndex2);
        }
        reverse(nums, swapIndex1 + 1);
    }
    
    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
}
}
