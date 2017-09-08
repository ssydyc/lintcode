/**
 * Definition for a multi tree node.
 * public class MultiTreeNode {
 *     int val;
 *     List<TreeNode> children;
 *     MultiTreeNode(int x) { val = x; }
 * }
 */
public class Solution {

    /**
     * @param root the root of k-ary tree
     * @return the length of the longest consecutive sequence path
     */
    public int longestConsecutive3(MultiTreeNode root) {
        return helper(root).maxWhole;
    }
    
    private ResType helper(MultiTreeNode root) {
        if (root == null) {
            return new ResType(0, 0, 0);
        }
        int maxInc = 1;
        int maxDec = 1;
        int maxWhole = 1; 
        
        // Handle maxInc and maxDec and maxWhole.
        for (MultiTreeNode node : root.children) {
            ResType res = helper(node);
            maxWhole = Math.max(maxWhole, res.maxWhole);
            if (node.val + 1 == root.val) {
                maxInc = Math.max(maxInc, res.maxInc + 1);
            }
            if (node.val - 1 == root.val) {
                maxDec = Math.max(maxDec, res.maxDec + 1);
            }
        }
        maxWhole = Math.max(maxWhole, maxInc + maxDec - 1);
        
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
