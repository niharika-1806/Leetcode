class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        int dp[]=new int[n+1];
        // empty string
        dp[0]=1;

        // first character will always have 1 way
        if(s.charAt(0)!='0')
        dp[1]=1;


        for(int i=2;i<=n;i++){
            char curr=s.charAt(i-1);

            // current digit alone
            if(curr!='0'){
                dp[i]+=dp[i-1];
            }
            // two digits together
            int twodigit= (s.charAt(i-2)-'0')*10 + (s.charAt(i-1)-'0');
            if(twodigit>=10 && twodigit<=26){
                dp[i]+=dp[i-2];
            }
        }
        return dp[n];

    }
}