public class Solution {
    /*
     * @param source: A source string
     * @param target: A target string
     * @return: An integer as index
     */
    public int strStr2(String source, String target) {
        if (source == null || target == null 
            || target.length() > source.length()) {
            return -1;
        }
        if (target.length() == 0) {
            return 0;
        }
        int[] nextIndex = createIndexTable(target);
        int matched = 0;
        for (int i = 0; i < source.length(); i++) {
            while (matched != 0 && source.charAt(i) != target.charAt(matched)) {
                matched = nextIndex[matched - 1] + 1;
            }
            if (source.charAt(i) == target.charAt(matched)) {
                matched++;
                if (matched == target.length()) {
                    return i - target.length() + 1;
                }
            }
        }
        return -1;
    }
    
    private int[] createIndexTable(String s) {
        int n = s.length();
        int[] res = new int[n];
        res[0] = -1;
        for (int i = 1; i < n; i++) {
            int prev = res[i - 1];
            while (prev != -1 && s.charAt(prev + 1) != s.charAt(i)) {
                prev = res[prev];
            }
            if (s.charAt(i) != s.charAt(prev + 1)) {
                res[i] = -1;
            } else {
                res[i] = prev + 1;
            }
        }
        return res;
    }
}
