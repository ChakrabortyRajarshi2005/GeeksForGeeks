Top K Frequent in Array
Difficulty: MediumAccuracy: 40.23%Submissions: 106K+Points: 4Average Time: 30m
Given a non-empty integer array arr[]. Your task is to find and return the top k elements which have the highest frequency in the array.

Note: If two numbers have the same frequency, the larger number should be given the higher priority.

Examples:

Input: arr[] = [3, 1, 4, 4, 5, 2, 6, 1], k = 2
Output: [4, 1]
Explanation: Frequency of 4 is 2 and frequency of 1 is 2, these two have the maximum frequency and 4 is larger than 1.
Input: arr[] = [7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9], k = 4
Output: [5, 11, 7, 10]
Explanation: Frequency of 5 is 3, frequency of 11 is 2, frequency of 7 is 2, frequency of 10 is 1.
Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 105
1 ≤ k ≤ no. of distinct elements

class Solution {
  public:
    vector<int> topKFreq(vector<int> &arr, int k) {
        unordered_map<int, int> freq;
        for (int num : arr) {
            freq[num]++;
        }

        int maxFreq = 0;
        for (pair<int, int> entry : freq) {
            maxFreq = max(maxFreq, entry.second);
        }

        vector<vector<int>> buckets(maxFreq + 1);
        for (pair<int, int> entry : freq) {
            buckets[entry.second].push_back(entry.first);
        }

        vector<int> res;
        for (int i = maxFreq; i >= 1; --i) {
            sort(buckets[i].begin(), buckets[i].end(), greater<int>());
            for (int num : buckets[i]) {
                res.push_back(num);
                if (res.size() == k) {
                    return res;
                }
            }
        }

        return res;
    }
};
