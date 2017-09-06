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
     * @param root: the root of binary tree
     * @return: the root of the minimum sum of tree
     */
    public TreeNode findSubtree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        return helper(root).res;
    }
    
    private ResNode helper(TreeNode root) {
        int minSum = Integer.MAX_VALUE;
        int sum = root.val;
        TreeNode res = null;
        
        if (root.left != null) {
            ResNode leftRes = helper(root.left);
            sum += leftRes.sum;
            if (leftRes.minSum < minSum) {
                minSum = leftRes.minSum;
                res = leftRes.res;
            }
        } 
        if (root.right != null) {
            ResNode rightRes = helper(root.right);
            sum += rightRes.sum;
            if (rightRes.minSum < minSum) {
                minSum = rightRes.minSum;
                res = rightRes.res;
            }
        }
        if (sum < minSum) {
            minSum = sum;
            res = root;
        }
        return new ResNode(sum, minSum, res);
    }
    
    private class ResNode {
        
        private int sum;
        private int minSum;
        private TreeNode res;
        
        private ResNode(int sum, int minSum, TreeNode res) {
            this.sum = sum;
            this.res = res;
            this.minSum = minSum;
        }
        
    }
    
}
