public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return a list of lists of string
      */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here
        List<List<String>> results = new ArrayList<>();
        List<String> result = new ArrayList<>();
        Map<String, Integer> distance = new HashMap<>();
        if (start == null || end == null) {
            return results;
        }
        bfs(start, end, dict, distance);
        dfs(start, end, results, result, distance);
        return results;
    }
    private void dfs(String crt, String end, List<List<String>> results, List<String> result, Map<String, Integer> distance) {
        result.add(crt);
        if (crt.equals(end)) {
            results.add(new ArrayList<String>(result));
            //此处不能直接return，必须要删掉result.remove(result.size() - 1);
        }
        for (int i = 0; i < crt.length(); i++) {
            StringBuilder sb = new StringBuilder(crt);
            for (char c = 'a'; c <= 'z'; c++) {
                sb.setCharAt(i, c);
                String st = sb.toString();
                if (distance.containsKey(st) && distance.get(st) == distance.get(crt) - 1) {
                    dfs(st, end, results, result, distance);
                }
            }
        }
        result.remove(result.size() - 1);
    }
    private void bfs(String start, String end, Set<String> dict, Map<String, Integer> distance) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(end);
        distance.put(end, 0);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int j = 0; j < size; j++) {
                String crt = queue.poll();
                for (int i = 0; i < crt.length(); i++) {
                    StringBuilder sb = new StringBuilder(crt);
                    for (char c = 'a'; c <= 'z'; c++) {
                        sb.setCharAt(i, c);
                        String st = sb.toString();
                        if (st.equals(start)) {
                            distance.put(st, level);
                            return;
                        }
                        if (dict.contains(st) && !distance.containsKey(st)) {
                            queue.offer(st);
                            distance.put(st, level);
                        }
                    }
                }
            }
        }
    }
}
