public class Solution {
    /*
     * @param nums: an array of Integer
     * @param target: target = nums[index1] + nums[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[2];
        while (left < right) {
            int cur = nums[left] + nums[right];
            if (cur < target) {
                left++;
            } else if (cur > target){
                right--;
            } else {
                res[0] = left++;
                res[1] = right--;
            }
        }
        res[0]++;
        res[1]++;
        return res;
    }
}
