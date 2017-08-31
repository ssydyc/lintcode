class Solution {
    
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
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
        }
        Set<Integer> visited = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (visited.contains(nums[i])) {
                continue;
            }
            swap(start, i, nums);
            cur.add(nums[start]);
            helper(res, start + 1, cur, nums);
            cur.remove(cur.size() - 1);
            swap(start, i, nums);
            visited.add(nums[i]);
        }
    }
    
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}
