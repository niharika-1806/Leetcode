class Solution {
    public int minMoves(int[] nums) {
        int moves=0;
        int maxi=Integer.MIN_VALUE;
        for(int num: nums){
            maxi=Math.max(maxi,num);
        }
        for(int num: nums){
            moves+= (maxi-num);
        }
        return moves;
    }
}