class Solution {
    public String multiply(String num1, String num2) {
        int n=num1.length();
        int m=num2.length();

        int result[]=new int[n+m];
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                int d1=num1.charAt(i)-'0';
                int d2=num2.charAt(j)-'0';

                int p1=i+j; // where we add carry
                int p2=i+j+1; // where we store the digit

                int sum=d1*d2+result[p2];
                result[p2]=sum%10; // store digit
                result[p1]+=sum/10; // store carry

            }
        }
        StringBuilder ans=new StringBuilder();
        for(int digit: result){
            if(ans.length()==0 && digit==0){
                continue;
            }
            ans.append(digit);
        }
        return ans.length()==0 ? "0" : ans.toString();
    }
}