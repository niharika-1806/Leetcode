class Solution {
    int m;
    int n;
    int dx[]={-1,1,0,0};
    int dy[]={0,0,-1,1};

    public void dfs(int row,int col,boolean [][]visited,int [][]grid){
        if(row<0 || col<0 || row>=m || col>=n || visited[row][col] || grid[row][col]==0)
        return;

        visited[row][col]=true;
        for(int i=0;i<4;i++){
            int newrow= row+ dx[i];
            int newcol= col+ dy[i];
            dfs(newrow,newcol,visited,grid);
        }
    }

    public int numEnclaves(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        boolean visited[][]=new boolean[m][n];

        // traverse the top and bottom rows
        for(int j=0;j<n;j++){
            if(grid[0][j]==1 && !visited[0][j]){
                dfs(0,j,visited,grid);
            }
            if(grid[m-1][j]==1 && !visited[m-1][j]){
                dfs(m-1,j,visited,grid);
            }
        }

        // traverse the left and rightmost columns
        for(int i=0;i<m;i++){
            if(grid[i][0]==1 && !visited[i][0]){
                dfs(i,0,visited,grid);
            }
            if(grid[i][n-1]==1 && !visited[i][n-1]){
                dfs(i,n-1,visited,grid);
            }
        }
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    count++;
                }
            }
        }
        return count;
    }
}