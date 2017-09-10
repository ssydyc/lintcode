public class Solution {
    
    /**
     * @param s a string
     * @param dict a set of n substrings
     * @return the minimum length
     */
    public int minLength(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = s.length();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            res = Math.min(res, cur.length());
            for (String sub : dict) {
                int find = -1;
                while (true) {
                    find = cur.indexOf(sub, find + 1);
                    if (find == -1) {
                        break;
                    }
                    String next = cur.substring(0, find) 
                        + cur.substring(find + sub.length());
                    if (!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
        }
        return res;
    }
    
}
