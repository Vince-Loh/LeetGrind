class Solution {
  int M = 1000000007;
  int[][][] memo;
  int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
  
  public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
    memo = new int[m][n][maxMove + 1];
    for (int[][] l : memo)
      for (int[] sl : l)
        Arrays.fill(sl, -1);
    return findPaths(m, n, maxMove, startRow, startColumn, memo);
  }
  
  public int findPaths(int m, int n, int moves, int i, int j, int[][][] memo) {
    if (i == m || j == n || i < 0 || j < 0)
      return 1;
    if (moves == 0)
      return 0;
    if (memo[i][j][moves] >= 0)
      return memo[i][j][moves];
    memo[i][j][moves] = 0;
    for (int[] dir : dirs) {
      memo[i][j][moves] = (memo[i][j][moves] + findPaths(m, n, moves - 1, i + dir[0], j + dir[1], memo)) % M;
    }
    return memo[i][j][moves];
  }
}