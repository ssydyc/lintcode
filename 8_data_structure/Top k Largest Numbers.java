public class Solution {
    /*
     * @param nums: an integer array
     * @param k: An integer
     * @return: the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        Queue<Integer> topK = new PriorityQueue<Integer>(k + 1);
        
        for (int num : nums) {
            topK.offer(num);
            if (topK.size() > k) {
                topK.poll();
            }
        }
        int[] res = new int[topK.size()];
        int cur = topK.size() - 1;
        while (!topK.isEmpty()) {
            res[cur--] = topK.poll();
        }
        return res;
    }
}
