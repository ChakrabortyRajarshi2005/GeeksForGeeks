Maximum Non-Adjacent Nodes Sum
Difficulty: MediumAccuracy: 55.35%Submissions: 97K+Points: 4Average Time: 45m
Given the root of a binary tree with integer values. Your task is to select a subset of nodes such that the sum of their values is maximized, with the condition that no two selected nodes are directly connected that is, if a node is included in the subset, neither its parent nor its children can be included.

Examples:

Input: root = [11, 1, 2]

Output: 11
Explanation: The maximum sum is obtained by selecting the node 11.

Input: root = [1, 2, 3, 4, N, 5, 6]

Output: 16
Explanation: The maximum sum is obtained by selecting the nodes 1, 4, 5 and 6, which are not directly connected to each other. Their total sum is 16.  

Constraints:
1 ≤ number of nodes ≤ 104
1 ≤ node.data ≤ 105class Solution {
  public:
    vector<int> maxSumHelper(Node* root) {
        if (root == NULL)
            return {0, 0};

        vector<int> resLeft = maxSumHelper(root->left);
        vector<int> resRight = maxSumHelper(root->right);

        int include = root->data + resLeft[1] + resRight[1];
        int exclude = max(resLeft[0], resLeft[1]) + max(resRight[0], resRight[1]);
        return {include, exclude};
    }

    int getMaxSum(Node* root) {
        vector<int> res = maxSumHelper(root);

        return max(res[0], res[1]);
    }
};
