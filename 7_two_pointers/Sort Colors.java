public class Solution {
    /*
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int nextStart = split(nums, 0, 0);
        split(nums, nextStart, 1);
    }
    
    private int split(int[] nums, int start, int split) {
        int cur = start;
        int n = nums.length;
        
        for (int i = start; i < n; i++) {
            if (nums[i] <=  split) {
                int temp = nums[i];
                nums[i] = nums[cur];
                nums[cur++] = temp;
            }
        }
        return cur;
    }
}
