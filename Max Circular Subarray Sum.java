Max Circular Subarray Sum
Difficulty: HardAccuracy: 29.37%Submissions: 172K+Points: 8Average Time: 25m
You are given a circular array arr[] of integers, find the maximum possible sum of a non-empty subarray. In a circular array, the subarray can start at the end and wrap around to the beginning. Return the maximum non-empty subarray sum, considering both non-wrapping and wrapping cases.

Examples:

Input: arr[] = [8, -8, 9, -9, 10, -11, 12]
Output: 22
Explanation: Starting from the last element of the array, i.e, 12, and moving in a circular fashion, we have max subarray as 12, 8, -8, 9, -9, 10, which gives maximum sum as 22.
Input: arr[] = [10, -3, -4, 7, 6, 5, -4, -1]
Output: 23
Explanation: Maximum sum of the circular subarray is 23. The subarray is [7, 6, 5, -4, -1, 10].
Input: arr[] = [5, -2, 3, 4]
Output: 12
Explanation: The circular subarray [3, 4, 5] gives the maximum sum of 12.
Constraints:
1 ≤ arr.size() ≤ 105
-104 ≤ arr[i] ≤ 104

class Solution {
    public int maxCircularSum(int arr[]) {
        int totalSum = 0;
        int currMaxSum = 0, currMinSum = 0;
        int maxSum = arr[0], minSum = arr[0];

        for (int i = 0; i < arr.length; i++) {

            // Kadane's to find maximum sum subarray
            currMaxSum = Math.max(currMaxSum + arr[i], arr[i]);
            maxSum = Math.max(maxSum, currMaxSum);

            // Kadane's to find minimum sum subarray
            currMinSum = Math.min(currMinSum + arr[i], arr[i]);
            minSum = Math.min(minSum, currMinSum);

            // Sum of all the elements of input array
            totalSum += arr[i];
        }

        int normalSum = maxSum;
        int circularSum = totalSum - minSum;

        // If the minimum subarray is equal to total Sum
        // then we just need to return normalSum
        if (minSum == totalSum) return normalSum;

        return Math.max(normalSum, circularSum);
    }
}
