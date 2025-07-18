LCM Triplet
Difficulty: MediumAccuracy: 50.13%Submissions: 32K+Points: 4
Given a number n, find the maximum possible LCM that can be obtained by selecting three numbers less than or equal to n.
Note : LCM stands for Lowest Common Multiple.

Examples:.java

Input: n = 9
Output: 504
Explanation: 504 is the maximum LCM that can be attained by any triplet of numbers less than or equal 9. The triplet which has this LCM is {7, 8, 9}.
Input: n = 7
Output: 210
Explanation: 210 is the maximum LCM that can be attained by any triplet of numbers less than or equal 7. The triplet which has this LCM is {5, 6, 7}.
Constraints:
1 ≤ n ≤ 103


class Solution {
    int lcmTriplets(int n) {
        int ans;

        if (n < 3) {
            ans = n;
        }
        // If n is odd, the product of the top 3 numbers gives maximum LCM
        else if (n % 2 != 0) {
            ans = n * (n - 1) * (n - 2);
        }
        // If n is even and not divisible by 3, use n, n-1, n-3
        else if (n % 3 != 0) {
            ans = n * (n - 1) * (n - 3);
        }
        // If n is even and divisible by 3, use n-1, n-2, n-3
        else {
            ans = (n - 1) * (n - 2) * (n - 3);
        }

        return ans;
    }
}
