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
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    public DoublyListNode bstToDoublyList(TreeNode root) {  
        DoublyListNode sentinel = new DoublyListNode(0);
        DoublyListNode cur = sentinel;
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode temp = stack.pop();
                p = temp.right;
                DoublyListNode newNode = new DoublyListNode(temp.val);
                cur.next = newNode;
                newNode.prev = cur;
                cur = newNode;
            }
        }
        
        return sentinel.next;
    }
}
