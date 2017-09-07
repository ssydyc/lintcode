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
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        addLeftNodes(stack, root, res);
        
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            addLeftNodes(stack, cur.right, res);
        }
        return res;
    }
    
    private void addLeftNodes(
        Stack<TreeNode> stack, TreeNode root, List<Integer> res) {
        while (root != null) {
            stack.push(root);
            res.add(root.val);
            root = root.left;
        }    
    }
    
}
