All Unique Permutations of an array
Difficulty: MediumAccuracy: 52.85%Submissions: 49K+Points: 4Average Time: 15m
Given an array arr[] that may contain duplicates. Find all possible distinct permutations of the array in sorted order.
Note: A sequence A is greater than sequence B if there is an index i for which Aj = Bj for all j<i and Ai > Bi.

Examples:

Input: arr[] = [1, 3, 3]
Output: [[1, 3, 3], [3, 1, 3], [3, 3, 1]]
Explanation: These are the only possible distinct permutations for the given array.
Input: arr[] = [2, 3]
Output: [[2, 3], [3, 2]]
Explanation: These are the only possible distinct permutations for the given array.
Constraints:
1 ≤ arr.size() ≤ 9

class Solution {
  public:
    void backtrack(vector<int>& arr, vector<bool>& visited, vector<int>& curr,
                   vector<vector<int>>& result) {
        if (curr.size() == arr.size()) {
            result.push_back(curr);
            return;
        }

        for (int i = 0; i < arr.size(); i++) {
            if (visited[i])
                continue;

            if (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1])
                continue;

            visited[i] = true;
            curr.push_back(arr[i]);

            backtrack(arr, visited, curr, result);

            curr.pop_back();
            visited[i] = false;
        }
    }

    vector<vector<int>> uniquePerms(vector<int>& arr) {
        sort(arr.begin(), arr.end());
        vector<vector<int>> result;
        vector<int> curr;
        vector<bool> visited(arr.size(), false);
        backtrack(arr, visited, curr, result);
        return result;
    }
};
