Generate all binary strings
Difficulty: MediumAccuracy: 63.9%Submissions: 38K+Points: 4Average Time: 20m
Given an integer n. You need to generate all the binary strings of n characters representing bits.

Note: Return the strings in  ascending order.

Examples:

Input: n = 2
Output: [00, 01, 10, 11]
Explanation: As each position can be either 0 or 1, the total possible combinations are 4.
Input: n = 3
Output: [000, 001, 010, 011, 100, 101, 110, 111]
Explanation: As each position can be either 0 or 1, the total possible combinations are 8.
Constraints:
1 ≤ n ≤ 20
class Solution {
    public void binstrRec(char[] s, int i, ArrayList<String> res) {
        int n = s.length;
        if (i == n) {
            res.add(new String(s));
            return;
        }
        s[i] = '0';
        binstrRec(s, i + 1, res);
        s[i] = '1';
        binstrRec(s, i + 1, res);
    }

    public ArrayList<String> binstr(int n) {
        char[] s = new char[n];
        Arrays.fill(s, '0');
        ArrayList<String> res = new ArrayList<>();
        binstrRec(s, 0, res);
        return res;
    }
}
