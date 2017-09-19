public class Solution {
    /*
     * @param num: A list of integers
     * @return: An integer
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        int res = 0;
        for (int num : nums) {
            if (set.contains(num)) {
                int cur = getConsecutiveNum(num, set);
                if (res < cur) {
                    res = cur;
                }
            }
        }
        return res;
    }
    
    private int getConsecutiveNum(int num, Set<Integer> set) {
        int res = 1;
        set.remove(num);
        int right = num + 1;
        int left = num - 1;
        
        while (set.contains(right)) {
            set.remove(right++);
            res++;
        }
        while (set.contains(left)) {
            set.remove(left--);
            res++;
        }
        return res;
    }
}
