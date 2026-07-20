class Solution {

    boolean isprime(int n){
        if(n<2)
        return false;

        for(int i=2;i*i<=n;i++){
            if(n%i==0)
            return false;
        }
        return true;
    }
    public int countbits(int i){
        int count=0;
        while(i>0){
            i=i&(i-1);
            count++;
        }
        return count;
    }
    public int countPrimeSetBits(int left, int right) {
        int ans=0;
        for(int i=left;i<=right;i++){
            int bits=countbits(i);
            if(isprime(bits))
            ans++;
        }
        return ans;
    }
}