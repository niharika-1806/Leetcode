class Solution {
    int m;
    int n;
    int dx[]={-1,1,0,0};
    int dy[]={0,0,-1,1};

    public boolean dfs(int row,int col, int idx, char [][]board,String word,boolean [][]visited){
        if(row<0 || col<0 || row>=m || col>=n || visited[row][col] )
        return false;

        if(board[row][col]!=word.charAt(idx))
        return false;

        if(idx==word.length()-1)
        return true;

        visited[row][col]=true;
        for(int i=0;i<4;i++){
            int newrow=row+dx[i];
            int newcol=col+dy[i];
            if(dfs(newrow,newcol,idx+1,board,word,visited)){
                visited[row][col]=false;
                return true;
            }
        }
        visited[row][col]=false;
        return false;

    }
    public boolean exist(char[][] board, String word) {
        m=board.length;
        n=board[0].length;

        boolean [][]visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    if(dfs(i,j,0,board,word,visited))
                    return true;
                }
            }
        }
        return false;
    }
}