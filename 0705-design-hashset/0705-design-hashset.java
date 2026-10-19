class MyHashSet {
    
    private static final int BUCKET_SIZE = 769; // A prime number to reduce collisions
    private LinkedList<Integer>[] buckets;

    @SuppressWarnings("unchecked")
    public MyHashSet() {
        buckets = new LinkedList[BUCKET_SIZE];
        for (int i = 0; i < BUCKET_SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }
    
    private int hash(int key) {
        return key % BUCKET_SIZE;
    }
    
    public void add(int key) {
        int index = hash(key);
        LinkedList<Integer> bucket = buckets[index];
        if (!bucket.contains(key)) {
            bucket.add(key);
        }
    }
    
    public void remove(int key) {
        int index = hash(key);
        LinkedList<Integer> bucket = buckets[index];
        bucket.remove(Integer.valueOf(key)); // Ensure object removal, not index-based
    }
    
    public boolean contains(int key) {
        int index = hash(key);
        LinkedList<Integer> bucket = buckets[index];
        return bucket.contains(key);
    }
}