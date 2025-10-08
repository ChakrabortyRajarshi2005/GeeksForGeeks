Construct Tree from Preorder & Postorder
Difficulty: MediumAccuracy: 78.76%Submissions: 8K+Points: 4
Given two arrays pre[] and post[] that represent the preorder and postorder traversals of a full binary tree. Your task is to construct the binary tree and return its root.

Note:  Full Binary Tree is a binary tree where every node has either 0 or 2 children. The preorder and postorder traversals contain unique values, and every value present in the preorder traversal is also found in the postorder traversal.

Examples:

Input: pre[] = [1, 2, 4, 8, 9, 5, 3, 6, 7], post[] = [8, 9, 4, 5, 2, 6, 7, 3, 1]
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9]
Explanation: The tree will look like
   
Input: pre[] = [1, 2, 4, 5, 3, 6, 7] , post[] = [4, 5, 2, 6, 7, 3, 1]
Output: [1, 2, 3, 4, 5, 6, 7]
Explanation: The tree will look like
   
Constraints:
1 ≤ number of nodes ≤ 103
1 ≤ pre[i], post[i] ≤ 104

class Solution {
    private Node constructTreeUtil(int[] pre, int[] post, int[] preIndex, int l, int h,
                                   int size, Map<Integer, Integer> postIndexMap) {
        if (preIndex[0] >= size || l > h) return null;

        Node root = new Node(pre[preIndex[0]]);
        preIndex[0]++;

        if (l == h || preIndex[0] >= size) return root;

        int i = postIndexMap.get(pre[preIndex[0]]);

        if (i <= h) {
            root.left = constructTreeUtil(pre, post, preIndex, l, i, size, postIndexMap);
            root.right = constructTreeUtil(pre, post, preIndex, i + 1, h - 1, size, postIndexMap);
        }

        return root;
    }

    public Node constructTree(int[] pre, int[] post) {
        int size = pre.length;
        int[] preIndex = {0};
        Map<Integer, Integer> postIndexMap = new HashMap<>();
        for (int i = 0; i < size; i++) postIndexMap.put(post[i], i);
        return constructTreeUtil(pre, post, preIndex, 0, size - 1, size, postIndexMap);
    }
}
