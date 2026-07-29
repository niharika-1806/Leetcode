class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n=colors.length();
        int ans=0;
        int i=0;
        while(i<n){
            int sum=neededTime[i];
            int maxcost=neededTime[i];
            int j=i+1;
            while(j<n && colors.charAt(i)==colors.charAt(j)){
                sum+=neededTime[j];
                maxcost=Math.max(maxcost,neededTime[j]);
                j++;
            }
            i=j;
            ans+= sum-maxcost;
        }
        return ans;
    }
}