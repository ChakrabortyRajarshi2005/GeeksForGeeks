Decode the string
Difficulty: MediumAccuracy: 44.28%Submissions: 66K+Points: 4Average Time: 10m
Given an encoded string s, decode it by expanding the pattern k[substring], where the substring inside brackets is written k times. k is guaranteed to be a positive integer, and encodedString contains only lowercase english alphabets. Return the final decoded string.

Note: The test cases are generated so that the length of the output string will never exceed 105 .

Examples:

Input: s = "3[b2[ca]]"
Output: "bcacabcacabcaca"
Explanation:
Inner substring “2[ca]” breakdown into “caca”.
Now, new string becomes “3[bcaca]”
Similarly “3[bcaca]” becomes “bcacabcacabcaca” which is final result.
Input: s = "3[ab]"
Output: "ababab"
Explanation: The substring "ab" is repeated 3 times giving "ababab".
Constraints:
1 ≤ |s| ≤ 105 
1 ≤ k ≤ 100



class Solution {
  public:
    string decodedString(string &s) {
        stack<char> st;

        // Traverse the input string
        for (int i = 0; i < s.length(); i++) {
            // Push characters into the stack until ']' is encountered
            if (s[i] != ']') {
                st.push(s[i]);
            }
            // Decode when ']' is found
            else {
                string temp;

                // Pop characters until '[' is found
                while (!st.empty() && st.top() != '[') {
                    temp.push_back(st.top());
                    st.pop();
                }
                reverse(temp.begin(), temp.end()); // Reverse extracted string
                // Remove '[' from the stack
                st.pop();

                string num;
                // Extract the number (repetition count) from the stack
                while (!st.empty() && isdigit(st.top())) {
                    num = st.top() + num;
                    st.pop();
                }

                // Convert extracted number to integer
                int number = stoi(num);
                string repeat;

                // Repeat the extracted string 'number' times
                for (int j = 0; j < number; j++)
                    repeat.append(temp);

                // Push the expanded string back onto the stack
                for (char c : repeat)
                    st.push(c);
            }
        }

        string res;
        // Pop all characters from stack to form the final result
        while (!st.empty()) {
            res.push_back(st.top());
            st.pop();
        }

        // Reverse to get the correct order
        reverse(res.begin(), res.end());
        return res;
    }
};
