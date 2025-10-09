Postorder Traversal
Difficulty: EasyAccuracy: 74.96%Submissions: 137K+Points: 2Average Time: 15m
Given the root of a Binary Tree, your task is to return its Postorder Traversal.

Note: A postorder traversal first visits the left child (including its entire subtree), then visits the right child (including its entire subtree), and finally visits the node itself.

Examples:

Input: root = [19, 10, 8, 11, 13]

Output: [11, 13, 10, 8, 19]
Explanation: The postorder traversal of the given binary tree is [11, 13, 10, 8, 19].
Input: root = [11, 15, N, 7]
 
Output: [7, 15, 11]
Explanation: The postorder traversal of the given binary tree is [7, 15, 11].
Constraints:
1 ≤ number of nodes ≤ 3*104
0 ≤ node->data ≤ 105


class Solution {
    public ArrayList<Integer> postOrder(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        Node current = root;

        while (current != null) {
            if (current.right == null) {
                res.add(current.data);
                current = current.left;
            } else {
                Node predecessor = current.right;
                while (predecessor.left != null && predecessor.left != current) {
                    predecessor = predecessor.left;
                }

                if (predecessor.left == null) {
                    res.add(current.data);
                    predecessor.left = current;
                    current = current.right;
                } else {
                    predecessor.left = null;
                    current = current.left;
                }
            }
        }

        Collections.reverse(res);
        return res;
    }
}
