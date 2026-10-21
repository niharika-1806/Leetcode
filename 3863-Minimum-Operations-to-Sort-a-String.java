class Solution {
    public int minOperations(String s) {
        int n=s.length();
        

        char minchar=s.charAt(0);
        char maxchar=s.charAt(0);

        boolean issorted=true;
        for(int i=1;i<n;i++){
            char ch=s.charAt(i);
            if(ch < s.charAt(i-1))
            issorted=false;

            minchar=(char)Math.min(minchar, ch);
            maxchar=(char)Math.max(maxchar,ch);
        }
        if(issorted)
        return 0;

        if(n==2)
        return -1;

        if(s.charAt(0)==minchar || s.charAt(n-1)==maxchar)
        return 1;

        for(int i=1;i<n-1;i++){
            if(s.charAt(i)==minchar || s.charAt(i)==maxchar)
            return 2;
        }
        return 3;
    }
}