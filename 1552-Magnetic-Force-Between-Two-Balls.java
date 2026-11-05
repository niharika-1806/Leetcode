class Solution {
    public int calc(int position[],int force){
        int balls=1;
        int last=position[0];
        for(int i=1;i<position.length;i++){
            if(position[i]-last>=force){
                balls++;
                last=position[i];
            }
        }
        return balls;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low=1,high=position[position.length-1] - position[0];
        int ans=1;
        while(low<=high){
            int force=low+(high-low)/2;
            int balls=calc(position,force);

            if(balls>=m){
                ans=force;
                low=force+1;
            }
            else{
                high=force-1;
            }
        }
        return ans;
    }
}