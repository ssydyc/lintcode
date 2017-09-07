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
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        return helper(root).isBalanced;
    }
    
    private ResType helper(TreeNode root) {
        if (root == null) {
            return new ResType(0, true);
        }
        
        ResType leftRes = helper(root.left);
        ResType rightRes = helper(root.right);
        boolean isBalanced  = leftRes.isBalanced && rightRes.isBalanced 
            && (Math.abs(leftRes.height - rightRes.height) <= 1);
        return new ResType(
            Math.max(leftRes.height, rightRes.height) + 1, isBalanced);
    }
    
    private class ResType {
        
        private int height;
        private boolean isBalanced;
        
        private ResType(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }
    
}
