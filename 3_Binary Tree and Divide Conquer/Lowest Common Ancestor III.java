/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    
    /**
     * @param root The root of the binary tree.
     * @param A and B two nodes
     * @return: Return the LCA of the two nodes.
     */
    public TreeNode lowestCommonAncestor3(
        TreeNode root, TreeNode A, TreeNode B) {
        return helper(root, A, B).res;
    }
    
    private ResType helper(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return new ResType(0, null);
        }
        int numAbContained = 0;
        ResType leftRes = helper(root.left, A, B);
        ResType rightRes = helper(root.right, A, B);
        if (leftRes.res != null) {
            return new ResType(2, leftRes.res);
        }
        if (rightRes.res != null) {
            return new ResType(2, rightRes.res);
        }
        numAbContained += leftRes.numAbContained + rightRes.numAbContained;
        if (root == A) {
            numAbContained++;
        }
        if (root == B) {
            numAbContained++;
        }
        if (numAbContained == 2) {
            return new ResType(2, root);
        } else {
            return new ResType(numAbContained, null);
        }
    }
    
    private class ResType {
        
        private int numAbContained;
        private TreeNode res;
        
        private ResType(int numAbContained, TreeNode res) {
            this.numAbContained = numAbContained;
            this.res = res;
        }
    }
    
}
