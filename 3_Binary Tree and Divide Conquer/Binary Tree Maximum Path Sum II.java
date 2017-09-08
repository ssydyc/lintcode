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
    
    /*
     * @param root: the root of binary tree.
     * @return: An integer
     */
    public int maxPathSum2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int res = root.val;
        int maxLeftRight = Math.max(
            maxPathSum2(root.left), maxPathSum2(root.right));
        if (maxLeftRight > 0) {
            res += maxLeftRight;
        }
        return res;
    }
    
}
