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
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root).isBst;
    }
    
    private ResType helper(TreeNode root) {
        if (root == null) {
            return new ResType(true, null, null);
        }
        ResType leftRes = helper(root.left);
        ResType rightRes = helper(root.right);
        if (!leftRes.isBst || !rightRes.isBst) {
            return new ResType(false, 0, 0);
        }
        if ((leftRes.max != null && root.val <= leftRes.max)
                || (rightRes.min != null && root.val >= rightRes.min)) {
            return new ResType(false, 0, 0);
        }
        
        int min = 
            leftRes.min == null ? root.val : Math.min(root.val, leftRes.min);
        int max =  
            rightRes.max == null ? root.val : Math.max(root.val, rightRes.max);
        return new ResType(true, min, max);
    }
    
    private class ResType {
        
        private boolean isBst;
        private Integer min;
        private Integer max;
        
        private ResType (boolean isBst, Integer min, Integer max) {
            this.isBst = isBst;
            this.min = min;
            this.max = max;
        }
        
    }
    
}
