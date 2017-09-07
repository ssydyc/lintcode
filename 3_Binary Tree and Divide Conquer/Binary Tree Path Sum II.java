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
     * @param target: An integer
     * @return: all valid paths
     */
    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(root, target, res, cur);
        return res;
    }
    
    private void helper(
        TreeNode root, int target, List<List<Integer>> res, List<Integer> cur) {
        if (root == null) {
            return;
        }
        
        int sum = 0;
        cur.add(root.val);
        for (int i = cur.size() - 1; i >= 0; i--) {
            sum += cur.get(i);
            if (sum == target) {
                addPath(i, cur, res);
            }
        }
        helper(root.left, target, res, cur);
        helper(root.right, target, res, cur);
        cur.remove(cur.size() - 1);
    }
    
    private void addPath(
        int start, List<Integer> cur, List<List<Integer>> res) {
        List<Integer> toAdd = new ArrayList<>();
        for (int i = start; i < cur.size(); i++) {
            toAdd.add(cur.get(i));
        }
        res.add(toAdd);
    }
    
}
