Expression Add Operators
Difficulty: HardAccuracy: 61.49%Submissions: 29K+Points: 8Average Time: 40m
Given a string s that contains only digits (0-9) and an integer target, return all possible strings by inserting the binary operator ' + ', ' - ', and/or ' * ' between the digits of s such that the resultant expression evaluates to the target value.

Note:

Operands in the returned expressions should not contain leading zeros. For example, 2 + 03 is not allowed whereas 20 + 3 is fine.
It is allowed to not insert any of the operators.
Driver code will print the final list of strings in lexicographically smallest order.
Examples:

Input: s = "124", target = 9
Output: ["1+2*4"]
Explanation: The valid expression that evaluate to 9 is 1 + 2 * 4
Input: s = "125", target = 7
Output: ["1*2+5", "12-5"]
Explanation: The two valid expressions that evaluate to 7 are 1 * 2 + 5 and 12 - 5.
Input: s = "12", target = 12
Output: ["12"] 
Explanation: s itself matches the target. No other expressions are possible.
Input: s = "987612", target = 200
Output: []
Explanation: There are no expressions that can be created from "987612" to evaluate to 200.
Constraints:
1 ≤ s.size() ≤ 9
s consists of only digits (0-9).
-231 ≤ target ≤ 231-1


class Solution {
    public void buildExpr(ArrayList<String> res, String expr, String digits, int target,
                          int idx, int eval, int last) {
        if (idx == digits.length()) {
            if (eval == target) res.add(expr);
            return;
        }

        for (int i = idx; i < digits.length(); i++) {
            if (i != idx && digits.charAt(idx) == '0') break;

            String part = digits.substring(idx, i + 1);
            int num = Integer.parseInt(part);

            if (idx == 0) {
                buildExpr(res, part, digits, target, i + 1, num, num);
            } else {
                buildExpr(res, expr + "+" + part, digits, target, i + 1, eval + num,
                          num);
                buildExpr(res, expr + "-" + part, digits, target, i + 1, eval - num,
                          -num);
                buildExpr(res, expr + "*" + part, digits, target, i + 1,
                          eval - last + last * num, last * num);
            }
        }
    }

    public ArrayList<String> findExpr(String s, int target) {
        ArrayList<String> res = new ArrayList<>();
        buildExpr(res, "", s, target, 0, 0, 0);
        return res;
    }
}
