/**
 * Definition of ParentTreeNode:
 * 
 * class ParentTreeNode {
 *     public ParentTreeNode parent, left, right;
 * }
 */
public class Solution {

    /**
     * @param root: The root of the tree
     * @param A, B: Two node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                 ParentTreeNode A,
                                                 ParentTreeNode B) {
        if (root == null) {
            return null;
        }
        List<ParentTreeNode> pathToA = new ArrayList<>();
        List<ParentTreeNode> pathToB = new ArrayList<>();
        addPath(pathToA, A);
        addPath(pathToB, B);
        for (int i = 0; i < pathToA.size() && i < pathToB.size(); i++) {
            if (pathToA.get(pathToA.size() - 1 - i) 
                != pathToB.get(pathToB.size() - 1 - i)) {
                return pathToA.get(pathToA.size() - i);
            }
        }
        if (pathToA.size() < pathToB.size()) {
            return pathToA.get(0);
        } else {
            return pathToB.get(0);
        }
    }
    
    private void addPath(List<ParentTreeNode> path, ParentTreeNode node) {
        while (node != null) {
            path.add(node);
            node = node.parent;
        }
    }
    
}
