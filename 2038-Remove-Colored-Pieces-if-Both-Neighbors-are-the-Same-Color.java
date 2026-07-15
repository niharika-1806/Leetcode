class Solution {
    public boolean winnerOfGame(String colors) {
        int a=0;
        int b=0;

        for(int i=1;i<colors.length()-1;i++){
            char ch=colors.charAt(i);

            if(ch==colors.charAt(i-1) && ch==colors.charAt(i+1)){
                if(ch=='A')
                a++;

                else
                b++;
            }            
        }
        return a>b;
    }
}