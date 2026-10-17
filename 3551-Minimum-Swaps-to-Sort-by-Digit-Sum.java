class Solution {
    public int calcsum(int num){
        int sum=0;
        while(num!=0){
            sum+=num%10;
            num/=10;
        }
        return sum;
    }
    
    public int minSwaps(int[] nums) {
        int n=nums.length;
        int arr[]=new int[n];
        boolean visited[]=new boolean[n];
        int pair[][]=new int[n][3];


        for(int i=0;i<n;i++){
            pair[i][0]=calcsum(nums[i]);
            pair[i][1]=nums[i];
            pair[i][2]=i;
        }

        Arrays.sort(pair,(a,b) -> {
            if(a[0]!=b[0])
            return Integer.compare(a[0],b[0]);

            else
            return Integer.compare(a[1],b[1]);
        });
        
        int swaps=0;
        for(int i=0;i<n;i++){
            if(visited[i] || pair[i][2]==i){
                continue;
            }
            int j=i,cycles=0;
            while(!visited[j]){
                visited[j]=true;
                j=pair[j][2];
                cycles++;
            }
            if(cycles>1)
            swaps+=(cycles-1);
        }
        return swaps;

    }
}