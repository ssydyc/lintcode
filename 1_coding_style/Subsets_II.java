public class Solution {
    /*
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        Arrays.sort(nums);
        helper(res, 0, cur, nums);
        return res;
    }
    
    private void helper(
        List<List<Integer>> res, int start, List<Integer> cur, int[] nums) {
        res.add(new ArrayList<Integer>(cur));
        if (start == nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i - 1]) {
                continue;
            }
            cur.add(nums[i]);
            helper(res, i + 1, cur, nums);
            cur.remove(cur.size() - 1);
        }
    }
    
}
