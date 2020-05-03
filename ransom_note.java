class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        Map<Character, Integer> ransFreq = new HashMap<>();
        // count frequencies of characters
        for (Character c: ransomNote.toCharArray()) {
            ransFreq.put(c, ransFreq.getOrDefault(c, 0) + 1);
        }
        // subtract each character found in magazine from frequency hash map 
        for (Character c: magazine.toCharArray()) {
            if (ransFreq.containsKey(c)) {
                ransFreq.put(c, ransFreq.get(c) - 1);
            }
        }
        
        // check if all elements are at least less than zero.
        boolean allLessZero = true;
        for (Map.Entry<Character, Integer> entry: ransFreq.entrySet()) {
            if (entry.getValue() > 0) {
                allLessZero = false;
            }
        }
        return allLessZero;
    }
}
