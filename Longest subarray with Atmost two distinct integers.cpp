Longest subarray with Atmost two distinct integers
Difficulty: MediumAccuracy: 47.98%Submissions: 121K+Points: 4Average Time: 30m
Given an array arr[] consisting of positive integers, your task is to find the length of the longest subarray that contains at most two distinct integers.

Examples:

Input: arr[] = [2, 1, 2]
Output: 3
Explanation: The entire array [2, 1, 2] contains at most two distinct integers (2 and 1). Hence, the length of the longest subarray is 3.
Input: arr[] = [3, 1, 2, 2, 2, 2]
Output: 5
Explanation: The longest subarray containing at most two distinct integers is [1, 2, 2, 2, 2], which has a length of 5.
Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 105

Expected Complexities
Topic Tags
Related Article
Solution {
  public:
    int totalElements(vector<int> &arr) {
        // code here
         unordered_map<int, int> count;
    int start = 0, maxLen = 0;

    for (int end = 0; end < arr.size(); ++end) {
        count[arr[end]]++;

        while (count.size() > 2) {
            count[arr[start]]--;
            if (count[arr[start]] == 0)
                count.erase(arr[start]);
            start++;
        }

        maxLen = max(maxLen, end - start + 1);
    }

    return maxLen;
    }
};
