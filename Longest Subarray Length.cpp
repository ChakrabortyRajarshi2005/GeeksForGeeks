Longest Subarray Length
Difficulty: MediumAccuracy: 45.14%Submissions: 20K+Points: 4
You are given an array of integers arr[]. Your task is to find the length of the longest subarray such that all the elements of the subarray are smaller than or equal to the length of the subarray.

Examples:

Input: arr[] = [1, 2, 3]
Output: 3
Explanation: The longest subarray is the entire array itself, which has a length of 3. All elements in the subarray are less than or equal to 3.
Input: arr[] = [6, 4, 2, 5]
Output: 0
Explanation: There is no subarray where all elements are less than or equal to the length of the subarray. The longest subarray is empty, which has a length of 0.
Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 109
class Solution {
  public:
    int longestSubarray(vector<int>& arr) {
        int n = arr.size();

        vector<int> nextGreater(n, n);
        vector<int> prevGreater(n, -1);

        stack<int> st;

        // Find Next Greater Element to the Right
        for (int i = 0; i < n; i++) {
            while (!st.empty() && arr[st.top()] < arr[i]) {
                nextGreater[st.top()] = i;
                st.pop();
            }
            st.push(i);
        }

        // Clear stack for next pass
        while (!st.empty())
            st.pop();

        // Find Next Greater Element to the Left
        for (int i = n - 1; i >= 0; i--) {
            while (!st.empty() && arr[st.top()] < arr[i]) {
                prevGreater[st.top()] = i;
                st.pop();
            }
            st.push(i);
        }

        // Find the maximum valid subarray length
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            int windowSize = nextGreater[i] - prevGreater[i] - 1;
            if (windowSize >= arr[i]) {
                maxLength = max(maxLength, windowSize);
            }
        }

        return maxLength;
    }
};
