Trail of ones
Difficulty: MediumAccuracy: 51.16%Submissions: 41K+Points: 4
Given an integer n, the task is to count the number of binary strings of length n that contains at least one pair of consecutive 1's.
Note: A binary string is a sequence made up of only 0's and 1's.

Examples:

Input: n = 2
Output: 1
Explanation: There are 4 strings of length 2, the strings are 00, 01, 10, and 11. Only the string 11 has consecutive 1's.
Input: n = 3
Output: 3
Explanation: There are 8 strings of length 3, the strings are 000, 001, 010, 011, 100, 101, 110 and 111. The strings with consecutive 1's are 011, 110 and 111.
Input: n = 5
Output: 19
Explanation: There are 19 strings having at least one pair of consecutive 1's.
Constraints:
2 ≤ n ≤ 30

class Solution {
    public int countConsec(int n) {
        int prev0 = 0, prev1 = 0;

        for (int i = n; i >= 1; i--) {
            // If previous bit is 0, we can place 0 or 1
            int curr0 = prev0 + prev1;

            // If previous bit is 1, placing another 1 creates a valid pair,
            // remaining bits can be anything: 2^(n - i)
            int curr1 = prev0 + (1 << (n - i));

            // Update for next iteration
            prev0 = curr0;
            prev1 = curr1;
        }

        // Start from position 1 with previous bit 0
        return prev0;
    }
}
