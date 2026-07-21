class Solution {
    int m;
    int n;
    int dx[]={-1,1,0,0};
    int dy[]={0,0,-1,1};
    public long dfs(int row,int col,boolean [][]visited, int [][]grid){
        if(row<0 || col<0 || row>=m || col>=n || visited[row][col] || grid[row][col]==0)
        return 0;

        visited[row][col]=true;
        long sum=grid[row][col];
        for(int i=0;i<4;i++){
            int newrow=row+dx[i];
            int newcol=col+dy[i];

            sum+=dfs(newrow,newcol,visited,grid);
        }
        return sum;

    }
    public int countIslands(int[][] grid, int k) {
        m=grid.length;
        n=grid[0].length;
        int count=0;

        boolean [][]visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]>0 && !visited[i][j]){
                    long sum=dfs(i,j,visited,grid);
                    if(sum%k==0)
                    count++;
                }
            }
        }
        return count;
    }
}