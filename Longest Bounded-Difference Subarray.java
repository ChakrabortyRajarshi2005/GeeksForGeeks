Longest Bounded-Difference Subarray
Difficulty: MediumAccuracy: 58.27%Submissions: 26K+Points: 4
Given an array of positive integers arr[] and a non-negative integer x, the task is to find the longest sub-array where the absolute difference between any two elements is not greater than x.
If multiple such subarrays exist, return the one that starts at the smallest index.

Examples:

Input: arr[] = [8, 4, 5, 6, 7], x = 3 
Output: [4, 5, 6, 7] 
Explanation: The sub-array described by index [1..4], i.e. [4, 5, 6, 7]
contains no two elements whose absolute differnce is greater than 3.
Input: arr[] = [1, 10, 12, 13, 14], x = 2 
Output: [12, 13, 14] 
Explanation: The sub-array described by index [2..4], i.e. [12, 13, 14]
contains no two elements whose absolute differnece is greater than 2. 
Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 109
0 ≤ x ≤ 109


class Solution {
    static ArrayList<Integer> longestSubarray(int[] arr, int x) {
        Deque<Integer> minQueue = new LinkedList<>();
        Deque<Integer> maxQueue = new LinkedList<>();

        int n = arr.length, start = 0, end = 0;
        int resStart = 0, resEnd = 0;

        while (end < n) {
            while (!minQueue.isEmpty() && arr[minQueue.peekLast()] > arr[end])
                minQueue.pollLast();
            while (!maxQueue.isEmpty() && arr[maxQueue.peekLast()] < arr[end])
                maxQueue.pollLast();

            minQueue.addLast(end);
            maxQueue.addLast(end);

            while (arr[maxQueue.peekFirst()] - arr[minQueue.peekFirst()] > x) {
                if (start == minQueue.peekFirst()) minQueue.pollFirst();
                if (start == maxQueue.peekFirst()) maxQueue.pollFirst();
                start += 1;
            }

            if (end - start > resEnd - resStart) {
                resStart = start;
                resEnd = end;
            }
            end += 1;
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = resStart; i <= resEnd; i++) res.add(arr[i]);

        return res;
    }
}
