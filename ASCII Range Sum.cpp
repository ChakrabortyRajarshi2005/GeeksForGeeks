ASCII Range Sum
Difficulty: MediumAccuracy: 52.59%Submissions: 11K+Points: 4
Given a string s consisting of lowercase English letters, for every character whose first and last occurrences are at different positions, calculate the sum of ASCII values of characters strictly between its first and last occurrence.
Return all such non-zero sums (order does not matter).

Examples:

Input: s = "abacab"
Output: [293, 294]
Explanation: characters 'a' and 'b' appear more than once:
'a' : between positions 1 and 5 → characters are b, a, c and ascii sum is 98 + 97 + 99 = 294.
'b' : between positions 2 and 6 → characters are a, c, a and ascii sum is 97 + 99 + 97 = 293.
Input: s = "acdac"
Output: [197, 199]
Explanation: characters 'a' and 'c' appear more than once:
'a' : between positions 1 and 4 → characters are c, d and ascii sum is 99 + 100 = 199.
'c' : between positions 2 and 5 → characters are d, a and ascii sum is 100 + 97 = 197.
Constraints:
1 ≤ s.size() ≤ 105
class Solution {
    public ArrayList<Integer> asciirange(String s) {
        ArrayList<Integer> result = new ArrayList<>();
        int[] first = new int[26];
        int[] last = new int[26];
        int n = s.length();

        // Initialize all indices to -1
        for (int i = 0; i < 26; i++) {
            first[i] = -1;
            last[i] = -1;
        }

        // Track first and last
        // occurrence of each character
        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            if (first[idx] == -1) {
                first[idx] = i;
            } else {
                last[idx] = i;
            }
        }

        // Compute ASCII sums
        // between first and last occurrence
        for (int i = 0; i < 26; i++) {
            if (first[i] != -1 && last[i] != -1) {
                int sum = 0;
                for (int j = first[i] + 1; j < last[i]; j++) {
                    sum += (int)s.charAt(j);
                }
                if (sum != 0) {
                    result.add(sum);
                }
            }
        }

        return result;
    }
}
