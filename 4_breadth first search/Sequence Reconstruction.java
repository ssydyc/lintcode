public class Solution {
    
    /*
     * @param org: a permutation of the integers from 1 to n
     * @param seqs: a list of sequences
     * @return: true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        if (seqs == null || seqs.length == 0) {
            if (org.length == 0) {
                return true;
            } else {
                return false;
            }
        }
        List<Integer> res = new ArrayList<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> incoming = new HashMap<>();
        Stack<Integer> noIncoming = new Stack<>();
        
        // Create graph.
        for (int i = 0; i < seqs.length; i++) {
            if (seqs[i].length == 1) {
                if (!graph.containsKey(seqs[i][0])) {
                    graph.put(seqs[i][0], new ArrayList<Integer>());
                }
                if (!incoming.containsKey(seqs[i][0])) {
                    incoming.put(seqs[i][0], 0);   
                }
                continue;
            }
            for (int j = 0; j < seqs[i].length - 1; j++) {
                if (!graph.containsKey(seqs[i][j])) {
                    graph.put(seqs[i][j], new ArrayList<Integer>());
                }
                if (!graph.containsKey(seqs[i][j + 1])) {
                    graph.put(seqs[i][j + 1], new ArrayList<Integer>());
                }
                if (!incoming.containsKey(seqs[i][j])) {
                    incoming.put(seqs[i][j], 0);   
                }
                if (!incoming.containsKey(seqs[i][j + 1])) {
                    incoming.put(seqs[i][j + 1], 0);   
                }
                incoming.put(seqs[i][j + 1], incoming.get(seqs[i][j + 1]) + 1);
                graph.get(seqs[i][j]).add(seqs[i][j + 1]);
            }
        }
        
        // Count number of incoming edges.
        for (int key : incoming.keySet()) {
            if (incoming.get(key) == 0) {
                noIncoming.push(key);
            }
        }
        
        // Topological sort and get result.
        while (!noIncoming.isEmpty()) {
            if (noIncoming.size() > 1) {
                return false;
            }
            int cur = noIncoming.pop();
            res.add(cur);
            for (int next : graph.get(cur)) {
                incoming.put(next, incoming.get(next) - 1);
                if (incoming.get(next) == 0) {
                    noIncoming.push(next);
                }
            }
        }
        
        if (res.size() != org.length) {
            return false;
        }
        for (int i = 0; i < org.length; i++) {
            if (res.get(i) != org[i]) {
                return false;
            }
        }
        return true;
    }
    
}
