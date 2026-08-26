class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len=strs.length;
        // maximum number of strings we can select using first i strings with at most zeros capacity and ones capacity
        int dp[][][]=new int[len+1][m+1][n+1];
        dp[0][0][0]=0;

        for(int i=1;i<=len;i++){
            String str=strs[i-1];

            int zeros=0;
            int ones=0;

            for(char ch: str.toCharArray()){
                if(ch=='0')
                zeros++;

                else
                ones++;
            }

            for(int z=0;z<=m;z++){
                for(int o=0;o<=n;o++){
                    int take=0;

                    if(z>=zeros && o>=ones){
                        take=dp[i-1][z-zeros][o-ones] +1 ;
                    }
                    int skip=dp[i-1][z][o];

                    dp[i][z][o]=Math.max(take,skip);
                }
            }

        }
        return dp[len][m][n];

    }
}