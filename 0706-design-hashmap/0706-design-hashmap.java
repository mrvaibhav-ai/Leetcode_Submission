class MyHashMap {

    private static final int INITIAL_CAPACITY = 769;
    private ListNode[] buckets;

    private static class ListNode {
        int key;
        int val;
        ListNode next;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }

    public MyHashMap() {
        buckets = new ListNode[INITIAL_CAPACITY];
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            buckets[i] = new ListNode(-1, -1); // Dummy head node
        }
    }
    
    private int getHash(int key) {
        return key % INITIAL_CAPACITY;
    }

    private ListNode find(ListNode bucket, int key) {
        ListNode prev = null;
        ListNode curr = bucket;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int hashKey = getHash(key);
        ListNode prev = find(buckets[hashKey], key);
        
        if (prev.next == null) {
            // Key doesn't exist, append new node
            prev.next = new ListNode(key, value);
        } else {
            // Key exists, update value
            prev.next.val = value;
        }
    }
    
    public int get(int key) {
        int hashKey = getHash(key);
        ListNode prev = find(buckets[hashKey], key);
        
        return prev.next == null ? -1 : prev.next.val;
    }
    
    public void remove(int key) {
        int hashKey = getHash(key);
        ListNode prev = find(buckets[hashKey], key);
        
        if (prev.next != null) {
            // Bypass the node to remove it
            prev.next = prev.next.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */