public class Solution {
    /*
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs2(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        int[] res = new int[n + 1];     
        res[0] = 1;
        res[1] = 1;
        res[2] = 2;
        for (int i = 3; i <= n; i++) {
            res[i] += res[i - 1] + res[i - 2] + res[i - 3];
        }
        return res[n];
    }
}
