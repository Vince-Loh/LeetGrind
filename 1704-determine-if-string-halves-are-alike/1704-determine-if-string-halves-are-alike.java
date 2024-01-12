class Solution {
  public boolean halvesAreAlike(String s) {
    String vowels = "aeiouAEIOU";
    int a = 0, b = 0;
    int n = s.length();
    for (int i = 0; i < n / 2; i++) {
      if (vowels.indexOf(s.charAt(i)) != -1) {
        a++;
      }
      if (vowels.indexOf(s.charAt(i + n / 2)) != -1) {
        b++;
      }
    }
    return a == b;
  }
}