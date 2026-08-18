class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        // length of the largest divisble subset ending at nums[i]
        int dp[]=new int[n];
        // which previous element did this subset come from
        int parent[]=new int[n];
        Arrays.sort(nums);
        Arrays.fill(dp,1);
        Arrays.fill(parent,-1);

        // where does the overall subset ends
        int maxindex=0;
        int maxlen=0;


        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && dp[j]+1 > dp[i]) {
                    dp[i]=dp[j]+1;
                    parent[i]=j;
                }
            }
            // storing the last index of largest subset
            if(dp[i]>maxlen){
                maxlen=dp[i];
                maxindex=i;
            }
        }
        List<Integer>result=new ArrayList<>();
        int index=maxindex;
        while(index!=-1){
            result.add(nums[index]);
            index=parent[index];
        }
        Collections.reverse(result);
        return result;

    }
}