class Solution {
    public int totalNumbers(int[] digits) {
        List<Integer>ans=new ArrayList<>();
        int freq[]=new int[10];
        for(int d: digits){
            freq[d]++;
        }

        for(int h=1;h<=9;h++){
            if(freq[h]==0)
            continue;

            freq[h]--;
            for(int t=0;t<=9;t++){
                if(freq[t]==0)
                continue;

                freq[t]--;

                for(int o=0;o<=9;o+=2){
                    if(freq[o]==0)
                    continue;

                    ans.add(h*100+t*10+o);
                }
                freq[t]++;
            }
            freq[h]++;
        }
        return ans.size();
    }
}