Longest Substring with K Uniques
Difficulty: MediumAccuracy: 34.65%Submissions: 208K+Points: 4
You are given a string s consisting only lowercase alphabets and an integer k. Your task is to find the length of the longest substring that contains exactly k distinct characters.

Note : If no such substring exists, return -1. 

Examples:

Input: s = "aabacbebebe", k = 3
Output: 7
Explanation: The longest substring with exactly 3 distinct characters is "cbebebe", which includes 'c', 'b', and 'e'.
Input: s = "aaaa", k = 2
Output: -1
Explanation: There's no substring with 2 distinct characters.
Input: s = "aabaaab", k = 2
Output: 7
Explanation: The entire string "aabaaab" has exactly 2 unique characters 'a' and 'b', making it the longest valid substring.
Constraints:
1 ≤ s.size() ≤ 105
1 ≤ k ≤ 26


class Solution {
  public:
    int longestKSubstr(string &s, int k) {
        int n = s.size();
        int i = 0, j = 0;
        int cnt = 0;
        int maxi = -1;
        vector<int> fre(26, 0);

        // cnt represents the number of unique characters in the current window

        while (j < n) {

            // include s[j] into the window
            fre[s[j] - 'a']++;

            // it is the first occurrence of this character in the window
            if (fre[s[j] - 'a'] == 1)
                cnt++;

            // shrink the window if the number of unique character is more than k
            while (cnt > k) {
                fre[s[i] - 'a']--;

                // one unique character removed
                if (fre[s[i] - 'a'] == 0)
                    cnt--;
                i++;
            }

            // we have exactly k unique characters
            if (cnt == k) {
                maxi = max(maxi, j - i + 1);
            }

            j++;
        }

        return maxi;
    }
};
