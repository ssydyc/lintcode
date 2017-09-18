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
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        if (lists == null || lists.size() == 0) {
            return null;
        }
        int k = lists.size();
        Queue<ListNode> heap = new PriorityQueue<>(k + 1, 
            new Comparator<ListNode>(){
            @Override
            public int compare(ListNode node1, ListNode node2) {
                return node1.val - node2.val;
            }
        });
        for (ListNode node : lists) {
            if (node != null) {
                heap.offer(node);
            }
        }
        
        ListNode sentinel = new ListNode(0);
        ListNode cur = sentinel;
        while (!heap.isEmpty()) {
            ListNode toAdd = heap.poll();
            if (toAdd.next != null) {
                heap.offer(toAdd.next);
            }
            cur.next = toAdd;
            cur = cur.next;
        }
        return sentinel.next;
    }
}
