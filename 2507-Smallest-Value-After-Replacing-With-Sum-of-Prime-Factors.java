class Solution {
    public boolean isprime(int n){
        if(n<=1)
        return false;

        for(int i=2;i*i<=n;i++){
            if(n%i==0)
            return false;
        }
        return true;
    }
    public int sumprimefactors(int n){
        int sum=0;
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                while(n%i==0){
                    sum+=i;
                    n/=i;
                }
            }
        }
        if(n>1)
        sum+=n;

        return sum;
    }
    public int smallestValue(int n) {
        if(sumprimefactors(n)==n)
        return n;
        while(!isprime(n)){
            n=sumprimefactors(n);
        }
        return n;
    }
}