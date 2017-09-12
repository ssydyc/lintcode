public class Solution {
    /*
     * @param nums: A list of integers
     * @return: A list of integers
     */
    public int[] nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
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
        return nums;
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


// [1, 3, 6, 5, 4, 3, 2, 1]
// [1, 4, 6, 5, 3, 3, 2, 1]
