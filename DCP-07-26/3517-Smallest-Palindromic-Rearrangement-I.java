class Solution {
    public String smallestPalindrome(String s) {
        int n=s.length();
        int half=s.length()/2;

        StringBuilder first=new StringBuilder();
        first.append(s,0,half);

        char ch[]=first.toString().toCharArray();
        Arrays.sort(ch);
        first=new StringBuilder(new String(ch));

        StringBuilder second=new StringBuilder(first).reverse();

        if(n%2==0)
        return first.toString()+second.toString();

        return first.toString() + s.charAt(half) + second.toString();
    }
}