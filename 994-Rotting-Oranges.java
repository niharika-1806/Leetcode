class Solution {
    int m;
    int n;
    int dx[]={-1,1,0,0};
    int dy[]={0,0,-1,1};
    int min=0;
    public int orangesRotting(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        int fresh=0;

        Deque<int []>q=new ArrayDeque<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                // initially insert all the rotten oranges
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                // count all the fresh oranges
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        // If no fresh oranges are there, we don't require any minute to make it rotten
        if(fresh==0)
        return 0;

        while(!q.isEmpty() && fresh>0){
            int size=q.size();
            // move level wise
            for(int i=0;i<size;i++){
                int []curr=q.poll();
                int row=curr[0];
                int col=curr[1];

                // check all 4 neighbours
                for(int j=0;j<4;j++){
                    int newrow=row+dx[j];
                    int newcol=col+dy[j];
                    
                    // if it is in bounds and is fresh , then make it rotten
                    if(newcol>=0 && newrow>=0 && newrow<m && newcol<n && grid[newrow][newcol]==1){
                        grid[newrow][newcol]=2;
                        // add to the queue
                        q.add(new int[]{newrow,newcol});
                        //  decrease the fresh count as we made it rotten
                        fresh--;
                    }
                }
            }
            // after each level, we spent one minute
            min++;
        }
        // if all fresh oranges are made rotten then return minutes otherwise -1
        return fresh==0 ? min : -1;
    }
}