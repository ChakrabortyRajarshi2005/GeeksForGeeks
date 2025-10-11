Maximum path sum
Difficulty: MediumAccuracy: 42.92%Submissions: 112K+Points: 4Average Time: 45m
Given the root of a binary tree, your task is to find the maximum path sum. The path may start and end at any node in the tree.

Examples:

Input: root[] = [10, 2, 10, 20, 1, N, -25, N, N, N, N, 3, 4]
Output: 42
Explanation: Max path sum is represented using green colour nodes in the above binary tree.

Input: root[] = [-17, 11, 4, 20, -2, 10]
Output: 31
Explanation: Max path sum is represented using green colour nodes in the above binary tree.

Constraints:
1 ≤ number of nodes ≤ 103
-104 ≤ node->data ≤ 104class Solution {
  public:
    int findMaxSumRec(Node *root, int &res) {
        if (root == NULL)
            return 0;

        int l = max(0, findMaxSumRec(root->left, res));
        int r = max(0, findMaxSumRec(root->right, res));

        res = max(res, l + r + root->data);

        return root->data + max(l, r);
    }

    int findMaxSum(Node *root) {
        int res = root->data;
        findMaxSumRec(root, res);
        return res;
    }
};
