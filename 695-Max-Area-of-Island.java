class Solution {
    int m;
    int n;
    // up down left right
    int dx[]={-1,1,0,0};
    int dy[]={0,0,-1,1};
    int maxarea=0;

    public int dfs(int row,int col,boolean [][]visited,int [][]grid){
        if(row<0 || col<0 || row>=m || col>=n || visited[row][col] || grid[row][col]==0){
            return 0;
        }
        int area=1;
        visited[row][col]=true;
        for(int i=0;i<4;i++){
            int newrow= row+ dx[i];
            int newcol= col + dy[i];
            area+=dfs(newrow,newcol,visited,grid);
        }
        return area;
    }
    public int maxAreaOfIsland(int[][] grid) {
        m=grid.length;
        n=grid[0].length;

        boolean [][]visited= new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                // one complete dfs corresponds to one complete island, so update max area after every island. 
                int area=dfs(i,j,visited,grid);
                maxarea=Math.max(maxarea,area);
                }
            }
            
        }
        return maxarea;
        
    }
}