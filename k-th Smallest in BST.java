k-th Smallest in BST
Difficulty: MediumAccuracy: 43.53%Submissions: 152K+Points: 4Average Time: 40m
Given the root of a BST and an integer k, the task is to find the kth smallest element in the BST. If there is no kth smallest element present then return -1.

Examples:

Input: root = [20, 8, 22, 4, 12, N, N, N, N, 10, 14], k = 3
    
Output: 10
Explanation: 10 is the 3rd smallest element in the BST.
Input: root = [2, 1, 3], k = 5
    
Output: -1
Explanation: There is no 5th smallest element in the BST as the size of BST is 3.
Constraints:
1 ≤ number of nodes, k ≤ 104
1 ≤ node->data ≤ 104

/*
class Node {
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    public int kthSmallestRecur(Node root, int[] cnt, int k) {
        if (root == null) return -1;

        int left = kthSmallestRecur(root.left, cnt, k);
        if (left != -1) return left;

        cnt[0]++;
        if (cnt[0] == k) return root.data;
        int right = kthSmallestRecur(root.right, cnt, k);
        return right;
    }

    public int kthSmallest(Node root, int k) {
        int[] cnt = {0};
        return kthSmallestRecur(root, cnt, k);
    }
}
