class Solution {
    int m;
    int n;
    int dx[]={-1,1,0,0};
    int dy[]={0,0,-1,1};

    public boolean dfs(int row,int col,int parentrow,int parentcol,boolean [][]visited,
    char [][]grid){
        visited[row][col]=true;
        for(int i=0;i<4;i++){
            int newrow=row+dx[i];
            int newcol=col+dy[i];
            if(newrow<0 || newcol<0 || newrow>=m || newcol>=n)
            continue;

            if(grid[newrow][newcol]!=grid[row][col])
            continue;

            if(newrow==parentrow && newcol==parentcol)
            continue;

            if(visited[newrow][newcol])
            return true;

            if(dfs(newrow,newcol,row,col,visited,grid))
            return true;
        }
        return false;
        
    }
    public boolean containsCycle(char[][] grid) {
        m=grid.length;
        n=grid[0].length;
        boolean [][]visited=new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    if(dfs(i,j,-1,-1,visited,grid))
                    return true;
                }
            }
        }
        return false;
    } 
}