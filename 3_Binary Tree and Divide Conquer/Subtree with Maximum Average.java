
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
     * @return: the root of the maximum average of subtree
     */
    public TreeNode findSubtree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        return helper(root).res;
    }
    
    private ResNode helper(TreeNode root) {
        int size = 1;
        double sum = (double) root.val;
        double avg = sum;
        TreeNode res = null;
        
        if (root.left != null) {
            ResNode leftRes = helper(root.left);
            size += leftRes.size;
            sum += leftRes.avg * leftRes.size;
            avg = leftRes.avg;
            res = leftRes.res;
        } 
        if (root.right != null) {
            ResNode rightRes = helper(root.right);
            size += rightRes.size;
            sum += rightRes.avg * rightRes.size;
            if (avg < rightRes.avg) {
                avg = rightRes.avg;
                res = rightRes.res;
            }
        }
        if (avg <= sum / size) {
            avg = sum / size;
            res = root;
        }
        return new ResNode(avg, size, res);
    }
    
    private class ResNode {
        
        private double avg;
        private int size;
        private TreeNode res;
        
        private ResNode(double avg, int size, TreeNode res) {
            this.avg = avg;
            this.size = size;
            this.res = res;
        }
        
    }
    
}
