class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int mini=Integer.MAX_VALUE;
        int n=nums.size();
        int prefix[]=new int[n+1];

        for(int i=0;i<n;i++){
            prefix[i+1]=prefix[i]+nums.get(i);
        }
        for(int i=0;i<n;i++){
            for(int len=l;len<=r;len++){
                int j=i+len-1;
                if(j>=n)
                break;

                int sum=prefix[j+1]-prefix[i];
                if(sum>0){
                    mini=Math.min(mini,sum);
                }
            }
        }
        return mini==Integer.MAX_VALUE ? -1 : mini;
    }
}