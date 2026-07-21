class Solution {
    public int gcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    public List<String> simplifiedFractions(int n) {
        List<String>result=new ArrayList<>();
        for(int i=1;i<=n;i++){
            for(int j=i+1;j<=n;j++){
                if(gcd(i,j)==1)
                result.add(new String(i+"/"+j));
            }
        }
        return result;
    }
}