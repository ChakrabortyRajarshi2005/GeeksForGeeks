K closest Values
Difficulty: MediumAccuracy: 76.47%Submissions: 7K+Points: 4
Given the root of a Binary Search Tree, a target value, and an integer k. Your task is to find the k values in the BST that are closest to the target.

The closest value is taken by choosing the one that gives minimum absolute difference from target.

Note: In case two values have same absolute difference from target, choose the smaller one. The target may or may not be present in BST.
You can return the values in any order the driver code will print them in sorted order only.

Examples:

Input: root = [20, 8, 22, 4, 12, N, N, N, N, 10, 14], target = 17, k = 3
     
Output: [14, 20, 12]
Explanation: Absolute difference of 17 wrt 14 and 20 is 3 and 3, but we choose the smaller value in case of same absolute difference. So, 14 coes first and then 20. Then, 12 and 22 have same absolute difference, i.e., 5 from 17. But we choose the smaller value, i.e., 12.
     
Input: root = [5, 4, 8, 1], target = 5, k = 2
     
Output: [5, 4]
Explanation: The absolute difference of 5 wrt 5 is 0, and for 4, the absolute difference is 1.
    
Constraints:
1 ≤ number of nodes, k ≤ 104
1 ≤ node->data, target ≤ 104

/*
class Node {
  public:
    int data;
    Node* left;
    Node* right;

    Node(int val) {
        data = val;
        left = NULL;
        right = NULL;
    }
};
*/

class Solution {
    public void getInorder(Node node, ArrayList<Integer> traversal) {
        if (node == null) return;

        getInorder(node.left, traversal);
        traversal.add(node.data);
        getInorder(node.right, traversal);
    }
    public int findPosition(int k, ArrayList<Integer> list) {
        int n = list.size();
        int position = 0;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (list.get(mid) <= k) {
                position = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return position;
    }

    public ArrayList<Integer> getKClosest(Node root, int target, int k) {
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);

        int n = inorder.size();

        int position = findPosition(target, inorder);
        ArrayList<Integer> kClosest = new ArrayList<>();
        int l = position, r = position + 1;
        while (k > 0) {
            if (r == n || (l >= 0 && Math.abs(inorder.get(l) - target) <=
                                         Math.abs(inorder.get(r) - target))) {
                kClosest.add(inorder.get(l));
                l--;
            } else {
                kClosest.add(inorder.get(r));
                r++;
            }
            k--;
        }
        return kClosest;
    }
}
