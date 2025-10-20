Number of BST From Array
Difficulty: HardAccuracy: 78.62%Submissions: 6K+Points: 8
You are given an integer array arr[] containing distinct elements.

Your task is to return an array where the ith element denotes the number of unique BSTs formed when arr[i] is chosen as the root.

Examples :

Input: arr[] = [2, 1, 3]
Output: [1, 2, 2]
Explanation: 
4
Input: arr[] = [2, 1]
Ouput: [1, 1]
Constraints:
1 ≤ arr.size() ≤ 6
1 ≤ arr[i] ≤ 15


class Solution {
  public:
    vector<int> computeFact(int num) {
        vector<int> fact(num + 1);
        fact[0] = 1;
        for (int i = 1; i <= num; i++)
            fact[i] = fact[i - 1] * i;
        return fact;
    }

    int catalan(int n, vector<int>& fact) {
        return fact[2 * n] / (fact[n] * fact[n + 1]);
    }

    vector<int> countBSTs(vector<int>& arr) {
        int n = arr.size();
        vector<vector<int>> sorted;

        for (int i = 0; i < n; i++)
            sorted.push_back({arr[i], i});
        sort(sorted.begin(), sorted.end());

        vector<int> fact = computeFact(2 * n);
        vector<int> numBSTs(n);

        for (int i = 0; i < n; i++) {
            int j = sorted[i][1];
            numBSTs[j] = catalan(i, fact) * catalan(n - i - 1, fact);
        }

        return numBSTs;
    }
};
class Solution {
  public:
    vector<int> computeFact(int num) {
        vector<int> fact(num + 1);
        fact[0] = 1;
        for (int i = 1; i <= num; i++)
            fact[i] = fact[i - 1] * i;
        return fact;
    }

    int catalan(int n, vector<int>& fact) {
        return fact[2 * n] / (fact[n] * fact[n + 1]);
    }

    vector<int> countBSTs(vector<int>& arr) {
        int n = arr.size();
        vector<vector<int>> sorted;

        for (int i = 0; i < n; i++)
            sorted.push_back({arr[i], i});
        sort(sorted.begin(), sorted.end());

        vector<int> fact = computeFact(2 * n);
        vector<int> numBSTs(n);

        for (int i = 0; i < n; i++) {
            int j = sorted[i][1];
            numBSTs[j] = catalan(i, fact) * catalan(n - i - 1, fact);
        }

        return numBSTs;
    }
};
