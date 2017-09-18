public class LRUCache {
    
    int size = 0;
    int capacity;
    Map<Integer, ListNode> data;
    ListNode head;
    ListNode tail;
    
    public LRUCache(int capacity) {
        this.data = new HashMap<>();
        this.capacity = capacity;
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    // @return an integer
    public int get(int key) {
        if (!data.containsKey(key)) {
            return -1;
        }
        ListNode res = data.get(key);
        remove(key, res);
        addToTail(key, res);
        return res.value;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        ListNode node = new ListNode(key, value);
        if (!data.containsKey(key)) {
            addToTail(key, node);
            size++;
        } else {
            node = data.get(key);
            node.value = value;
            remove(key, node);
            addToTail(key, node);
        }
        if (size > capacity) {
            remove(head.next.key, head.next);
            size--;
        }
    }
    
    private void remove(int key, ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        data.remove(key);
    }
    
    private void addToTail(int key, ListNode node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        tail.prev = node;
        node.next = tail;
        data.put(key, node);
    }
    
    private class ListNode {
        private ListNode next;
        private ListNode prev;
        private int value;
        private int key;
        
        ListNode(int key, int value) {
            this.value = value;
            this.key = key;
            this.next = null;
            this.prev = null;
        } 
    }
}
