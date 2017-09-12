public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        boolean[][] isPalindrome = getPalindrome(s);
        helper(0, cur, res, isPalindrome, s);
        return res;
    }
    
    private void helper(int start, List<String> cur, List<List<String>> res,
        boolean[][] isPalindrome, String s) {
        int n = s.length();
        if (start >= n) {
            res.add(new ArrayList<String>(cur));
            return;
        }
        for (int end = start; end < n; end++) {
            if (isPalindrome[start][end]) {
                cur.add(s.substring(start, end + 1));
                helper(end + 1, cur, res, isPalindrome, s);
                cur.remove(cur.size() - 1);
            }
        }    
    }
    
    private boolean[][] getPalindrome(String s) {
        int n = s.length();
        boolean[][] res = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            setPanlidrone(res, i, i, s);
            setPanlidrone(res, i, i + 1, s);
        }
        return res;
    }
    
    private void setPanlidrone(boolean[][] res, int left, int right, String s) {
        int n = res.length;
        while (left >= 0 && right < n) {
            if (s.charAt(left) == s.charAt(right)) {
                res[left--][right++] = true;
            } else {
                break;
            }
        }
    }
}
