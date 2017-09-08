/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class Solution {
    
    /*
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
    public int longestConsecutive2(TreeNode root) {
        return helper(root).maxWhole;
    }
    
    private ResType helper(TreeNode root) {
        if (root == null) {
            return new ResType(0, 0, 0);
        }
        int maxInc = 1;
        int maxDec = 1;
        int maxWhole = 1;
        ResType lres = helper(root.left);
        ResType rres = helper(root.right);
        
        // Handle maxInc
        if (root.left != null && root.val == root.left.val + 1) {
            maxInc = lres.maxInc + 1;
        }
        if (root.right != null && root.val == root.right.val + 1) {
            maxInc = Math.max(maxInc, rres.maxInc + 1);
        }
        
        // Handle maxDec
        if (root.left != null && root.val == root.left.val - 1) {
            maxDec = lres.maxDec + 1;
        }
        if (root.right != null && root.val == root.right.val - 1) {
            maxDec = Math.max(maxDec, rres.maxDec + 1);
        }
        
        // Handle maxWhole
        maxWhole = Math.max(maxInc, maxDec);
        if (root.left != null && root.right != null) {
            if (root.left.val + 1 == root.val 
                && root.right.val - 1 == root.val) {
                maxWhole = Math.max(maxWhole, lres.maxInc + rres.maxDec + 1);    
            }
            if (root.left.val - 1 == root.val 
                 && root.right.val + 1 == root.val) {
                maxWhole = Math.max(maxWhole, rres.maxInc + lres.maxDec + 1); 
            }
        }
        if (maxWhole < lres.maxWhole) {
            maxWhole = lres.maxWhole;
        }
        if (maxWhole < rres.maxWhole) {
            maxWhole = rres.maxWhole;
        }
        
        return new ResType(maxInc, maxDec, maxWhole);
    }
    
    private class ResType {
        
        int maxInc;
        int maxDec;
        int maxWhole;
        
        private ResType(int maxInc, int maxDec, int maxWhole) {
            this.maxInc = maxInc;
            this.maxDec = maxDec;
            this.maxWhole = maxWhole;
        }
    }
    
}
