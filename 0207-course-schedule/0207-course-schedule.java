class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        boolean[] isVisited = new boolean[n];
        boolean[] isPathVisited = new boolean[n];
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();

        for(int i=0;i<prerequisites.length;i++){
            if(map.containsKey(prerequisites[i][1])){
                ArrayList<Integer> al = map.get(prerequisites[i][1]);
                al.add(prerequisites[i][0]);
            } 
            else{
                ArrayList<Integer> al = new ArrayList<>();
                al.add(prerequisites[i][0]);
                map.put(prerequisites[i][1],al);
            }
        }

        for(int i=0;i<n;i++){
            if(!isVisited[i]){
                if(dfs(map,isVisited,isPathVisited,i)) return false;
            }
        }

        return true;
    }

    private boolean dfs(HashMap<Integer,ArrayList<Integer>> map,boolean[] isVisited,boolean[] isPathVisited,int i){
        if(isPathVisited[i]) return true;
        else if(isVisited[i] || !map.containsKey(i)) return false;

        isVisited[i] = true;
        isPathVisited[i] = true;
        for(int neig : map.get(i)){
            if(dfs(map,isVisited,isPathVisited,neig)) return true;
        }
        
        isPathVisited[i] = false;
        return false;
    }
}