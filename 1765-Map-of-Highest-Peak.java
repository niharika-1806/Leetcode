class Solution {
    int m;
    int n;

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    public int[][] highestPeak(int[][] isWater) {
        m = isWater.length;
        n = isWater[0].length;

        int[][] height = new int[m][n];

        // Mark every cell as unvisited
        for (int i = 0; i < m; i++) {
            Arrays.fill(height[i], -1);
        }

        Deque<int[]> q = new ArrayDeque<>();

        // All water cells are the sources
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (isWater[i][j] == 1) {
                    q.offer(new int[]{i, j});
                    height[i][j] = 0;
                }

            }
        }
         while (!q.isEmpty()) {

            int[] curr = q.poll();

            int row = curr[0];
            int col = curr[1];

            for (int i = 0; i < 4; i++) {

                int newrow = row + dx[i];
                int newcol = col + dy[i];

                if(newrow>=0 && newcol>=0 && newrow<m && newcol<n && height[newrow][newcol]==-1){
                    height[newrow][newcol] = height[row][col] + 1;
                    q.offer(new int[]{newrow, newcol});
                }
            }
        }
        return height;
    }
}