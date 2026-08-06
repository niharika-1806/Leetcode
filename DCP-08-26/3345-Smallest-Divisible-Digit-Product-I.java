class Solution {
    public int digitproduct(int n){
        int prod=1;
        while(n!=0){
            prod*= (n%10);
            n/=10;
        }
        return prod;
    }
    public int smallestNumber(int n, int t) {
        while(true){
            if(digitproduct(n)%t==0){
                return n;
            }
            n++;
        }
    }
}