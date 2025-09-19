Min Add to Make Parentheses Valid
Difficulty: MediumAccuracy: 57.97%Submissions: 12K+Points: 4
You are given a string s consisting only of the characters '(' and ')'. Your task is to determine the minimum number of parentheses (either '(' or ')') that must be inserted at any positions to make the string s a valid parentheses string.

A parentheses string is considered valid if:

Every opening parenthesis '(' has a corresponding closing parenthesis ')'.
Every closing parenthesis ')' has a corresponding opening parenthesis '('.
Parentheses are properly nested.
Examples:

Input: s = "(()("
Output: 2
Explanation: There are two unmatched '(' at the end, so we need to add two ')' to make the string valid.
Input: s = ")))"
Output: 3
Explanation: Three '(' need to be added at the start to make the string valid.
Input: s = ")()()"
Output: 1 
Explanation: The very first ')' is unmatched, so we need to add one '(' at the beginning.
Constraints:
1 ≤ s.size() ≤ 105
s[i] ∈ { '(' , ')' }
class Solution {
  public:
    int minParentheses(string& s) {
        // number of unmatched '('
        int balance = 0;

        // number of unmatched ')'
        int unmatchedClosing = 0;

        for (char c : s) {

            // if current char is '(', increment balance
            if (c == '(') {
                balance++;
            }
            // if current char is ')', decrement balance
            else if (c == ')') {
                balance--;

                // if balance becomes negative, unmatched ')'
                if (balance < 0) {

                    // increment unmatched closing counter
                    unmatchedClosing++;

                    // reset balance
                    balance = 0;
                }
            }
        }

        // total additions = remaining '(' + unmatched ')'
        return balance + unmatchedClosing;
    }
};
