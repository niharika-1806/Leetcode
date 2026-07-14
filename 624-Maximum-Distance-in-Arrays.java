class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int globalmin=arrays.get(0).get(0);
        int globalmax=arrays.get(0).get(arrays.get(0).size()-1);

        int ans=0;
        for(int i=1;i<arrays.size();i++){
            int currmin=arrays.get(i).get(0);
            int currmax=arrays.get(i).get(arrays.get(i).size()-1);

            // choose largest element from current array nd smallest from previous arrays
            ans=Math.max(ans,currmax - globalmin);

            // choose smallest element from current array and largest from previous arrays
            ans=Math.max(ans,globalmax- currmin);

            // updating global min and max
            globalmin=Math.min(globalmin,currmin);
            globalmax=Math.max(globalmax,currmax);

        }
        return ans;
    }
}