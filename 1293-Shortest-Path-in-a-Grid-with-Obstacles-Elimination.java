class Solution {
    int m;
    int n;
    int dx[]={-1,1,0,0};
    int dy[]={0,0,-1,1};
    public int shortestPath(int[][] grid, int k) {
        m=grid.length;
        n=grid[0].length;

        boolean [][][]visited= new boolean[m][n][k+1];
        Deque<int[]>q=new ArrayDeque<>();
        q.add(new int[]{0,0,k});
        visited[0][0][k]=true;

        int steps=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int curr[]=q.poll();
                int row=curr[0];
                int col=curr[1];
                int remk=curr[2];

                if(row==m-1 && col==n-1)
                return steps;

                for(int j=0;j<4;j++){
                    int newrow=row+dx[j];
                    int newcol=col+dy[j];

                    if(newrow<0 || newcol<0 || newrow>=m || newcol>=n)
                    continue;

                    // if an empty cell comes
                    if(grid[newrow][newcol]==0 && !visited[newrow][newcol][remk]){
                        visited[newrow][newcol][remk]=true;
                        q.add(new int[]{newrow,newcol,remk});
                    }
                    else if(grid[newrow][newcol]==1 && remk>0 && 
                    !visited[newrow][newcol][remk-1]){
                        visited[newrow][newcol][remk-1]=true;
                        q.add(new int[]{newrow,newcol,remk-1});
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}