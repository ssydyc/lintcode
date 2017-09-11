/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(
        ArrayList<UndirectedGraphNode> nodes) {
        List<List<Integer>> res = new ArrayList<>();
        if (nodes == null || nodes.size() == 0) {
            return res;
        }
        Set<UndirectedGraphNode> visited = new HashSet<>();
        for (UndirectedGraphNode node : nodes) {
            if (!visited.contains(node)) {
                res.add(bfs(node, visited));
            }
        }
        return res;
    }
    
    private List<Integer> bfs(UndirectedGraphNode node,
        Set<UndirectedGraphNode> visited) {
        List<Integer> res = new ArrayList<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        visited.add(node);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            res.add(cur.label);
            for (UndirectedGraphNode next : cur.neighbors) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.offer(next);
                }
            }
        }
        Collections.sort(res);
        return res;
    }
    
}
