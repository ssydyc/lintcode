public class Solution {
    /*
     * @param nums: an array of integers
     * @param k1: An integer
     * @param k2: An integer
     * @return: the largest sum
     */
    public int maxSubarray5(int[] nums, int k1, int k2) {
        if (nums == null || nums.length < k1 || k2 < k1) {
            return 0;
        }
        LinkedList<Integer> deque = new LinkedList<>();
        int n = nums.length;
        int res = Integer.MIN_VALUE;
        int[] preSum = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        for (int i = k1; i < n + 1; i++) {
            int toAdd = i - k1;
            while (!deque.isEmpty() 
                && preSum[toAdd] <= preSum[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.add(toAdd);
            if (i - deque.peekFirst() > k2) {
                deque.removeFirst();
            }
            res = Math.max(res, preSum[i] - preSum[deque.peekFirst()]);
        }
        return res;
    }
}
