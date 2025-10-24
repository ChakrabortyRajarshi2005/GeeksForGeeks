Split Array Subsequences
Difficulty: MediumAccuracy: 51.83%Submissions: 10K+Points: 4
Given a sorted integer array arr[] and an integer k, determine if it is possible to split the array into one or more consecutive subsequences such that:

Each subsequence consists of consecutive integers (each number is exactly one greater than the previous).
Every subsequence has a length of at least k.
Return true if such a split is possible, otherwise return false.

Examples :

Input: arr[] = [2, 2, 3, 3, 4, 5], k = 2
Output: true
Explanation: arr can be split into three subsequence of length k - [2, 3], [2, 3], [4, 5].
Input: arr[] = [1, 1, 1, 1, 1], k = 4
Output: false
Explanation: It is impossible to split arr into consecutive increasing subsequences of length 4 or more.
Constraints:
1 ≤ arr.size()  ≤ 105
1 ≤ arr[i] ≤ 105
1 ≤  k ≤  arr.size() class Solution {
    public boolean isPossible(int[] arr, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0])
                    return a[1] - b[1];
                return a[0] - b[0];
            }
        });

        int i = 0;
        while (i < arr.length) {
            if (pq.isEmpty()) {
                pq.add(new int[] {arr[i], 1});
                i++;
            } else {
                int[] top = pq.peek();
                if (arr[i] == top[0]) {
                    pq.add(new int[] {arr[i], 1});
                    i++;
                } else if (arr[i] == top[0] + 1) {
                    pq.poll();
                    pq.add(new int[] {arr[i], top[1] + 1});
                    i++;
                } else {
                    if (top[1] < k) return false;
                    pq.poll();
                }
            }
        }

        while (!pq.isEmpty()) {
            if (pq.peek()[1] < k) return false;
            pq.poll();
        }

        return true;
    }
}
