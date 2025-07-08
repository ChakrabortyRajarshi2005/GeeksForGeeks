Next element with greater frequency
Difficulty: MediumAccuracy: 60.4%Submissions: 20K+Points: 4
Given an array arr[] of integers, for each element, find the closest (distance wise) to its right that has a higher frequency than the current element.
If no such element exists, return -1 for that position.

Examples:

Input: arr[] = [2, 1, 1, 3, 2, 1]
Output: [1, -1, -1, 2, 1, -1]
Explanation: Frequencies: 1 → 3 times, 2 → 2 times, 3 → 1 time.
For arr[0] = 2, the next element 1 has a higher frequency → 1.
For arr[1] and arr[2], no element to the right has a higher frequency → -1.
For arr[3] = 3, the next element 2 has a higher frequency → 2.
For arr[4] = 2, the next element 1 has a higher frequency → 1.
For arr[5] = 1, no elements to the right → -1.
Input: arr[] = [5, 1, 5, 6, 6]
Output: [-1, 5, -1, -1, -1]
Explanation: Frequencies: 1 → 1 time, 5 → 2 times, 6 → 2 times.
For arr[0] and arr[2], no element to the right has a higher frequency → -1.
For arr[1] = 1, the next element 5 has a higher frequency → 5.
For arr[3] and arr[4], no element to the right has a higher frequency → -1.
Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 105

class Solution {
  public:
    vector<int> findGreater(vector<int>& arr) {
        int n = arr.size();
        map<int, int> freq;

        for (auto it : arr) {
            freq[it]++;
        }

        vector<int> res(n, -1);
        stack<int> s;

        for (int i = 0; i < n; i++) {

            // While current frequency is
            // greater than frequency at stack top
            while (!s.empty() && freq[arr[i]] > freq[arr[s.top()]]) {
                res[s.top()] = arr[i];
                s.pop();
            }
            s.push(i);
        }

        return res;
    }
};
