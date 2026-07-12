class Solution {
    int count=0;
    public void solve(int i,int n,boolean []used){
        if(i>n){
            count++;
            return;
        }
        for(int num=1;num<=n;num++){
            if(used[num])
            continue;

            if(num%i==0 || i%num==0){
                used[num]=true;
                solve(i+1,n,used);
                used[num]=false;
            }
        }
    }
    public int countArrangement(int n) {
        boolean used[]=new boolean[n+1];
        solve(1,n,used);
        return count;
    }
}