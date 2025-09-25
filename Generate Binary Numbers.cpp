Generate Binary Numbers
Difficulty: EasyAccuracy: 67.48%Submissions: 62K+Points: 2
Given a number n. The task is to generate all binary numbers with decimal values from 1 to n.

Examples:

Input: n = 4
Output: ["1", "10", "11", "100"]
Explanation: Binary numbers from 1 to 4 are 1, 10, 11 and 100.
Input: n = 6
Output: ["1", "10", "11", "100", "101", "110"]
Explanation: Binary numbers from 1 to 6 are 1, 10, 11, 100, 101 and 110.
Constraints:
1 ≤ n ≤ 106


class Solution {
  public:
    vector<string> generateBinary(int n) {
        vector<string> res;
        queue<string> q;

        // Enqueue the first binary number
        q.push("1");

        // This loops is like BFS of a tree with "1" as root
        // "0" as left child and "1" as right child and so on
        while (n--) {

            string s1 = q.front();
            q.pop();
            res.push_back(s1);

            string s2 = s1;

            // Append "0" to s2 and enqueue it.
            q.push(s1.append("0"));

            // Append "1" to s2 and enqueue it.
            q.push(s2.append("1"));
        }
        return res;
    }
}
