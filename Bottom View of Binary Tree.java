Bottom View of Binary Tree
Difficulty: MediumAccuracy: 54.18%Submissions: 330K+Points: 4Average Time: 45m
You are given the root of a binary tree, and your task is to return its bottom view. The bottom view of a binary tree is the set of nodes visible when the tree is viewed from the bottom.

Note: If there are multiple bottom-most nodes for a horizontal distance from the root, then the latter one in the level order traversal is considered.

Examples :

Input: root = [1, 2, 3, 4, 5, N, 6]
    
Output: [4, 2, 5, 3, 6]
Explanation: The Green nodes represent the bottom view of below binary tree.
    
Input: root = [20, 8, 22, 5, 3, 4, 25, N, N, 10, 14, N, N, 28, N]
    
Output: [5, 10, 4, 28, 25]
Explanation: The Green nodes represent the bottom view of below binary tree.
    
Constraints:
1 ≤ number of nodes ≤ 105
1 ≤ node->data ≤ 105

class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        if (root == null) return new ArrayList<>();

        HashMap<Integer, Integer> hash = new HashMap<>();
        int minHD = 0;
        int maxHD = 0;
        Queue<List<Object>> q = new LinkedList<>();
        q.offer(Arrays.asList(root, 0));

        while (!q.isEmpty()) {
            List<Object> top = q.poll();
            Node node = (Node) top.get(0);
            int hd = (Integer) top.get(1);

            hash.put(hd, node.data);
            minHD = Math.min(minHD, hd);
            maxHD = Math.max(maxHD, hd);

            if (node.left != null) {
                q.offer(Arrays.asList(node.left, hd - 1));
            }

            if (node.right != null) {
                q.offer(Arrays.asList(node.right, hd + 1));
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = minHD; i <= maxHD; i++) {
            ans.add(hash.get(i));
        }

        return ans;
    }
}
