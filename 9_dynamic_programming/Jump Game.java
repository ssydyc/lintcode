public class Solution {
    /*
     * @param A: A list of integers
     * @return: A boolean
     */
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) {
            return true;
        }
        int cur = 0;
        int n = A.length;
        
        for (int i = 0; i < n; i++) {
            if (cur < i) {
                break;
            }
            cur = Math.max(cur, i + A[i]);
        }
        return cur >= n - 1;
    }
}
