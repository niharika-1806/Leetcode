class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]>pq=new PriorityQueue<>(
           (a,b) -> Integer.compare(b[2],a[2])
        );
        
        for(int i=0;i<points.length;i++){
            int sum=0;
            for(int j=0;j<2;j++){
                sum+=(points[i][j]*points[i][j]);
            }
            pq.offer(new int[]{points[i][0],points[i][1],sum});
            if(pq.size()>k){
                pq.poll();
            }
        }
        int result[][]=new int[k][2];
        for(int i=0;i<k;i++){
            int point[]=pq.poll();
            result[i][0]=point[0];
            result[i][1]=point[1];
        }
        return result;
    }
}