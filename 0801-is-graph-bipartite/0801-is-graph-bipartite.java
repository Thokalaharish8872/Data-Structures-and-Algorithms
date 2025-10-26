class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        int[] color = new int[n];

        for(int i=0;i<n;i++){
            ArrayList<Integer> a = new ArrayList<>();
            for(int ele : graph[i]){
                a.add(ele);
            }
            al.add(a);
        }

        for(int i=0;i<n;i++){
            if(color[i] == 0){
                if(!bfs(al,color,i)) return false;
            }
        }
        return true;

    }

    private boolean bfs(ArrayList<ArrayList<Integer>> al,int[] color,int i){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        color[i] = 1;

        while(!q.isEmpty()){
            int curr = q.remove();
            for(int neig : al.get(curr)){
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