class Solution {
    public void solve(int num,int low, int high,List<Integer>result){
        if(num>high)
        return;
        if(num>=low && num<=high){
            result.add(num);
        }
        int lastdigit=num%10;
        if(lastdigit==9)
        return;
        int newnum=num*10+(lastdigit+1);
        solve(newnum,low,high,result);
    }
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer>result= new ArrayList<>();
        // start with every digit
        for(int i=1;i<=9;i++){
            solve(i,low,high,result);
        }
        Collections.sort(result);
        return result;
    }
}