class Solution {
    public boolean uniformArray(int[] nums1) {
        int smallodd=Integer.MAX_VALUE;
        for(int n: nums1){
            if(n%2==1)
            smallodd=Math.min(smallodd,n);
        }
        if(smallodd==Integer.MAX_VALUE)
        return true;

        for(int n: nums1){
            if(n%2==0 && n<=smallodd)
            return false;
        }
        return true;



    }
}