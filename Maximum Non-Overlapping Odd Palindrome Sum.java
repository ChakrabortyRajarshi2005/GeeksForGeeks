Maximum Non-Overlapping Odd Palindrome Sum
Difficulty: HardAccuracy: 47.23%Submissions: 12K+Points: 8Average Time: 40m
Given a string s consisting of lowercase English letters, find the maximum possible sum of the lengths of any two non-empty and non-overlapping palindromic substrings of odd length.

Formally, choose any two substrings s[i...j] and s[k...l] such that 1 ≤ i ≤ j < k ≤ l ≤ s.size(), both substrings are palindromes of odd length, and they do not overlap. Return the maximum sum of their lengths.

Note: A palindrome is a string that reads the same forward and backward. A substring is a contiguous sequence of characters within the string.

Examples:

Input: s = "xyabacbcz"
Output: 6
Explanation: "aba" and "cbc" are non-overlapping odd-length palindromes. Their lengths are 3 and 3 which gives the sum as 6.
Input: s = "gfgforgeeks"
Output: 4
Explanation: "gfg" and "g" are non-overlapping odd-length palindromes. Their lengths are 3 and 1 which gives the sum as 4.
Constraints:
2 ≤ s.size() ≤ 105

Expected Complexities
Topic Tags
Related Articles
If you are facing any issue on this page. Please let us know.
Java (21)



}


 

Custom Input


class manacher {
    // stores radius of palindromes centered at each
    // position in ms
    int[] p;
    String ms;

    // Build modified string and run Manacher
    manacher(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append('@');
        for (char c : s.toCharArray()) {
            sb.append('#').append(c);
        }
        sb.append("#$");
        ms = sb.toString();
        p = new int[ms.length()];
        runManacher();
    }

    // Run Manacher's algorithm to fill the p[] array
    void runManacher() {
        int n = ms.length();
        int l = 0, r = 0;

        for (int i = 1; i < n - 1; i++) {

            // If inside current right boundary, use previously
            // computed value by mirroring
            if (r + l - i < n && r + l - i >= 0) {
                p[i] = Math.max(0, Math.min(r - i, p[r + l - i]));
            }

            // Expand the palindrome centered at i
            while (i + p[i] + 1 < n && i - p[i] - 1 >= 0 &&
                   ms.charAt(i + 1 + p[i]) == ms.charAt(i - 1 - p[i])) {
                p[i]++;
            }

            // Update the current palindrome boundary
            // if this one extends further
            if (i + p[i] > r) {
                l = i - p[i];
                r = i + p[i];
            }
        }
    }

    // Returns the radius of the longest palindrome
    // centered at index `cen`
    int getLongest(int cen, int odd) {
        int pos = 2 * cen + 2 + (odd == 0 ? 1 : 0);
        return p[pos];
    }

    // Check if s[l...r] is a palindrome of expected type
    boolean check(int l, int r) {
        int len = r - l + 1;
        int mid = (l + r) / 2;
        return len <= getLongest(mid, len % 2);
    }
}

class Solution {
    public int maxSum(String s) {
        int n = s.length();
        int[] leftMark = new int[n];
        int[] rightMark = new int[n];
        Arrays.fill(leftMark, 1);
        Arrays.fill(rightMark, 1);

        manacher mr = new manacher(s);

        // Store the max odd-length palindrome ending
        // at or before each index
        for (int i = 0; i < n; i++) {
            int val = mr.getLongest(i, 1);
            int li = i + val / 2;
            if (li < n) leftMark[li] = Math.max(leftMark[li], val);
        }

        // Spread max values backwards by reducing
        // length by 2 (odd length constraint)
        for (int i = n - 2; i >= 0; i--) {
            leftMark[i] = Math.max(leftMark[i], leftMark[i + 1] - 2);
        }

        // Make prefix max array
        for (int i = 1; i < n; i++) {
            leftMark[i] = Math.max(leftMark[i], leftMark[i - 1]);
        }

        // Store the max odd-length palindrome starting
        // at or after each index
        for (int i = n - 1; i >= 0; i--) {
            int val = mr.getLongest(i, 1);
            int ri = i - val / 2;
            if (ri >= 0) rightMark[ri] = Math.max(rightMark[ri], val);
        }

        // Spread max values forward by reducing
        // length by 2
        for (int i = 1; i < n; i++) {
            rightMark[i] = Math.max(rightMark[i], rightMark[i - 1] - 2);
        }

        // Make suffix max array
        for (int i = n - 2; i >= 0; i--) {
            rightMark[i] = Math.max(rightMark[i], rightMark[i + 1]);
        }

        // Try every cut point and compute the best
        // non-overlapping sum
        int ans = 1;
        for (int i = 0; i + 1 < n; i++) {
            ans = Math.max(ans, leftMark[i] + rightMark[i + 1]);
        }

        return ans;
    }
}
