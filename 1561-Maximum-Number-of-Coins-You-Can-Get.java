class Solution {
    public int maxCoins(int[] piles) {
        int ans=0;
        int rounds=piles.length/3;
        int index=piles.length-2;

        Arrays.sort(piles);

        for(int i=0;i<rounds;i++){
            ans+=piles[index];
            index-=2;
        }
        return ans;
    }
}