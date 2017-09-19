public class Solution {
    /*
     * @param A: A list of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        res[0] = 0;
        
        for (int i = 0; i < n; i++) {
            if (res[i] == -1) {
                continue;
            }
            int end = i + A[i];
            for (int j = i + 1; j <= end && j < n; j++) {
                if (res[j] == -1) {
                    res[j] = res[i] + 1;
                } else {
                    res[j] = Math.min(res[i] + 1, res[j]);
                }
            }
        }
        return res[n - 1];
    }
}
