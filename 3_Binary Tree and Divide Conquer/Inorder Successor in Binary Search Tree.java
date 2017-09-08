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
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        TreeNode next = root;
        while (next != null) {
            if (next.val <= p.val) {
                next = next.right;
            } else {
                res = next;
                next = next.left;
            }
        }
        return res;
    }
    
}
