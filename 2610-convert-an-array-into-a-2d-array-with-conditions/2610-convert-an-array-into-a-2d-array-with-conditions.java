class Solution {
   public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        
        for (int num : nums) {
            int freq = count.getOrDefault(num, 0);
            count.put(num, freq + 1);
            
            if (freq == result.size()) {
                result.add(new ArrayList<>());
            }
            
            result.get(freq).add(num);
        }
        
        return result;
    }
}