Divisible by 13
Difficulty: MediumAccuracy: 50.24%Submissions: 19K+Points: 4
Given a number represented as a string s (which may be very large), check whether it is divisible by 13 or not.

Examples:

Input : s = "2911285"
Output : true
Explanation: 2911285 / 13 = 223945, which is a whole number with no remainder.
Input : s = "27"
Output : false
Explanation: 27 / 13 ≈ 2.0769..., which is not a whole number (there is a remainder).
Constraints:

class Solution {
    public boolean divby13(String s) {
        // Stores running remainder
        int rem = 0;

        // Process each digit and compute
        // remainder modulo 13
        for (int i = 0; i < s.length(); i++) {
            rem = (rem * 10 + (s.charAt(i) - '0')) % 13;
        }

        // Final check: if remainder is 0, number
        // is divisible by 13
        return rem == 0;
    }
}
