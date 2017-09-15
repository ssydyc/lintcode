/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param head: The first node of linked list
     * @param x: An integer
     * @return: A ListNode
     */
    public ListNode partition(ListNode head, int x) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode cur = sentinel;
        ListNode prev = sentinel;
        while (cur.next != null) {
            if (cur.next.val >= x) {
                cur = cur.next;
            } else {
                ListNode swapNode = cur.next;
                cur.next = cur.next.next;
                ListNode nextNode = prev.next;
                prev.next = swapNode;
                swapNode.next = nextNode;
                prev = prev.next;
                if (cur.next == prev) {
                    cur = cur.next;
                }
            }
        }
        return sentinel.next;
    }
}
