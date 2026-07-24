class Solution {
    int m;
    int n;
    int dx[]={-1,-1,-1,0,0,1,1,1};
    int dy[]={-1,0,1,-1,1,-1,0,1};
    public int shortestPathBinaryMatrix(int[][] grid) {
        n=grid.length;
        if(n==1 && grid[0][0]==0)
        return 1;

        int distance=1;
        Deque<int []>q=new ArrayDeque<>();


        if(grid[0][0]==1 || grid[n-1][n-1]==1)
        return -1;

        q.add(new int[]{0,0});
        // mark visited
        grid[0][0]=1;

        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int curr[]=q.poll();
                int row=curr[0];
                int col=curr[1];

                if(row==n-1 && col==n-1)
                return distance;

                for(int j=0;j<8;j++){
                    int newrow=row+dx[j];
                    int newcol=col+dy[j];


                    if(newrow>=0 && newcol>=0 && newrow<n && newcol<n &&
                     grid[newrow][newcol]==0){
                        // mark visited
                        grid[newrow][newcol]=1;
                        q.add(new int[]{newrow,newcol});
                     }
                }
            }
            distance++;
        }
        return -1;
    }
}