Optimal binary search tree
Difficulty: HardAccuracy: 50.02%Submissions: 17K+Points: 8
You are given a set of distinct keys in sorted order, which is represent by keys[]. Each key ki represents a data record that is accessed during a seach operation. For all the keys, you are also given a frequency array freq[], which denotes how many times key ki is searched for.
The cost of accessing a key in a binary search tree is calculated by multiplying its access frequency by the level at which it appears in the tree. Therefore different arrangements of keys in the BST gives different total search costs.

Your task is to calculate the minimum total search cost required to construct a binary search tree containing all the keys.

Note: Consider the root of the BST is at level 1.

Examples:

Input: keys[] = [10, 12], freq[] = [34, 50]
Output: 118
Explaination: There can be following two possible BSTs
                                
The cost of tree I is 34*1 + 50*2 = 134
The cost of tree II is 50*1 + 34*2 = 118
Input: keys[] = [10, 12, 20], freq[] = [34, 8, 50]
Output: 142
Explaination: There can be many possible BSTs
 
Among all possible BSTs, 
cost of the 5th BST is minimum.  
Cost of this BST is 1*50 + 2*34 + 3*8 = 142
Constraints:
1 ≤ keys.size() = freq.size() ≤ 100
1 ≤ keys[i], freq[i] ≤ 104




class Solution {
    public int sum(int freq[], int i, int j) {
        int s = 0;
        for (int k = i; k <= j; k++) s += freq[k];
        return s;
    }

    public int minCost(int[] keys, int[] freq) {
        int n = keys.length;
        int dp[][] = new int[n][n];

        for (int i = 0; i < n; i++) dp[i][i] = freq[i];

        for (int l = 2; l <= n; l++) {
            for (int i = 0; i <= n - l; i++) {
                int j = i + l - 1;
                dp[i][j] = Integer.MAX_VALUE;
                int fsum = sum(freq, i, j);

                for (int r = i; r <= j; r++) {
                    int c = ((r > i) ? dp[i][r - 1] : 0) +
                            ((r < j) ? dp[r + 1][j] : 0) + fsum;

                    if (c < dp[i][j]) dp[i][j] = c;
                }
            }
        }

        return dp[0][n - 1];
    }
}
