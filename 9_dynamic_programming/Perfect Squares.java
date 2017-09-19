public class Solution {
    /*
     * @param n: a positive integer
     * @return: An integer
     */
    public int numSquares(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 1; i + j * j <= n; j++) {
                int next = i + j * j;
                if (res[next] == 0) {
                    res[next] = res[i] + 1;
                } else {
                    res[next] = Math.min(res[next], res[i] + 1);
                }
            }
        }
        return res[n];
    }
}
