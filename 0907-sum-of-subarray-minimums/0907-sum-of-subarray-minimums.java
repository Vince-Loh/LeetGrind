class Solution {
  public int sumSubarrayMins(int[] arr) {
    int mod = (int)1e9 + 7;
    int n = arr.length;
    int[] left = new int[n], right = new int[n];
    Stack<Integer> stack = new Stack<>();
    
    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
        stack.pop();
      }
      left[i] = stack.isEmpty() ? -1 : stack.peek();
      stack.push(i);
    }
    stack.clear();
    for (int i = n - 1; i >= 0; i--) {
      while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
        stack.pop();
      }
      right[i] = stack.isEmpty() ? n : stack.peek();
      stack.push(i);
    }
    long res = 0;
    for (int i = 0; i < n; i++) {
      res = (res + (long)arr[i] * (i - left[i]) * (right[i] - i)) % mod;
    }
    return (int)res;
  }
}