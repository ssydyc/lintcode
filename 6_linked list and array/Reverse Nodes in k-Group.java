/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


public class Solution {
    /*
     * @param head: a ListNode
     * @param k: An integer
     * @return: a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }
        
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode prevKEnd = sentinel;
        ListNode curKHead = head;
        ListNode cur = sentinel;
        int index = 0;
        while (cur.next != null) {
            cur = cur.next;
            if (++index != k) {
                continue;
            }
            index = 0;
            ListNode nextKHead = cur.next;
            reverse(curKHead, k);
            prevKEnd.next = cur;
            curKHead.next = nextKHead;
            prevKEnd = curKHead;
            curKHead = nextKHead;
            cur = prevKEnd;
        }
        return sentinel.next;
    }
    
    private void reverse(ListNode head, int k) {
        ListNode prev = null;
        for (int i = 0; i < k; i++) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
    }
}
