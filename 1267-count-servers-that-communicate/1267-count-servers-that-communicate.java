class UFDS{
    int n; int parent[]; int size[];
    public UFDS(int n){
        this.n = n;
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 0;
        }
    }

    public int find(int x){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    public void merge(int x, int y){
        int leaderX = find(x); int leaderY = find(y);
        if(leaderX == leaderY) return;
        parent[leaderY] = leaderX;
        size[leaderX] += size[leaderY];
    }
}

class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length; int n = grid[0].length;
        UFDS graph = new UFDS(m + n + 2);

        int servers = 0;
        for(int i = 0; i < m; i++){
            for(int j= 0; j < n; j++){
                if(grid[i][j] == 1){
                    int row = i; int col = m + j + 1;
                    int leader = graph.find(row); 
                    graph.size[leader]++; // Add size only to rows
                    graph.merge(row, col);
                    servers++;
                }
            }
        }

        int isolated = 0;
        for(int i = 0; i < m; i++){
            // Traverse through rows and check if they are isolated
            int leader = graph.find(i);
            if(graph.size[leader] == 1) isolated++;
        }

        return servers - isolated;
    }
}