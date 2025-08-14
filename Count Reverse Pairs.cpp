Count Reverse Pairs
Difficulty: HardAccuracy: 50.0%Submissions: 22K+Points: 8
You are given an array arr[] of positive integers, find the count of reverse pairs. A pair of indices (i, j) is said to be a reverse pair if both the following conditions are met:

0 ≤ i < j < arr.size()
arr[i] > 2 * arr[j]
Examples:
Input: arr[] = [3, 2, 4, 5, 1, 20]
Output: 3
Explanation:
The Reverse pairs are 
(0, 4), arr[0] = 3, arr[4] = 1, 3 > 2*1 
(2, 4), arr[2] = 4, arr[4] = 1, 4 > 2*1 
(3, 4), arr[3] = 5, arr[4] = 1, 5 > 2*1 
Input: arr[] = [5, 4, 3, 2, 2]
Output: 2
Explanation:
The Reverse pairs are
(0, 3), arr[0] = 5, arr[3] = 2, 5 > 2*2
(0, 4), arr[0] = 5, arr[4] = 2, 5 > 2*2
Constraints:
1 ≤ arr.size() ≤ 5*104
1 ≤ arr[i] ≤ 109



class Solution {
    // Function to count reverse pairs during merge
    public int merging(int[] arr, int low, int mid, int high) {

        int count = 0, j = mid + 1;

        // Count valid pairs before merging
        for (int i = low; i <= mid; i++) {
            while (j <= high && arr[i] > 2L * arr[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }

        // Merge step (standard merge sort)
        List<Integer> temp = new ArrayList<>();
        int left = low, right = mid + 1;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left++]);
            } else {
                temp.add(arr[right++]);
            }
        }

        while (left <= mid) {
            temp.add(arr[left++]);
        }

        while (right <= high) {
            temp.add(arr[right++]);
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }

        return count;
    }

    // Function to perform merge sort and count pairs
    public int mergeSort(int[] arr, int low, int high) {

        if (low >= high) {
            return 0;
        }

        int mid = low + (high - low) / 2;
        int count = mergeSort(arr, low, mid) + mergeSort(arr, mid + 1, high) +
                    merging(arr, low, mid, high);

        return count;
    }

    public int countRevPairs(int[] arr) { return mergeSort(arr, 0, arr.length - 1); }
}
