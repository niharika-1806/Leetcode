class Solution {
    public long[] sumOfThree(long num) {
        if(num%3==0){
            long n=num/3;
            return new long[]{n-1,n,n+1};
        }
        return new long[]{};
    }
}