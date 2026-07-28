class Solution {
    public boolean dfs(int u, int v,boolean []visited,List<List<Integer>>adj){
        if(u==v)
        return true;
        visited[u]=true;
        for(int n: adj.get(u)){
            if(!visited[n]){
                if(dfs(n,v,visited,adj))
                return true;
            }
        }
        return false;
    }
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<=edges.length;i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[]: edges){
            int u=edge[0];
            int v=edge[1];

            boolean []visited=new boolean[edges.length+1];

            // check if a path already exits from u to v, then the current edge is forming the cycle.
            if(dfs(u,v,visited,adj)){
                 return edge;
            }
            else{
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
        }
        return new int[0];
    }
}