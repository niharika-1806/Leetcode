class Solution {
    // up down left right
    int dx[]={-1,1,0,0};
    int dy[]={0,0,-1,1};
    int m;
    int n;

    public void dfs(int row,int col,boolean [][]visited, int [][]image, int color,int original){
        // if it is not inside the grid or it is already visited or it is not same as the original color, return, don't go on that path
        if(row<0 || row>=m || col<0 || col>=n || visited[row][col] || image[row][col]!=original){
            return;
        }
        // mark the current cell as visited
        visited[row][col]=true;
        // assign the new color
        image[row][col]=color;

        // check in all four directions through dfs
        for(int i=0;i<4;i++){
            int newrow=row+dx[i];
            int newcol=col+dy[i];

            dfs(newrow,newcol,visited,image,color,original);
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        m=image.length;
        n=image[0].length;
        boolean visited[][]=new boolean[m][n];
        int original=image[sr][sc];
        if(original==color){
            return image;
        }
        dfs(sr,sc,visited,image,color,original);
        return image;
    }
}