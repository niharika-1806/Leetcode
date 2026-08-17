class Solution {
    public int longestSubsequence(int[] nums) {
        int len=nums.length;
        boolean nonzero=false;
        int xor=0;
        for(int n: nums){
            if(n!=0)
            nonzero=true;
            xor^=n;
        }
        if(xor!=0)
        return len;

        if(nonzero)
        return len-1;

        return 0;

    }
}