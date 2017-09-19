public class Solution {
    /*
     * @param nums: a set of distinct positive integers
     * @return: the largest subset 
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        LinkedList<Integer> res = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int[] local = new int[n];
        int[] prev = new int[n];
        
        local[0] = 1;
        prev[0] = -1;
        for (int i = 1; i < n; i++) {
            local[i] = 1;
            prev[i] = -1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (local[j] + 1 > local[i]) {
                        local[i] = local[j] + 1;
                        prev[i] = j;
                    }
                }
            }
        }
        
        // Get the maixmum subset.
        int maxIndex = -1;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (local[i] > max) {
                max = local[i];
                maxIndex = i;
            }
        }
        
        while (maxIndex != -1) {
            res.addFirst(nums[maxIndex]);
            maxIndex = prev[maxIndex];
        }
        return res;
    }
}
