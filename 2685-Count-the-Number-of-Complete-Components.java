class Solution {
    int nodes=0;
    int edge=0;
    public void dfs(int node, boolean []visited, List<List<Integer>>adj){
        visited[node]=true;
        nodes++;
        edge+= adj.get(node).size();
        for(int n: adj.get(node)){
            if(!visited[n]){
                dfs(n,visited,adj);
            }
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[]: edges){
            int u=edge[0];
            int v=edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int count=0;
        boolean []visited=new boolean[n];
        for(int i=0;i<n;i++){
            // check for every component
            if(!visited[i]){
                nodes=0;
                edge=0;
                dfs(i,visited,adj);
                edge/=2;
                if(edge==nodes*(nodes-1)/2){
                    count++;
                }
            }
        }
        return count;
    }
}