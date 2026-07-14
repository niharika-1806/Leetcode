class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int cost=0;
        int i=0;
        while(i<costs.length){
            cost+=costs[i];
            if(cost>coins)
            break;
            i++;
        }
        return i;
    }
}