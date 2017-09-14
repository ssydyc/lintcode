public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }
        int sum = 0;
        SumIndex[] sums = new SumIndex[nums.length + 1];
        int closest = Integer.MAX_VALUE;
        
        sums[0] = new SumIndex(0, 0);
        for (int i = 1; i <= nums.length; i++) {
            sum += nums[i - 1];
            sums[i] = new SumIndex(sum, i);
        }
        Arrays.sort(sums, new Comparator<SumIndex>() {
            @Override
            public int compare(SumIndex num1, SumIndex num2) {
                return num1.sum - num2.sum;
            }
        });
        
        for (int i = 0; i < nums.length; i++) {
            int cur = sums[i + 1].sum - sums[i].sum;
            if (closest >= cur) {
                closest = cur;
                res[0] = sums[i].index;
                res[1] = sums[i + 1].index;
            }
        }
        
        if (res[0] > res[1]) {
            int temp = res[0];
            res[0] = res[1];
            res[1] = temp;
        }
        res[1]--;
        return res;
    }
    
    private class SumIndex {
        int sum;
        int index;
        
        private SumIndex(int sum, int index) {
            this.sum = sum;
            this.index = index;
        }
    }
}
