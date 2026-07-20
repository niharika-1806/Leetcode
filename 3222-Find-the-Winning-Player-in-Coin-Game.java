class Solution {
    public String winningPlayer(int x, int y) {
        int turn=Math.min(x,y/4);
        return turn%2==0? "Bob" : "Alice";
    }
}