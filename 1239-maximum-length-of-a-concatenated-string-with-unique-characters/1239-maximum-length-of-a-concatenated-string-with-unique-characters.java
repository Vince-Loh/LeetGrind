class Solution {
  int result = 0;

  public int maxLength(List<String> arr) {
    if (arr == null || arr.size() == 0) {
      return 0;
    }
    dfs(arr, "", 0);
    return result;
  }

  private void dfs(List<String> arr, String path, int idx) {
    boolean isUnique = isUniqueChars(path);
    if (isUnique) {
      result = Math.max(result, path.length());
    }
    if (idx == arr.size() || !isUnique) {
      return;
    }
    for (int i = idx; i < arr.size(); i++) {
      dfs(arr, path + arr.get(i), i + 1);
    }
  }

  private boolean isUniqueChars(String s) {
    int[] count = new int[26];
    for (char c : s.toCharArray()) {
      if (count[c - 'a']++ > 0) {
        return false;
      }
    }
    return true;
  }
}