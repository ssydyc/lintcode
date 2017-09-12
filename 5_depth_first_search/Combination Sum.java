public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       List<List<Integer>> res = new ArrayList<>();
       List<Integer> cur = new ArrayList<>();
       if (candidates == null || candidates.length == 0) {
           return res;
       }
       Arrays.sort(candidates);
       helper(0, candidates, cur, res, target);
       return res;
    }
    
    private void helper(int start, int[] candidates, List<Integer> cur,
        List<List<Integer>> res, int target) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        int n = candidates.length;
        for (int i = start; i < n && candidates[i] <= target; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            cur.add(candidates[i]);
            helper(i, candidates, cur, res, target - candidates[i]);
            cur.remove(cur.size() - 1);
        }
    }
}
