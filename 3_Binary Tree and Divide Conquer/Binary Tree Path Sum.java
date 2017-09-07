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
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int sum = 0;
        List<Integer> cur = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(root, target, res, cur, sum);
        return res;
    }
    
    private void helper(TreeNode root, int target, 
        List<List<Integer>> res, List<Integer> cur, int sum) {
        if (root.left == null && root.right == null) {
            if (sum + root.val == target) {
                cur.add(root.val);
                res.add(new ArrayList<Integer>(cur));
                cur.remove(cur.size() - 1);
            }
            return;
        }
        cur.add(root.val);
        if (root.left != null) {
            helper(root.left, target, res, cur, sum + root.val);
        }
        if (root.right != null) {
            helper(root.right, target, res, cur, sum + root.val);
        }
        cur.remove(cur.size() - 1);
    }
    
}
