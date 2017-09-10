/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Map<Integer, UndirectedGraphNode> nodes = new HashMap<>();
        bfs(node, nodes, false);
        return bfs(node, nodes, true);
    }
    
    private UndirectedGraphNode bfs(UndirectedGraphNode node, 
        Map<Integer, UndirectedGraphNode> nodes, boolean addEdge) {
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        Set<UndirectedGraphNode> visited = new HashSet<>();
        
        q.offer(node);
        visited.add(node);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                UndirectedGraphNode cur = q.poll();
                if (!addEdge) {
                    nodes.put(cur.label, new UndirectedGraphNode(cur.label));
                }
                for (UndirectedGraphNode nextNode : cur.neighbors) {
                    if (addEdge) {
                        nodes.get(cur.label).neighbors
                            .add(nodes.get(nextNode.label));
                    }
                    if (visited.contains(nextNode)) {
                        continue;
                    }
                    visited.add(nextNode);
                    q.offer(nextNode);
                }
            }
        }
        return nodes.get(node.label);
    }
    
}
