public class Solution {
    /*
     * @param str: A string
     * @return: all permutations
     */
    public List<String> stringPermutation2(String str) {
        if (str == null) {
            return new ArrayList<String>();
        }
        char[] cur = str.toCharArray();
        Arrays.sort(cur);
        List<String> res = new ArrayList<>();
        helper(res, 0, cur);
        Collections.sort(res);
        return res;
    }
    
    private void helper(List<String> res, int start, char[] cur) {
        int n = cur.length;
        if (start == n) {
            res.add(String.valueOf(cur));
            return;
        }
        Set<Character> visited = new HashSet<>();
        for (int i = start; i < n; i++) {
            if (!visited.contains(cur[i])) {
                swap(cur, start, i);
                helper(res, start + 1, cur);
                swap(cur, start, i);
                visited.add(cur[i]);
            }
        }
    }
    
    private void swap(char[] cur, int i, int j) {
        char temp = cur[i];
        cur[i] = cur[j];
        cur[j] = temp;
    }
}
