public class LFUCache {

    private SortedMap<Integer, List<ListNode>> freqList;
    private Map<Integer, ListNode> data;
    private int capacity;
    private int size;

    // @param capacity, an integer
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.freqList = new TreeMap<>();
        this.data = new HashMap<>();
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        if (!data.containsKey(key)) {
            ListNode newNode = new ListNode(key, value, 1);
            if (size == capacity) {
                removeListNode(getFirstNode());
                addListNode(newNode);
            } else {
                size++;
                addListNode(newNode);
            }
        } else {
            ListNode node = data.get(key);
            node.value = value;
            removeListNode(node);
            node.freq++;
            addListNode(node);
        } 
    }

    public int get(int key) {
        if (!data.containsKey(key)) {
            return -1;
        }
        ListNode node = data.get(key);
        set(key, node.value);
        return node.value;
    }
    
    private ListNode getFirstNode() {
        int firstKey = freqList.firstKey();
        return freqList.get(firstKey).get(0).next;
    }
    
    private void addListNode(ListNode newNode) {
        data.put(newNode.key, newNode);
        int freq = newNode.freq;
        if (!freqList.containsKey(freq)) {
            freqList.put(freq, getHeadTail());
        }
        ListNode tail = freqList.get(freq).get(1);
        tail.prev.next = newNode;
        newNode.prev = tail.prev;
        tail.prev = newNode;
        newNode.next = tail;
    }
    
    private void removeListNode(ListNode node) {
        data.remove(node.key);
        int freq = node.freq;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        // Check wether current freq has no element
        if (freqList.get(freq).get(0).next == freqList.get(freq).get(1)) {
            freqList.remove(freq);
        }
    }
    
    private List<ListNode> getHeadTail() {
        ListNode head = new ListNode(-1, -1, -1);
        ListNode tail = new ListNode(-1, -1, -1);
        head.next = tail;
        tail.prev = head;
        List<ListNode> res = new ArrayList<>();
        res.add(head);
        res.add(tail);
        return res;
    }
    
    private class ListNode {
        
        private int key;
        private int freq;
        private int value;
        private ListNode prev;
        private ListNode next;
        
        private ListNode(int key, int value, int freq) {
            this.key = key;
            this.value = value;
            this.freq = freq;
            this.prev = null;
            this.next = null;
        }
        
    }
    
}
