class Solution {
    public int calc(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer,Integer>freq=new HashMap<>();
        for(int i=0;i<deck.length;i++){
            freq.put(deck[i],freq.getOrDefault(deck[i],0)+1);
        }
        int gcd=0;
        for(int f: freq.values()){
            gcd=calc(gcd,f);
        }
        if(gcd>1)
        return true;
        
        return false;
    }
}