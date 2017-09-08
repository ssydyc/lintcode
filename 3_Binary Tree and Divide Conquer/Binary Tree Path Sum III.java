/**
 * Definition of ParentTreeNode:
 * 
 * class ParentTreeNode {
 *     public int val;
 *     public ParentTreeNode parent, left, right;
 * }
 */
public class Solution {
    
    /**
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum3(
        ParentTreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        iterTree(root, target, res);
        return res;
    }
    
    private void iterTree(
        ParentTreeNode root, int target, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        DFS(root, target, res, new ArrayList<Integer>(), 0, null);
        iterTree(root.left, target, res);
        iterTree(root.right, target, res);
    }
    
    private void DFS(ParentTreeNode root, int target, List<List<Integer>> res,
        List<Integer> cur, int curSum, ParentTreeNode prev) {
        if (root == null) {
            return;
        }
        
        cur.add(root.val);
        curSum += root.val;
        if (curSum == target) {
            res.add(new ArrayList<Integer>(cur));
        }
        if (root.left != null && root.left != prev) {
            DFS(root.left, target, res, cur, curSum, root);
        }
        if (root.right != null && root.right != prev) {
            DFS(root.right, target, res, cur, curSum, root);
        }
        if (root.parent != null && root.parent != prev) {
            DFS(root.parent, target, res, cur, curSum, root);
        }
        cur.remove(cur.size() - 1);
    }
    
}
