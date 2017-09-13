public class Solution {
    /**
     * @param s a string
     * @return an integer
     */
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        boolean[][] isPalindrome = palindromeMatrix(s);
        int[] res = new int[n + 1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (isPalindrome[i][j - 1]) {
                    res[j] = Math.min(res[j], res[i] + 1);
                }
            }
        }
        return res[n];
    }
    
    private boolean[][] palindromeMatrix(String s) {
        int n = s.length();
        boolean[][] res = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            setPalindrome(i, i, res, s);
            setPalindrome(i, i + 1, res, s);
        }
        return res;
    }
    
    private void setPalindrome(int start, int end, boolean[][] res, String s) {
        int n = res.length;
        while (start >= 0 && end < n) {
            if (s.charAt(start) == s.charAt(end)) {
                res[start--][end++] = true;
            } else {
                break;
            }
        }
    }
}
