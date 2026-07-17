class Solution {
    int m;
    int n;
    int dx[]={-1,1,0,0};
    int dy[]={0,0,-1,1};
    int maxfish=0;
    int fish=0;
    public void dfs(int row, int col, boolean [][]visited, int [][]grid){
        if(row<0 || col<0 || row>=m || col>=n || visited[row][col] || grid[row][col]==0){
            return;
        }
        visited[row][col]=true;
        fish+=grid[row][col];
        for(int i=0;i<4;i++){
            int newrow=row+ dx[i];
            int newcol=col+ dy[i];
            
            dfs(newrow,newcol,visited,grid);
        }
    }
    public int findMaxFish(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        boolean [][]visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0 && !visited[i][j]){
                    fish=0;
                    dfs(i,j,visited,grid);
                    maxfish=Math.max(maxfish,fish);
                }
            }
        }
        return maxfish;
    }
}