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
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        if (hashTable == null || hashTable.length == 0) {
            return new ListNode[0];
        }
        int n = hashTable.length;
        ListNode[] res = new ListNode[2 * n];
        Arrays.fill(res, null);
        
        for (ListNode node : hashTable) {
            if (node == null) {
                continue;
            }
            while (node != null) {
                addNode(res, node);
                node = node.next;
            }
        }
        return res;
    }
    
    private void addNode(ListNode[] res, ListNode node) {
        int n = res.length;
        int ind = (node.val % n + n) % n;
        if (res[ind] == null) {
            res[ind] = new ListNode(node.val);
        } else {
            ListNode sentinel = new ListNode(0);
            sentinel.next = res[ind];
            ListNode cur = sentinel;
            while (cur.next != null) {
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = new ListNode(node.val);
            cur.next.next = next;
            res[ind] = sentinel.next;
        }
    }
}
