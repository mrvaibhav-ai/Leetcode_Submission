class Solution {
    public int maxDepth(Node root) {
        if (root == null)
            return 0;
        
        
        int maxx = 1;
        
        
        for (Node child : root.children)
            maxx = Math.max(maxx, 1 + maxDepth(child));
        
        
        return maxx;
    }
}