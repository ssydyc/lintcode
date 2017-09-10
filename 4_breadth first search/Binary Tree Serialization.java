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
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "{}";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder res = new StringBuilder();
        res.append('{');
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                res.append("#,");
            } else {
                res.append(String.valueOf(cur.val) + ",");
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        res.deleteCharAt(res.length() - 1);
        res.append('}');
        return res.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 2) {
            return null;
        }
        String[] nums = data.substring(1, data.length() - 1).split(",");
        int curIndex = 0;
        List<TreeNode> preNodes = new ArrayList<>();
        
        TreeNode root = new TreeNode(Integer.parseInt(nums[0]));
        preNodes.add(root);
        for (int i = 1; i < nums.length; i++) {
            TreeNode cur;
            if (nums[i].equals("#")) {
                cur = null;
            } else {
                cur = new TreeNode(Integer.parseInt(nums[i]));
                preNodes.add(cur);
            }
            if (i % 2 == 1) {
                preNodes.get(curIndex).left = cur;
            } else {
                preNodes.get(curIndex++).right = cur;
            }
        }
        return root;
    }
    
}
