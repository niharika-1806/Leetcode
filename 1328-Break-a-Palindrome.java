class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length()==1)
        return "";
        StringBuilder str=new StringBuilder(palindrome);
        for(int i=0;i<palindrome.length()/2;i++){
            char ch=palindrome.charAt(i);
            if(ch!='a'){
                str.setCharAt(i,'a');
                return str.toString();
            }
        }
        str.setCharAt(str.length()-1,'b');
        return str.toString();
    }
}