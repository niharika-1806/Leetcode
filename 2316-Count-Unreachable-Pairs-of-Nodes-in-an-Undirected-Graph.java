class Solution {
    int nodes=0;
    public void dfs(int node, List<List<Integer>>adj, boolean []visited){
        nodes++;
        visited[node]=true;
        for(int n: adj.get(node)){
            if(!visited[n]){
                dfs(n,adj,visited);
            }
        }
    }
    public long countPairs(int n, int[][] edges) {
        long pairs=0;
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

        boolean []visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                nodes=0;
                dfs(i,adj,visited);
                pairs+=(long) nodes*(n-nodes);
            }
        }
        return pairs/2;
    }
}