class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s1.length() > s2.length()) return false;
        
        int[] s1Hash = new int[26];
        int[] s2Hash = new int[26];
        
        int windowSize = s1.length();
        
        for (int i = 0; i < s1.length(); i++) {
            s1Hash[s1.charAt(i) - 'a'] += 1;
        }
        
        for (int idx = 0; idx < s2.length(); idx++) {
            s2Hash[s2.charAt(idx) - 'a'] += 1;
            if (idx >= windowSize) {
                s2Hash[s2.charAt(idx - windowSize) - 'a'] -= 1;
            }
            
            if (Arrays.equals(s1Hash, s2Hash)) {
                return true;
            }
        }
        return false;
    }
}
