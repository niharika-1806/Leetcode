class Solution {
    public void dfs(int node, boolean []suspicious, List<List<Integer>>adj){
        suspicious[node]=true;
        for(int n: adj.get(node)){
            if(!suspicious[n]){
                dfs(n,suspicious,adj);
            }
        }
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>ans= new ArrayList<>();

        // build an adjacency list
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i[]: invocations){
            int u=i[0];
            int v=i[1];
            adj.get(u).add(v);
        }

        // mark all suspicious nodes
        boolean []suspicious=new boolean[n];
        dfs(k,suspicious,adj);

        // if there are any safe nodes pointing to suspicious node, we can't remove any
        for(int edge[]: invocations){
            int u=edge[0];
            int v=edge[1];

            // if safe->suspicious
            if(!suspicious[u] && suspicious[v]){
                for(int i=0;i<n;i++){
                    ans.add(i);
                }
                return ans;
            }
        }
        // otherwise remove all non suspicious methods
        for(int i=0;i<n;i++){
            if(!suspicious[i])
            ans.add(i);
        }
        return ans;
    }
}