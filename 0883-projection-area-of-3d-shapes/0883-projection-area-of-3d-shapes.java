class Solution {
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int xy = 0;
        int yz = 0;
        int zx = 0;

        for (int i = 0; i < n; i++) {
            int maxRow = 0;
            int maxCol = 0;
            
            for (int j = 0; j < n; j++) {
                // Top projection: count cells with blocks
                if (grid[i][j] > 0) {
                    xy++;
                }
                
                // Track max height in the current row (zx plane)
                maxRow = Math.max(maxRow, grid[i][j]);
                
                // Track max height in the current column (yz plane)
                maxCol = Math.max(maxCol, grid[j][i]);
            }
            
            zx += maxRow;
            yz += maxCol;
        }

        return xy + yz + zx;
    }
}