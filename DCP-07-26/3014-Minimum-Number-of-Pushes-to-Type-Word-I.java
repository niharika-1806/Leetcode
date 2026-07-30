class Solution {
    public int minimumPushes(String word) {
        int n=word.length();
        int mul=n/8;
        return 8*(mul)*(mul+1)/2 + (n%8)* (mul+1);
    }
}