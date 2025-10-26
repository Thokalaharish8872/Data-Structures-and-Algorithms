class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        int[] color = new int[n];

        for(int i=0;i<n;i++){
            if(color[i] == 0){
                if(!dfs(graph,color,i)) return false;
            }
        }
        return true;

    }

    private boolean dfs(int[][] graph,int[] color,int i){
        if(color[i] == 0) color[i] = 1;

        for(int neig : graph[i]){
            if(color[neig] == 0){
                if(color[i] == 1) color[neig] = 2;
                else color[neig] = 1;
                
                if(!dfs(graph,color,neig)) return false;
            }
            else{
                if(color[neig] == color[i]) return false;
            }

        }
        return true;
    }

    private boolean bfs(int[][] graph,int[] color,int i){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        color[i] = 1;

        while(!q.isEmpty()){
            int curr = q.remove();

            for(int neig : graph[curr]){
                if(color[neig] == 0){
                    q.add(neig);

                    if(color[curr] == 1) color[neig] = 2;
                    else color[neig] = 1;
                }
                else{
                    if(color[neig] == color[curr]) return false;
                }
            }
        }

        return true;
    }
}