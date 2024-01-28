class Solution {
  public int numSubmatrixSumTarget(int[][] matrix, int target) {
    int m = matrix.length, n = matrix[0].length;
    int[][] ps = new int[m+1][n+1];
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        ps[i][j] = ps[i-1][j] + ps[i][j-1] - ps[i-1][j-1] + matrix[i-1][j-1];
      }
    }
    int count = 0;
    for (int r1 = 1; r1 <= m; r1++) {
      for (int r2 = r1; r2 <= m; r2++) {
        Map<Integer, Integer> counter = new HashMap<>();
        counter.put(0, 1);
        for (int c = 1; c <= n; c++) {
          int currSum = ps[r2][c] - ps[r1-1][c];
          count += counter.getOrDefault(currSum - target, 0);
          counter.put(currSum, counter.getOrDefault(currSum, 0) + 1);
        }
      }
    }
    return count;
  }
}