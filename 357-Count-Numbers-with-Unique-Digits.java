class Solution {
    // count zero separately
    int count=1;
    public void solve(int pos,int n,boolean []used){
        // we can't use more than n digits
        if(pos==n)
        return;
        
        for(int i=0;i<=9;i++){
            if(pos==0 && i==0)
            continue;
            if(used[i])
            continue;

            used[i]=true;
            count++;
            solve(pos+1,n,used);
            used[i]=false;
        }
    }
    public int countNumbersWithUniqueDigits(int n) {
        boolean used[]=new boolean[10];
        solve(0,n,used);
        return count;
    }
}