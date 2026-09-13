class Solution {
    public String minWindow(String s, String t) {
        int tfreq[]=new int[128];
        // frequency of characters in the current window
        int window[]=new int[128];
        // frequency of characters required from t
        for(char ch: t.toCharArray()){
            tfreq[ch]++;
        }
        int left=0,right=0;
        // number of characters still required(including duplicates)
        int required=t.length();
        int minlength=Integer.MAX_VALUE;
        int start=0;

        while(right<s.length()){
            char ch=s.charAt(right);
            window[ch]++;

            // if this character was still needed, we've satisfied one requirement
            if(window[ch]<=tfreq[ch]){
                required--;
            }
            // till the window is valid
            while(required==0){
                // update answer
                if(right-left+1< minlength){
                    minlength=right-left+1;
                    start=left;
                }
                // try removing the left character
                char leftchar=s.charAt(left);
                window[leftchar]--;

                // if removing this character makes us lose the character, increase the requirement
                if(window[leftchar]< tfreq[leftchar])
                required++;

                left++;
            }
            right++;
        }
        if(minlength==Integer.MAX_VALUE)
        return "";

        return s.substring(start,start+minlength);
        
    }
}