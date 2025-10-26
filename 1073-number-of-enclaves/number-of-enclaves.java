class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] dirs = new int[]{0,1,0,-1,0};

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i == 0 || j == 0 || i== n-1 || j == m-1){
                    if(grid[i][j] == 1){
                        dfs(grid,dirs,i,j);
                    }
                }
            }
        }

        int enclaves = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1) enclaves++;
            }
        }

        return enclaves;
    }

    private void dfs(int[][] grid,int[] dirs,int curri,int currj){
        if(curri < 0 || currj < 0 || curri >= grid.length || currj >= grid[0].length) return;
        else if(grid[curri][currj] == 0) return;

        grid[curri][currj] = 0;

        for(int k = 0;k < 4;k++){
            int nexti = curri + dirs[k];
            int nextj = currj + dirs[k+1];

            dfs(grid,dirs,nexti,nextj);
        }
    }

    private void bfs(int[][] grid,int[] dirs,int curri,int currj){
        Queue<int[]> q = new LinkedList<>();
        int[] curr = new int[]{curri,currj};
        q.add(curr);
        grid[curri][currj] = 0;

        while(!q.isEmpty()){
            curr = q.remove();
            curri = curr[0];
            currj = curr[1];

            for(int k = 0;k < 4;k++){
                int nexti = curri + dirs[k];
                int nextj = currj + dirs[k+1];

                if(nexti < 0 || nextj < 0 || nexti >= grid.length || nextj >= grid[0].length) continue;
                if(grid[nexti][nextj] == 0) continue;

                q.add(new int[]{nexti,nextj});
                grid[nexti][nextj] = 0;
            }
        }
    }
}