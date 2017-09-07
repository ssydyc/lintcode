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
    
    private int opt = 0;
    
    /*
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
    public int longestConsecutive(TreeNode root) {
        helper(root);
        return opt;
    }
    
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftRes = helper(root.left);
        int rightRes = helper(root.right);
        if (root.right == null 
            || (root.right != null && root.val + 1 == root.right.val)) {
            rightRes++;
            if (opt < rightRes) {
                opt = rightRes;
            }
        } else {
            rightRes = 1;
        }
        if (root.left == null 
            || (root.left != null && root.val + 1 == root.left.val)) {
            leftRes++;
            if (opt < leftRes) {
                opt = leftRes;
            }
        } else {
            leftRes = 1;
        }
        return Math.max(leftRes, rightRes);
    }
    
}
