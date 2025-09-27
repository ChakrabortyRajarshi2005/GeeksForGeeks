Minimum K Consecutive Bit Flips
Difficulty: HardAccuracy: 64.29%Submissions: 9K+Points: 8
You are given a binary array arr[] (containing only 0's and 1's) and an integer k. In one operation, you can select a contiguous subarray of length k and flip all its bits (i.e., change every 0 to 1 and every 1 to 0).

Your task is to find the minimum number of such operations required to make the entire array consist of only 1's. If it is not possible, return -1.

Examples:

Input: arr = [1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1], k = 2
Output: 4 
Explanation: 4 operations are required to convert all 0's to 1's.
Select subarray [2, 3] and flip all bits resulting array will be [1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1]
Select subarray [4, 5] and flip all bits resulting array will be [1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1]
Select subarray [5, 6] and flip all bits resulting array will be [1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1]
Select subarray [6, 7] and flip all bits resulting array will be [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
Input: arr = [0, 0, 1, 1, 1, 0, 0], k = 3
Output: -1
Explanation: It is not possible to convert all elements to 1's by performing any number of operations.
Constraints:
1 ≤ arr.size() ≤ 106
1 ≤ k ≤ arr.size()
class Solution {
    public int kBitFlips(int[] arr, int k) {
        int n = arr.length;
        int res = 0, flag = 0;
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {

            if (i >= k) flag ^= q.poll();

            // If flag = 1, then flip the current index
            if (flag == 1) arr[i] ^= 1;

            // Finally, if arr[i] = 0, then we need to flip
            if (arr[i] == 0) {

                // Check if k elements are left
                if (i + k > n) return -1;

                res += 1;

                // Flip flag so that upcoming elements are also flipped
                flag ^= 1;

                // If we flip, push 1 to the queue
                q.offer(1);
            } else {

                // If we don't flip, push 0 to queue
                q.offer(0);
            }
        }

        return res;
    }
}
