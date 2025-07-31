Powerful Integer
Difficulty: MediumAccuracy: 51.91%Submissions: 41K+Points: 4
You are given a 2D integer array intervals[][] of length n, where each intervals[i] = [start, end] represents a closed interval (i.e., all integers from start to end, inclusive). You are also given an integer k. An integer is called Powerful if it appears in at least k intervals. Find the maximum Powerful Integer.

Note: If no integer occurs at least k times return -1.

Examples:

Input : n = 3, intervals[][] = [[1, 3], [4, 6], [3, 4]], k = 2
Output: 4
Explanation: Integers 3 and 4 appear in 2 intervals. The maximum is 4.
Input : n = 4, intervals[][] = [[1, 4], [12, 45], [3, 8], [10, 12]], k = 3
Output: -1
Explanation: No integer appears in at least 3 intervals.
Input : n = 5, intervals[][] = [[16, 21], [5, 8], [12, 17], [17, 29], [9, 24]], k = 3
Output: 21
Explanation: Integers 16, 17, 18, 19, 20 and 21 appear in at least 3 intervals. The maximum is 21.
Constraints:
1 ≤ n ≤ 105
1 ≤ intervals[i][0] ≤ intervals[i][1] ≤ 109
1 ≤ k ≤ 105
class Solution {
    public int powerfulInteger(int[][] intervals, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Mark interval start and
        // end+1 with +1 and -1 respectively
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end + 1, map.getOrDefault(end + 1, 0) - 1);
        }

        int ans = -1;
        int temp = 0;
        // Traverse the map (sorted keys) and
        // track frequency using prefix sum
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int point = entry.getKey();
            int delta = entry.getValue();

            if (delta >= 0) {
                temp += delta;
                if (temp >= k) {
                    ans = point;
                }
            } else {
                if (temp >= k) {
                    ans = point - 1;
                }
                temp += delta;
            }
        }

        return ans;
    }
}
