XOR Pairs less than K
Difficulty: MediumAccuracy: 68.92%Submissions: 6K+Points: 4
Given an array arr[] and an integer k, we need to count the number of pairs from the given array such that the Bitwise XOR of each pair is less than k.

Examples:

Input: arr = [1, 2, 3, 5], k = 5 
Output: 4
Explanation: Bitwise XOR of all possible pairs that satisfy the given conditions are:
arr[0] ^ arr[1] = 1 ^ 2 = 3 
arr[0] ^ arr[2] = 1 ^ 3 = 2 
arr[0] ^ arr[3] = 1 ^ 5 = 4 
arr[1] ^ arr[2] = 2 ^ 3 = 1 
Therefore, the required output is 4.
Input: arr[] = [3, 5, 6, 8], k = 7 
Output: 3
Explnation: Bitwise XOR of all possible pairs that satisfy the given conditions are:
arr[0] ^ arr[1] = 6
arr[0] ^ arr[2] = 5
arr[1] ^ arr[2] = 3
Therefore, the required output is 3. 
Constraints:
1 ≤ arr.size(), k ≤ 5*104
1 ≤ arr[i] ≤ 5*104


class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[2];
        int cnt;

        TrieNode() {
            child[0] = child[1] = null;
            cnt = 0;
        }
    }

    private void insertTrie(TrieNode root, int n) {
        for (int i = 31; i >= 0; i--) {
            int bit = (n >>> i) & 1; 

            if (root.child[bit] == null) {
                root.child[bit] = new TrieNode();
            }

            root.child[bit].cnt++;
            root = root.child[bit];
        }
    }

    private int cntSmaller(TrieNode root, int n, int k) {
        int cntPairs = 0;

        for (int i = 31; i >= 0 && root != null; i--) {
            int bitN = (n >>> i) & 1;
            int bitK = (k >>> i) & 1;

            if (bitK == 1) {

                if (root.child[bitN] != null) {
                    cntPairs += root.child[bitN].cnt;
                }

                root = root.child[1 - bitN];

            } else {
                root = root.child[bitN];
            }
        }

        return cntPairs;
    }

    public int cntPairs(int[] arr, int k) {
        TrieNode root = new TrieNode();
        int totalPairs = 0;

        for (int x : arr) {
            totalPairs += cntSmaller(root, x, k);
            insertTrie(root, x);
        }

        return totalPairs;
    }
}
