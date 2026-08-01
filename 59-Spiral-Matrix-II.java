class Solution {
    public int[][] generateMatrix(int n) {
        int val=1;
        int top=0;
        int bottom=n-1;
        int left=0;
        int right=n-1;

        int [][]ans=new int[n][n];

        while(top<=bottom && left<=right)
        {
            // traversing top row
            for(int j=left;j<=right;j++)
            {
                ans[top][j]=val++;
            }
            top++;

            // traversing from top to bottom
            for(int j=top;j<=bottom;j++)
            {
                ans[j][right]=val++;
            }
            right--;

            // traversing last row
            if(top<=bottom)
            {
                for(int j=right;j>=left;j--)
                {
                    ans[bottom][j]=val++;
                }
                bottom--;
            }
            // traversing bottom to top
            if(left<=right)
            {
                for(int j=bottom;j>=top;j--)
                {
                    ans[j][left]=val++;
                }
                left++;
            } 
        }
        return ans;

    }
}