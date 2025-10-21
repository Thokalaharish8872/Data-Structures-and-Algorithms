class Solution {
    class Pair{
        int i,j;
        Pair(int i,int j){
            this.i = i;
            this.j = j;
        }
    }

    public boolean containsCycle(char[][] grid) {
        
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        boolean foundCycle = false;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!isVisited[i][j]){
                    if(bfs(grid,isVisited,grid[i][j],i,j)){
                        foundCycle = true;
                        break;
                    }
                }
            }
            if(foundCycle) break;
        }
        return foundCycle;
    }

    private boolean bfs(char[][] grid,boolean[][] isVisited,char ch,int i,int j){
        Queue<Pair[]> q = new LinkedList<>();
        Pair[] pair = new Pair[]{new Pair(i,j),new Pair(-1,-1)};
        q.add(pair);

        isVisited[i][j] = true;

        while(!q.isEmpty()){
            pair = q.remove();

            if(helper(grid,isVisited,q,ch,pair)) return true;
        }
        return false;
    }

    // private boolean dfs(char[][] grid,boolean[][] isVisited,char ch,int i,int j){
    //     if(grid[i][j] != ch) return false;
    //     else if(isVisited[i][j]) return true;
    // }

    private boolean helper(char[][] grid,boolean[][] isVisited,Queue<Pair[]> q,char ch,Pair[] pair){
        int curri = pair[0].i,currj = pair[0].j,previ = pair[1].i,prevj = pair[1].j;
        Pair[] next = new Pair[]{new Pair(curri+1,currj),new Pair(curri,currj+1),new Pair(curri-1,currj),new Pair(curri,currj-1)};

        for(int k=0;k<4;k++){
            int nexti = next[k].i;
            int nextj = next[k].j;

            if((nexti >= 0 && nextj >= 0) && (nexti < grid.length && nextj < grid[0].length)){
                
                if(nexti == previ && nextj == prevj) continue;
                if(grid[nexti][nextj] == ch){

                    if(!isVisited[nexti][nextj]){
                        q.add(new Pair[]{new Pair(nexti,nextj),new Pair(curri,currj)});
                        isVisited[nexti][nextj] = true;
                    }
                    else return true;
                }
            }
        }
        return false;
    }
}