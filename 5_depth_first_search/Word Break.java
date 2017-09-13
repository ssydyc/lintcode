public class Solution {
    /*
     * @param s: A string
     * @param dict: A dictionary of words dict
     * @return: A boolean
     */
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int n = s.length();
        boolean[] res = new boolean[n + 1];
        res[0] = true;
        int maxLength = 0;
        for (String word : dict) {
            if (word.length() > maxLength) {
                maxLength = word.length();
            }
        }
        for (int i = 0; i < n; i++) {
            if (!res[i]) {
                continue;
            }
            for (int j = i + 1; j <= n && j - i <= maxLength; j++) {
                if (res[j]) {
                    continue;
                }
                if (dict.contains(s.substring(i, j))) {
                    res[j] = true;
                }
            }
        }
        return res[n];
    }
}
