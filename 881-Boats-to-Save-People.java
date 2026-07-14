class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i=0;
        int j=people.length-1;
        int boats=0;
        int sum=0;
        while(i<=j){
            sum=(people[i]+people[j]);
            if(sum>limit){
                boats+=1;
                j--;
            }
            else{
                i++;
                j--;
                boats+=1;
            }
        }
        return boats;
    }
}