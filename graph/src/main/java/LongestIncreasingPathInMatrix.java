// why cache is working here ?
// the reason is if you are going from 2,2 to 2,1 it means 2,1 is greater which means you would have never come to 2,2 from 2,1 so there will not be any overlap
class LongestIncreasingPathInMatrix {
    int dx[] = {-1,1,0,0};
    int dy[] = {0,0,1,-1};
    int totalRows,totalCols;
    public int longestIncreasingPath(int[][] matrix) {

        totalRows = matrix.length;
        totalCols = matrix[0].length;
        int[][] cache = new int[totalRows][totalCols];
        int ans=0;
        for(int i=0;i<totalRows;i++)
        {
            for(int j=0;j<totalCols;j++)
            {
                cache[i][j] = dfs(matrix,i,j,cache);
                ans = Math.max(ans, cache[i][j]);
            }
        }
        return ans;


    }

    public int dfs(int[][] matrix, int i, int j,int[][] cache)
    {
        if(cache[i][j]!=0)
            return cache[i][j];

        for(int k=0;k<4;k++)
        {
            int nextRow = i+dx[k];
            int nextCol = j+dy[k];
            if(nextRow>=0 && nextRow<totalRows && nextCol>=0 && nextCol<totalCols && matrix[nextRow][nextCol]>matrix[i][j])
                cache[i][j] = Math.max(cache[i][j], dfs(matrix, nextRow,nextCol, cache));
        }
        cache[i][j] = cache[i][j]+1;
        return cache[i][j];
    }



}