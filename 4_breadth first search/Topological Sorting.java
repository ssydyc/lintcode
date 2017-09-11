/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(
        ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> res = new ArrayList<>();
        if (graph == null || graph.size() == 0) {
            return res;
        }
        Map<DirectedGraphNode, Integer> incoming = new HashMap<>();
        Stack<DirectedGraphNode> noIncoming = new Stack<>();
        
        
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode next : node.neighbors) {
                if (!incoming.containsKey(node)) {
                    incoming.put(node, 0);
                }
                if (!incoming.containsKey(next)) {
                    incoming.put(next, 0);
                }
                incoming.put(next, incoming.get(next) + 1);
            }
        }
        
        for (DirectedGraphNode node : incoming.keySet()) {
            if (incoming.get(node) == 0) {
                noIncoming.push(node);
            }
        }
        
        while (!noIncoming.isEmpty()) {
            DirectedGraphNode cur = noIncoming.pop();
            res.add(cur);
            for (DirectedGraphNode next : cur.neighbors) {
                incoming.put(next, incoming.get(next) - 1);
                if (incoming.get(next) == 0) {
                    noIncoming.push(next);
                }
            }
        }
        return res;
    }
    
}
