class Solution {
    int count=0;
    public boolean issafe(int row, int col,char [][]board,int n){
        // Check upward in the same column
        for(int r=row-1;r>=0;r--){
            if(board[r][col]=='Q')
            return false;
        }

        // Check upper right diagonal
        int r=row-1;
        int c=col+1;
        while(r>=0 && c<n){
            if(board[r][c]=='Q')
            return false;

            r--;
            c++;
        }

        // Check upper left diagonal
        r=row-1;
        c=col-1;
        while(r>=0 && c>=0){
            if(board[r][c]=='Q')
            return false;

            r--;
            c--;
        }
        return true;
    }
    // Place a queen somewhere in the current row
    public void solve(int row,char [][] board,int n){
        // means we've successfully placed all queens and found one valid solution
        if(row==n){
            count++;
            return;
        }
        for(int col=0;col<n;col++){
            // check if safe to place the queen in (row,col)
            if(issafe(row,col,board,n)){
                // place queen
                board[row][col]='Q';
                // move to next row
                solve(row+1,board,n);
                // remove queen
                board[row][col]='.';
            }
        }
    }
    public int totalNQueens(int n) {
        char [][]board=new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        solve(0,board,n);
        return count;
        
    }
}