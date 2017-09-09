/**
 * Definition for graph node.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x; neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
public class Solution {
    
    /**
     * @param graph a list of Undirected graph node
     * @param values a hash mapping, <UndirectedGraphNode, (int)value>
     * @param node an Undirected graph node
     * @param target an integer
     * @return the a node
     */
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {
        Set<UndirectedGraphNode> visited = new HashSet<>();
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        if (node == null) {
            return null;
        }
        q.offer(node);
        visited.add(node);
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                UndirectedGraphNode cur = q.poll();
                if (values.get(cur) == target) {
                    return cur;
                }
                for (UndirectedGraphNode next : cur.neighbors) {
                    if (visited.contains(next)) {
                        continue;
                    }
                    q.offer(next);
                    visited.add(next);
                }
            }
        }
        return null;
    }
    
}
