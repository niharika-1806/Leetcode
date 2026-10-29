class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int n=tokens.length;
        Arrays.sort(tokens);
        int i=0,j=n-1;
        int score=0,maxscore=0;
        while(i<=j){
            if(power>=tokens[i]){
                score++;
                power-=tokens[i];
                i++;
                maxscore=Math.max(maxscore,score);
            }
            else if(score>0 && i<j){
                score--;
                power+=tokens[j];
                j--;
            }
            else{
                break;
            }
        }
        return maxscore;
    }
}