Largest number in one swap
Difficulty: EasyAccuracy: 48.67%Submissions: 18K+Points: 2
Given a string s, return the lexicographically largest string that can be obtained by swapping at most one pair of characters in s.

Examples:

Input: s = "768"
Output: "867"
Explanation: Swapping the 1st and 3rd characters(7 and 8 respectively), gives the lexicographically largest string.
Input: s = "333"
Output: "333"
Explanation: Performing any swaps gives the same result i.e "333".
Constraints:
1 ≤ |s| ≤ 105
'0' ≤ s[i] ≤ '9'
class Solution {
  public:
    string largestSwap(string &s) {
        char maxDigit = '0';
        int maxIndx = -1;
        int l = -1, r = -1;

        // Traverse from right to left
        for (int i = s.size() - 1; i >= 0; i--) {
            // Update maxDigit if current digit is larger
            if (s[i] > maxDigit) {
                maxDigit = s[i];
                maxIndx = i;
            }

            // Found a smaller digit before a larger one
            else if (s[i] < maxDigit) {
                l = i;
                r = maxIndx;
            }
        }

        // If no swap needed, return original
        if (l == -1)
            return s;

        // Perform swap
        swap(s[l], s[r]);

        return s;
    }
};
