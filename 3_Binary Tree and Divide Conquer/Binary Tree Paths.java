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
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        if (root == null) {
            return res;
        }
        DFS(res, cur, root);
        return res;
    }
    
    private void DFS(List<String> res, StringBuilder cur, TreeNode root) {
        String num = Integer.toString(root.val);
        if (root.left == null && root.right == null) {
            cur.append(num);
            res.add(cur.toString());
            cur.delete(cur.length() - num.length(), cur.length());
            return;
        }
        if (root.left != null) {
            cur.append(num);
            cur.append("->");
            DFS(res, cur, root.left);
            cur.delete(cur.length() - num.length() - 2, cur.length());
        }
        if (root.right != null) {
            cur.append(num);
            cur.append("->");
            DFS(res, cur, root.right);
            cur.delete(cur.length() - num.length() - 2, cur.length());
        }
    } 
    
}
