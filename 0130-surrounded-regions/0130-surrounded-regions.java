class Solution {
    class Pair{
        int curri,currj,previ,prevj;
        Pair(int curri,int currj,int previ,int prevj){
            this.curri = curri;
            this.currj = currj;
            this.previ = previ;
            this.prevj = prevj;
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] isVisited = new boolean[n][m];
        int[] dir = new int[]{0,1,0,-1,0};

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i == 0 || j == 0 || i == n-1 || j == m-1){
                    if(!isVisited[i][j] && board[i][j] == 'O'){
                        Pair pair = new Pair(i,j,-1,-1);
                        dfs(board,isVisited,dir,pair);
                    }
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!isVisited[i][j] && board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }

    private void dfs(char[][] board,boolean[][] isVisited,int[] dir,Pair pair){
        if(pair.curri < 0 || pair.currj < 0 || pair.curri >= board.length || pair.currj >= board[0].length) return;
        else if(board[pair.curri][pair.currj] == 'X' || isVisited[pair.curri][pair.currj]) return;

        isVisited[pair.curri][pair.currj] = true;
        for(int i=0;i<4;i++){
            dfs(board,isVisited,dir,new Pair(pair.curri+dir[i],pair.currj+dir[i+1],pair.curri,pair.currj));
        }
    }

    private void bfs(char[][] board,boolean[][] isVisited,int[] dir,Pair pair){
        Queue<Pair> q = new LinkedList<>();
        q.add(pair);
        
        isVisited[pair.curri][pair.currj] = true;

        while(!q.isEmpty()){
            pair = q.remove();
            helper(board,isVisited,dir,q,pair);
        }
    }

    private void helper(char[][] board,boolean[][] isVisited,int[] dir,Queue<Pair> q,Pair pair){
        for(int i=0;i<4;i++){
            int nexti = pair.curri + dir[i];
            int nextj = pair.currj + dir[i+1];

            if(nexti == pair.previ && nextj == pair.prevj) continue;

            if(nexti >= 0 && nextj >= 0 && nexti < board.length && nextj < board[0].length){
                if(!isVisited[nexti][nextj] && board[nexti][nextj] == 'O'){
                    q.add(new Pair(nexti,nextj,pair.curri,pair.currj));
                    isVisited[nexti][nextj] = true;
                }
            }
        }
    }
}