Maximum sum of elements not part of LIS
Difficulty: MediumAccuracy: 48.67%Submissions: 19K+Points: 4
Given an array arr[] of positive integers, your task is to find the maximum possible sum of all elements that are not part of the Longest Increasing Subsequence (LIS).

Examples:

Input: arr[] = [4, 6, 1, 2, 3, 8]
Output: 10
Explanation: The elements which are not in LIS is 4 and 6.
Input: arr[] = [5, 4, 3, 2, 1]
Output: 14
Explanation: The elements which are not in LIS is 5, 4, 3 and 2.
Constraints:
1 ≤ arr.size() ≤ 103
1 ≤ arr[i] ≤ 105



class Solution {
  public:
    map<int, vector<int>> mp;

    // insert a value into the map while
    // maintaining optimal LIS information
    void insert(int val) {
        auto it = mp.lower_bound(val);

        int len = 1;
        int sum = val;

        // find the best LIS ending at a value less than current
        if (it != mp.begin()) {
            auto prev = it;
            --prev;
            len = prev->second[0] + 1;
            sum = prev->second[1] + val;
        }

        // remove all dominated entries (length <= current and key > val)
        vector<int> toerase;
        while (it != mp.end()) {
            if (it->second[0] > len)
                break;
            toerase.push_back(it->first);
            ++it;
        }

        for (int key : toerase) {
            mp.erase(key);
        }

        // store current value with LIS length and sum
        mp[val] = {len, sum};
    }

    int nonLisMaxSum(vector<int>& arr) {
        int n = arr.size();
        for (int i = 0; i < n; i++) {
            insert(arr[i]);
        }

        auto last = --mp.end();
        int totalSum = accumulate(arr.begin(), arr.end(), 0);
        int lisSum = last->second[1];

        return totalSum - lisSum;
    }
};
