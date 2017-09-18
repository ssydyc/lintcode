public class Solution {
    /*
     * @param nums: an array of Integer
     * @param target: an integer
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum7(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[2];
        }
        int n = nums.length;
        int[] res = new int[2];
        Map<Integer, Integer> numIndex = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            if (numIndex.containsKey(nums[i] - target)) {
                res[0] = numIndex.get(nums[i] - target) + 1;
                res[1] = i + 1;
                break;
            }
            if (numIndex.containsKey(nums[i] + target)) {
                res[0] = numIndex.get(nums[i] + target) + 1;
                res[1] = i + 1;
                break;
            }
            numIndex.put(nums[i], i);
        }
        return res;
    }
}
