class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n=arr.length;
        int result[]=new int[2];
        PriorityQueue<int[]>pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(
                arr[a[0]]*arr[b[1]],
                arr[a[1]]*arr[b[0]]
            )
        );
        // insert the smallest fraction for each  numerator, the largest denominator is n-1, which would give us the smallest fraction
        for(int i=0;i<n-1;i++){
            pq.offer(new int[]{i,n-1});
        }

        for(int i=0;i<k;i++){
            // we keep on removing the smallest fraction
            int curr[]=pq.poll();
            int num=curr[0];
            int den=curr[1];

            // decreasing the denominator, increases the fraction
            if(den-1>num){
                pq.offer(new int[]{num,den-1});
            }
            // when we reach the kth smallest fraction, we return it immediately
            if(i==k-1){
                return new int[]{arr[num],arr[den]};
            }
        }
        return new int[]{-1,-1};
    }
}