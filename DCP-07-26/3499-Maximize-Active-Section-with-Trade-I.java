class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n=s.length();
        int count1=0;
        int prevblock=0;
        int nextblock=0;
        
        int max=0;
        int i=0;
        while(i<n){

            if(s.charAt(i)=='0'){
                prevblock++;
                i++;
            }
            else{
                while(i<n && s.charAt(i)=='1'){
                    i++;
                    count1++;
                }
                while(i<n && s.charAt(i)=='0'){
                    i++;
                    nextblock++;
                }
                // means if there is 0's block before and after
                if(prevblock!=0 && nextblock!=0){
                max=Math.max(max,prevblock+nextblock);
                }

                prevblock=nextblock;
                nextblock=0;
            }
        }
        return count1+max;
    }
}