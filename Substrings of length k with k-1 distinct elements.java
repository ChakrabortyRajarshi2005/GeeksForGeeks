Substrings of length k with k-1 distinct elements
Difficulty: MediumAccuracy: 57.85%Submissions: 36K+Points: 4Average Time: 15m
Given a string s consisting only lowercase alphabets and an integer k. Find the count of all substrings of length k which have exactly k-1 distinct characters.

Examples:

Input: s = "abcc", k = 2
Output: 1
Explaination: Possible substring of length k = 2 are,
ab : 2 distinct characters
bc : 2 distinct characters
cc : 1 distinct characters
Only one valid substring so, count is equal to 1.
Input: "aabab", k = 3
Output: 3
Explaination: Possible substring of length k = 3 are, 
aab : 2 distinct charcters
aba : 2 distinct characters
bab : 2 distinct characters
All these substring are valid so, the total count is equal to 3.
Constrains:
1 ≤ s.size() ≤ 105
2 ≤ k ≤ 27

Expected Complexities

class Solution {
    public int substrCount(String s, int k) {
        // code here
        if (s == null || s.length() < k) return 0;

        Map<Character, Integer> freqMap = new HashMap<>();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            // Add current character to window
            char ch = s.charAt(i);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);

            // Remove character left to the window
            if (i >= k) {
                char left = s.charAt(i - k);
                freqMap.put(left, freqMap.get(left) - 1);
                if (freqMap.get(left) == 0) {
                    freqMap.remove(left);
                }
            }

            // Check only when window is full
            if (i >= k - 1) {
                if (freqMap.size() == k - 1) {
                    count++;
                }
            }
        }

        return count;
    }
}
