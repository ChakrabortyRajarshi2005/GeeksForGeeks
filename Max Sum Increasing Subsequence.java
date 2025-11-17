Max Sum Increasing Subsequence
Difficulty: MediumAccuracy: 40.02%Submissions: 217K+Points: 4Average Time: 25m
Given an array of positive integers arr[], find the maximum sum of a subsequence such that the elements of the subsequence form a strictly increasing sequence.
In other words, among all strictly increasing subsequences of the array, return the one with the largest possible sum.

Examples:

Input: arr[] = [1, 101, 2, 3, 100]
Output: 106
Explanation: The maximum sum of an increasing sequence is obtained from [1, 2, 3, 100].
Input: arr[] = [4, 1, 2, 3]
Output: 6
Explanation: The maximum sum of an increasing sequence is obtained from [1, 2, 3].
Input: arr[] = [4, 1, 2, 4]
Output: 7
Explanation: The maximum sum of an increasing sequence is obtained from [1, 2, 4].
Constraints:
1 ≤ arr.size() ≤ 103
1 ≤ arr[i] ≤ 105class Solution {
    public int maxSumIS(int[] arr) {

        TreeMap<Integer, Integer> dp = new TreeMap<>();
        int ans = 0;

        for (int val : arr) {
            Map.Entry<Integer, Integer> entry = dp.lowerEntry(val);
            int bestSmaller = (entry == null) ? 0 : entry.getValue();

            int currSum = bestSmaller + val;
            if (dp.getOrDefault(val, 0) < currSum) {
                dp.put(val, currSum);
                Integer higher = dp.higherKey(val);
                while (higher != null && dp.get(higher) <= currSum) {
                    dp.remove(higher);
                    higher = dp.higherKey(val);
                }
            }

            ans = Math.max(ans, currSum);
        }

        return ans;
    }
}
