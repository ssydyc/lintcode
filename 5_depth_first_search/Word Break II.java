public class Solution {
    /*
     * @param s: A string
     * @param wordDict: A set of words.
     * @return: All possible sentences.
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {
        Map<Integer, List<String>> memo = new HashMap<>();
        if (s == null || s.length() == 0) {
            return new ArrayList<String>();
        }
        return helper(s, 0, wordDict, memo);
    }
    
    private List<String> helper(String s, int start, Set<String> wordDict, 
        Map<Integer, List<String>> memo) {
            if (memo.containsKey(start)) {
                return memo.get(start);
            }
            List<String> res = new ArrayList<>();
            for (int i = start + 1; i <= s.length(); i++) {
                String cur = s.substring(start, i);
                if (wordDict.contains(cur)) {
                    if (i == s.length()) {
                        res.add(cur);
                        continue;
                    }
                    for (String word : helper(s, i, wordDict, memo)) {
                        res.add(cur + " " + word);
                    }
                }
            }
            memo.put(start, res);
            return res;
        }
}
