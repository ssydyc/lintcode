public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
    public int ladderLength(String start, String end, Set<String> dict) {
        if (start.length() != end.length()) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        dict.add(end);
        int level = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(end)) {
                    return level;
                }
                char[] curChar = cur.toCharArray();
                for (int j = 0; j < curChar.length; j++) {
                    char temp = curChar[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == temp) {
                            continue;
                        }
                        curChar[j] = c;
                        String next = String.valueOf(curChar);
                        if (!visited.contains(next) && dict.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    curChar[j] = temp;
                }
            }
            level++;
        }
        return 0;
    }
}
