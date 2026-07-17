class Solution {
    int m;
    int n;
    int dx[]={-1,1,0,0};
    int dy[]={0,0,-1,1};
    
    public void dfs(int row, int col, char [][]board){
        if(row<0 || col<0 || row>=m || col>=n || board[row][col]!='O')
        return;

        board[row][col]='S';
        for(int i=0;i<4;i++){
            int newrow=row+dx[i];
            int newcol=col+dy[i];
            dfs(newrow,newcol,board);
        }

    }
    public void solve(char[][] board) {
        m=board.length;
        n=board[0].length;
        
        // check the boundary O's
        for(int i=0;i<m;i++){
            if(board[i][0]=='O')
            dfs(i,0,board);

            if(board[i][n-1]=='O')
            dfs(i,n-1,board);
        }

        for(int j=0;j<n;j++){
            if(board[0][j]=='O')
            dfs(0,j,board);

            if(board[m-1][j]=='O')
            dfs(m-1,j,board);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='S')
                board[i][j]='O';
                
                else if(board[i][j]=='O')
                board[i][j]='X';
            }
        }

    }
}