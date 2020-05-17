class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int windowSize = p.length();
        
        Map<Character, Integer> expected = new HashMap<>();
        Map<Character, Integer> actual = new HashMap<>();
        
        List<Integer> res = new LinkedList<>();
        buildMap(expected, p);
        
        for (int i = 0; i < s.length() - windowSize + 1; i++) {
            String sub = s.substring(i, i + windowSize);
            buildMap(actual, sub);
            if (expected.equals(actual)) {
                res.add(i);
            } 
        }
        return res;
    }
    
    private void buildMap(Map<Character, Integer> map, String s) {
        map.clear();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
    }
}
