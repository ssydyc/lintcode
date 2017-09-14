public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        ArrayList<Integer> res = new ArrayList<>();
        Map<Integer, Integer> sums = new HashMap<>();
        int cur = 0;
        sums.put(cur, 0);
        for (int i = 0; i < nums.length; i++) {
            cur += nums[i];
            if (sums.containsKey(cur)) {
                res.add(sums.get(cur));
                res.add(i);
                return res;
            }
            sums.put(cur, i + 1);
        }
        return res;
    }
}
