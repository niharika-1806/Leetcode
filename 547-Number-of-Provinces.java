class Solution {
    int n;
    public void dfs(int node, int [][]isConnected, boolean[] visited){
        visited[node]=true;
        // check for neighbours
        for(int i=0;i<n;i++){
            if(!visited[i] && isConnected[node][i]==1){
                dfs(i,isConnected,visited);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        n=isConnected.length;
        boolean []visited=new boolean[n];
        int provinces=0;
        for(int i=0;i<n;i++){
            // New component/province found
            if(!visited[i]){
                dfs(i,isConnected,visited);
                provinces++;
            }
        }
        return provinces;
    }
}