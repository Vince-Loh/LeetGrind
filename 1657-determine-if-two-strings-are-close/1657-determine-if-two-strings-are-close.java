class Solution {
  public boolean closeStrings(String word1, String word2) {
    if (word1.length() != word2.length()) {
      return false;
    }

    int[] count1 = new int[26];
    int[] count2 = new int[26];
    int[] chars1 = new int[26];
    int[] chars2 = new int[26];

    for (int i = 0; i < word1.length(); i++) {
      count1[word1.charAt(i) - 'a']++;
      count2[word2.charAt(i) - 'a']++;
      chars1[word1.charAt(i) - 'a'] = 1;
      chars2[word2.charAt(i) - 'a'] = 1;
    }

    Arrays.sort(count1);
    Arrays.sort(count2);

    return Arrays.equals(count1, count2) && Arrays.equals(chars1, chars2);
  }
}