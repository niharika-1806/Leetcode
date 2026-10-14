class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum> 9*num)
        return "";

        StringBuilder str=new StringBuilder();   
        int nine=sum/9;
        for(int i=0;i<nine;i++){
            str.append('9');
        }     
        int rem=sum%9;
        if(rem>0)
        str.append((char)('0'+rem));

        int zero=num-str.length();
        for(int i=0;i<zero;i++){
            str.append('0');
        }
        return str.toString();
        


    }
}