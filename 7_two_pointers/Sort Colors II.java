public class Solution {
    /*
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        if (colors == null || colors.length <= 1) {
            return;
        }
        int nextStart = 0;
        for (int i = 1; i <= k; i++) {
            nextStart = split(colors, nextStart, i);
        }
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
