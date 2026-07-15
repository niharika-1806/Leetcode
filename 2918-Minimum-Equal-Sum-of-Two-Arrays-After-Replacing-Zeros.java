class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long minsum1=0;
        long minsum2=0;
        int count1=0;
        int count2=0;
        long sum1=0;
        long sum2=0;
        for(int n: nums1){
            if(n==0)
            count1++;
            sum1+=n;
        }
        for(int n: nums2){
            if(n==0)
            count2++;
            sum2+=n;
        }
        minsum1=sum1+count1;
        minsum2=sum2+count2;

        if(minsum1<minsum2 && count1==0)
        return -1;
        
        if(minsum1>minsum2 && count2==0)
        return -1;

        return Math.max(minsum1,minsum2);
    }
}