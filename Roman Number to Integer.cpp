Roman Number to Integer
Difficulty: EasyAccuracy: 43.31%Submissions: 199K+Points: 2Average Time: 20m
Given a string s in Roman number format, your task is to convert it to an integer. Various symbols and their values are given below.
Note: I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1000

Examples:

Input: s = "IX"
Output: 9
Explanation: IX is a Roman symbol which represents 10 – 1 = 9.
Input: s = "XL"
Output: 40
Explanation: XL is a Roman symbol which represents 50 – 10 = 40.
Input: s = "MCMIV"
Output: 1904
Explanation: M is 1000, CM is 1000 – 100 = 900, and IV is 4. So we have total as 1000 + 900 + 4 = 1904.
Constraints:
1 ≤ roman number ≤ 3999
s[i] belongs to [I, V, X, L, C, D, M]


class Solution {
    int value(char r) {
        if (r == 'I') return 1;
        if (r == 'V') return 5;
        if (r == 'X') return 10;
        if (r == 'L') return 50;
        if (r == 'C') return 100;
        if (r == 'D') return 500;
        if (r == 'M') return 1000;
        return -1;
    }

    // Finds decimal value of a given roman number
    public int romanToDecimal(String s) {
        // Initialize result
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            // Getting value of symbol s[i]
            int s1 = value(s.charAt(i));

            // Getting value of symbol s[i+1]
            if (i + 1 < s.length()) {
                int s2 = value(s.charAt(i + 1));

                // Comparing both values
                if (s1 >= s2) {
                    // Value of current symbol is greater
                    // or equalto the next symbol
                    res = res + s1;
                } else {
                    res = res + s2 - s1;
                    i++; // Value of current symbol is
                    // less than the next symbol
                }
            } else {
                res = res + s1;
            }
        }

        return res;
    }
}
