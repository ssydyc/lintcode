/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param node a list node in the list
     * @param x an integer
     * @return the inserted new list node
     */
    public ListNode insert(ListNode node, int x) {
        ListNode newNode = new ListNode(x);
        if (node == null) {
            newNode.next = newNode;
            return newNode;
        }
        ListNode cur = node;
        while (true) {
            // The case we find the position.
            if (cur.val <= x && cur.next.val >= x) {
                return insertNode(cur, newNode);
            }
            // The case we get the maximum number.
            if (cur.val > cur.next.val) {
                if (cur.val <= x || cur.next.val >= x) {
                    return insertNode(cur, newNode);
                }
            }
            // The case we get to the end of List
            if (cur.next == node) {
                return insertNode(cur, newNode);
            }
            cur = cur.next;
        }
    }
    
    private ListNode insertNode(ListNode cur, ListNode newNode) {
        ListNode next = cur.next;
        cur.next = newNode;
        newNode.next = next;
        return newNode;
    }
}
