class Solution {
    public int kthFactor(int n, int k) {
        if(n<3)
        return n;

        if(k==n)
        return -1;
        List<Integer>factors=new ArrayList<>();
        for(int i=1;i*i<=n;i++){
            if(n%i==0)
            factors.add(i);
        }
        for(int i=(int)Math.sqrt(n);i>=1;i--){
            if(n%i==0 && !factors.contains(n/i)){
                factors.add(n/i);
            }
        }
        if(factors.size()<k)
        return -1;
        return factors.get(k-1);
    }
}