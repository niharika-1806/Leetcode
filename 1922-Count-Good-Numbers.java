class Solution {
    long mod=1_000_000_007L;
    public long pow(long x, long n){
        if(n==0)
        return 1;

        if(n<0){
            return (pow(1/x,-n))%mod;
        }
        if(n%2==0){
            return pow((x*x)%mod,n/2) %mod;
        }
        return (x%mod )* pow( (x*x)%mod, ((n-1)/2))%mod;

    }
    public int countGoodNumbers(long n) {
        long even=(n+1)/2;
        long odd=n/2;

        return (int) ((pow(5,even) * pow(4,odd)) % mod);
     
        
    }
}