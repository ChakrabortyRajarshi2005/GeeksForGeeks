
Difficulty: MediumAccuracy: 54.05%Submissions: 185K+Points: 4Average Time: 30m
Given the root of a binary tree. You have to find the zig-zag level order traversal of the binary tree.
Note: In zig zag traversal we traverse the nodes from left to right for odd-numbered levels, and from right to left for even-numbered levels.

Examples:

Input: root = [1, 2, 3, 4, 5, 6, 7]
          
Output: [1, 3, 2, 4, 5, 6, 7]
Explanation:
Level 1 (left to right): [1]
Level 2 (right to left): [3, 2]
Level 3 (left to right): [4, 5, 6, 7]
Final result: [1, 3, 2, 4, 5, 6, 7]
Input: root = [7, 9, 7, 8, 8, 6, N, 10, 9]
 
Output: [7, 7, 9, 8, 8, 6, 9, 10] 
Explanation:
Level 1 (left to right): [7]
Level 2 (right to left): [7, 9]
Level 3 (left to right): [8, 8, 6]
Level 4 (right to left): [9, 10]
Final result: [7, 7, 9, 8, 8, 6, 9, 10]
Constraints:
1 ≤ number of nodes ≤ 105
1 ≤ node->data ≤ 105

class Solution {
    ArrayList<Integer> zigZagTraversal(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(root);

        while (!s1.empty() || !s2.empty()) {
            while (!s1.empty()) {
                Node curr = s1.pop();
                res.add(curr.data);

                if (curr.left != null) s2.push(curr.left);
                if (curr.right != null) s2.push(curr.right);
            }

            while (!s2.empty()) {
                Node curr = s2.pop();
                res.add(curr.data);

                if (curr.right != null) s1.push(curr.right);
                if (curr.left != null) s1.push(curr.left);
            }
        }
        return res;
    }
}
