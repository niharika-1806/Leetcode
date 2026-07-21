class Solution {
    public boolean isprime(int n){
        if (n<2)
        return false;

        for(int i=2;i*i<=n;i++){
            if(n%i==0)
            return false;
        }
        return true;
    }
    public int diagonalPrime(int[][] nums) {
        int m=nums.length;
        int maxprime=0;
        for(int i=0;i<m;i++){
            if(nums[i][i]>maxprime){
                if(isprime(nums[i][i]))
                maxprime=Math.max(maxprime,nums[i][i]);
            }
        }
        for(int j=0;j<m;j++){
            if(nums[j][m-(j+1)]>maxprime){
                if(isprime(nums[j][m-(j+1)]))
                maxprime=Math.max(maxprime,nums[j][m-(j+1)]);
            }
        }
        return maxprime;
    }
}