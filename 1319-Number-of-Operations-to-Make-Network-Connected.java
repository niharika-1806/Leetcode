class Solution {
    public void dfs(int node, List<List<Integer>>adj, boolean []visited){
        visited[node]=true;
        for(int n: adj.get(node)){
            if(!visited[n]){
                dfs(n,adj,visited);
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1){
            return -1;
        }
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int c[]:connections){
            int u=c[0];
            int v=c[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int count=0;
        boolean []visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,adj,visited);
                count++;
            }
        }
        return count-1;
    }
}