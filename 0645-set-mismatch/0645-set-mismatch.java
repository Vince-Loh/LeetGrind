class Solution {
  public int[] findErrorNums(int[] nums) {
    int[] freq = new int[nums.length + 1];
    int dup = -1, missing = -1;
    for (int num : nums) {
      freq[num]++;
    }
    for (int i = 1; i < freq.length; i++) {
      if (freq[i] == 0) {
        missing = i;
      } else if (freq[i] == 2) {
        dup = i;
      }
    }
    return new int[]{dup, missing};
  }
}