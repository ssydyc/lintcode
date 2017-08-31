public class Solution {
    
    /*
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int n = res.size();
            for (int j = 0; j < n; j++) {
                List<Integer> toAdd = new ArrayList<>(res.get(j));
                toAdd.add(nums[i]);
                res.add(toAdd);
            }
        }
        return res;
    }
}
