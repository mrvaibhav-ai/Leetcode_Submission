class Solution {
    public int surfaceArea(int[][] grid) {
        int n = grid.length;
        int totalArea = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int v = grid[i][j];
                if (v > 0) {
                    // Add top and bottom faces, plus 4 faces for each cube in the column
                    totalArea += (v * 4) + 2;
                    
                    // Subtract overlapping faces with adjacent cells
                    // Check Up neighbor
                    if (i > 0) {
                        totalArea -= Math.min(v, grid[i - 1][j]);
                    }
                    // Check Down neighbor
                    if (i < n - 1) {
                        totalArea -= Math.min(v, grid[i + 1][j]);
                    }
                    // Check Left neighbor
                    if (j > 0) {
                        totalArea -= Math.min(v, grid[i][j - 1]);
                    }
                    // Check Right neighbor
                    if (j < n - 1) {
                        totalArea -= Math.min(v, grid[i][j + 1]);
                    }
                }
            }
        }
        
        return totalArea;
    }
}