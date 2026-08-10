class Solution {
    public int findTheCity(int n, int[][] edges, int threshold) {
        int dist[][]=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
            dist[i][i]=0;
        }
        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];

            dist[u][v]=w;
            dist[v][u]=w;
        }
        for(int k=0;k<n;k++){
            for(int j=0;j<n;j++){
                for(int i=0;i<n;i++){
                    if(dist[i][k]!=Integer.MAX_VALUE && dist[j][k]!=Integer.MAX_VALUE)
                    dist[i][j]=Math.min(dist[i][j], dist[i][k]+dist[j][k]);
                }
            }
        }

        int ans=0;
        int mincount=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(i!=j && dist[i][j]<=threshold)
                count++;
            }
            if(count<=mincount){
                mincount=count;
                ans=i;
            }
        }
        return ans;
    }
}