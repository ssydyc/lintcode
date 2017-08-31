class Solution {
    
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        
        if (nums == null) {
            return res;
        }
        helper(res, 0, cur, nums);
        return res;
    }
    
    private void helper(
        List<List<Integer>> res, int start, List<Integer> cur, int[] nums) {
        if (start == nums.length) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(start, i, nums);
            cur.add(nums[start]);
            helper(res, start + 1, cur, nums);
            cur.remove(cur.size() - 1);
            swap(start, i, nums);
        }
    }
    
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}
