class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long common=Math.min(need1,need2);
        long a=need1-common;
        long b=need2-common;

        long total=common*Math.min(costBoth, cost1+cost2) +
        a*Math.min(costBoth,cost1) +
        b*Math.min(costBoth,cost2);

        return total;
    }
}