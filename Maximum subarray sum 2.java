Maximum subarray sum 2
Difficulty: HardAccuracy: 57.52%Submissions: 9K+Points: 8
You are given an array arr[] of integers and two integers a and b, You have to find the maximum possible sum of a contiguous subarray whose length is at least a and at most b.

Examples:

Input: arr[] = [4, 5, -1, -2, 6], a = 2, b = 4
Output: 9
Explanation: The subarray [4, 5] has length 2 and sum 9, which is the maximum among all subarrays of length between 2 and 4.
Input: arr[] = [-1, 3, -1, -2, 5, 3, -5, 2, 2], a = 3, b = 5
Output: 8
Explanation: The subarray [3, -1, -2, 5, 3] has length 5 and sum 8, which is the maximum among all subarrays of length between 3 and 5.
Constraints:
1 ≤ arr.size() ≤ 105
-105 ≤ arr[i] ≤ 105
1 ≤ a ≤ b ≤ arr.size()


import java.util.*;

class Solution {
    public int maxSubarrSum(int[] arr, int a, int b) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            arr[i] += arr[i - 1];
        }

        int maxi = arr[a - 1];
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(0);

        for (int i = a; i < n; i++) {
            if (i - b - 1 >= 0) {
                if (dq.peekFirst() == arr[i - b - 1]) {
                    dq.pollFirst();
                }
            } else if (i - b == 0) {
                if (dq.peekFirst() == 0) {
                    dq.pollFirst();
                }
            }

            while (!dq.isEmpty() && dq.peekLast() > arr[i - a]) {
                dq.pollLast();
            }

            dq.addLast(arr[i - a]);
            maxi = Math.max(maxi, arr[i] - dq.peekFirst());
        }

        return maxi;
    }
}
