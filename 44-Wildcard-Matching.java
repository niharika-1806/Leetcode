class Solution {
    public boolean isMatch(String s, String p) {
        int len1=s.length();
        int len2=p.length();

        boolean dp[][]=new boolean[len1+1][len2+1];

        dp[0][0]=true;

        for(int i=1;i<=len2;i++){
            if(p.charAt(i-1)=='*'){
                dp[0][i]=dp[0][i-1];
            }
        }
        
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                char a=s.charAt(i-1);
                char b=p.charAt(j-1);

                // if characters match or they are ? (single character)
                // then consume both the characters and move back
                if(a==b || b=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }
                // or take both possibilities of either matching 0 character or more characters
                else if(b=='*'){
                    dp[i][j]= dp[i][j-1] || dp[i-1][j];
                }
                else{
                    dp[i][j]=false;
                }
            }
        }
        return dp[len1][len2];
    }
}