class Solution {
    int m;
    int n;
    int dx[]={-1,1,0,0};
    int dy[]={0,0,-1,1};
    public int maxDistance(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        int maxdist=-1;

        int dist[][]=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dist[i],-1);
        }

        Deque<int []>q=new ArrayDeque<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    q.add(new int[]{i,j});
                    dist[i][j]=1;
                }
            }
        }
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int curr[]=q.poll();
                int row=curr[0];
                int col=curr[1];

                for(int j=0;j<4;j++){
                    int newrow=row+dx[j];
                    int newcol=col+dy[j];

                    if(newrow>=0 && newcol>=0 && newrow<m && newcol<n && dist[newrow][newcol]==-1){
                        dist[newrow][newcol]=dist[row][col]+1;
                        q.add(new int[]{newrow,newcol});
                        maxdist=Math.max(maxdist,dist[newrow][newcol]);
                    }
                }
            }
        }
        return maxdist==-1 ? -1 : maxdist-1;
    }
}