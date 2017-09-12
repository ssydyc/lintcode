public class Solution {
    /*
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public List<Integer> previousPermuation(List<Integer> nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.size() == 0) {
            return res;
        }
        int n = nums.size();
        int swapIndex1 = -1;
        int swapIndex2 = -1;
        for (int i = n - 1; i > 0; i--) {
            if (nums.get(i) < nums.get(i - 1)) {
                swapIndex1 = i - 1;
                break;
            }
        }
        if (swapIndex1 != -1) {
            for (int i = n - 1; i > swapIndex1; i--) {
                if (nums.get(swapIndex1) > nums.get(i)) {
                    swapIndex2 = i;
                    break;
                }
            }
            swap(nums, swapIndex1, swapIndex2);
        }
        reverse(nums, swapIndex1 + 1);
        return nums;
    }
    
    private void reverse(List<Integer> nums, int start) {
        int end = nums.size() - 1;
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
    
    private void swap(List<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }
}
