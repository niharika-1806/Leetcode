class Solution {
    int islands=0;
    int dx[]={-1,1,0,0};
    int dy[]={0,0,-1,1};
    int m;
    int n;
    public void dfs(int row,int col,boolean [][]visited, char[][]grid){
        // if not in bounds, water or already visited, return
        if(row<0 || row>=m || col<0 || col>=n || visited[row][col] || grid[row][col]=='0')
        return;

        visited[row][col]=true;
        // look for its four directions
        for(int i=0;i<4;i++){
            int newrow=row+dx[i];
            int newcol=col+dy[i];
            dfs(newrow,newcol,visited,grid);
        }
    }
    public int numIslands(char[][] grid) {
        m=grid.length;
        n=grid[0].length;
        boolean [][]visited=new boolean[m][n];

        // visit each cell everytime, increase count only when a dfs call finds a new disconnecte component, a new island
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    islands++;
                    dfs(i,j,visited,grid);
                }
            }
        }
        
        return islands;
    }
}