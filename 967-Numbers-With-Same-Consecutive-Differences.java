class Solution {
    public void solve(int num,int pos,int n, int k,List<Integer>result){
        if(pos==n){
            result.add(num);
            return;
        }
        int digit=num%10;
        if(digit+k<=9){
            solve(num*10+ (digit+k),pos+1,n,k,result);
        }
        if(k!=0 && digit-k>=0){
            solve(num*10+(digit-k),pos+1,n,k,result);
        }

    }
    public int[] numsSameConsecDiff(int n, int k) {
        ArrayList<Integer>result=new ArrayList<>();
        for(int i=1;i<=9;i++){
            solve(i,1,n,k,result);
        }
        int []ans= new int[result.size()];
        for(int i=0;i<result.size();i++){
            ans[i]=result.get(i);
        }
        return ans;
        
    }
}