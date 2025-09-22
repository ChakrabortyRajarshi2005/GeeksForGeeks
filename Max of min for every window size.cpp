Max of min for every window size
Difficulty: HardAccuracy: 42.9%Submissions: 75K+Points: 8Average Time: 45m
You are given an integer array arr[], the task is to find the maximum of minimum values for every window size k where 1≤ k ≤ arr.size().

For each window size k, consider all contiguous subarrays of length k, determine the minimum element in each subarray, and then take the maximum among all these minimums.

Return the results as an array, where the element at index i represents the answer for window size i+1.

Examples :

Input: arr[] = [10, 20, 30, 50, 10, 70, 30]
Output: [70, 30, 20, 10, 10, 10, 10] 
Explanation: 
Window size 1: minimums are [10, 20, 30, 50, 10, 70, 30], maximum of minimums is 70.
Window size 2: minimums are [10, 20, 30, 10, 10, 30], maximum of minimums is 30.
Window size 3: minimums are [10, 20, 10, 10, 10], maximum of minimums is 20.
Window size 4–7: minimums are [10, 10, 10, 10], maximum of minimums is 10.
Input: arr[] = [10, 20, 30]
Output: [30, 20, 10]
Explanation: 
Window size 1: minimums of  [10], [20], [30], maximum of minimums is 30.
Window size 2: minimums of [10, 20], [20,30], maximum of minimums is 20.
Window size 3: minimums of [10,20,30], maximum of minimums is 10.
Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 106
class Solution {
  public:
    vector<int> maxOfMins(vector<int>& arr) {
        int n = arr.size();
        vector<int> res(n), len(n + 1, 0);
        stack<int> s;

        // find window sizes for each element
        for (int i = 0; i < n; i++) {
            while (!s.empty() && arr[s.top()] >= arr[i]) {
                int top = s.top();
                s.pop();
                int left = s.empty() ? -1 : s.top();
                int right = i;
                int window_size = right - left - 1;
                len[window_size] = max(len[window_size], arr[top]);
            }
            s.push(i);
        }

        // process remaining elements in stack
        while (!s.empty()) {
            int top = s.top();
            s.pop();
            int left = s.empty() ? -1 : s.top();
            int right = n;
            int window_size = right - left - 1;
            len[window_size] = max(len[window_size], arr[top]);
        }

        for (int i = 1; i <= n; i++) {
            res[i - 1] = len[i];
        }

        for (int i = n - 2; i >= 0; i--) {
            res[i] = max(res[i], res[i + 1]);
        }

        return res;
    }
};
