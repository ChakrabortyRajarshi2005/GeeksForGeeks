Walls Coloring II
Difficulty: HardAccuracy: 50.15%Submissions: 31K+Points: 8
You are given n walls arranged in a row, and each wall must be painted using one of the k available colors. The cost of painting ith wall with jth color is given by costs[i][j]. Your task is to determine the minimum total cost required to paint all the walls in such a way that no two adjacent walls share the same color. If it is impossible to paint the walls under this condition, you must return -1.

Examples:

Input: n = 4, k = 3,
costs[][] = [[1, 5, 7],
           [5, 8, 4],
           [3, 2, 9],
           [1, 2, 4]]

Output: 8
Explanation:
Paint wall 0 with color 0. Cost = 1
Paint wall 1 with color 2. Cost = 4
Paint wall 2 with color 1. Cost = 2
Paint wall 3 with color 0. Cost = 1
Total Cost = 1 + 4 + 2 + 1 = 8
Input: n = 5, k = 1,
costs[][] = [[5],
           [4],
           [9],
           [2],
           [1]]
Output: -1
Explanation: It is not possible to color all the walls under the given conditions.
Constraints:
0 ≤ n  ≤ 103
0 ≤ k  ≤ 103
1 ≤ costs[i][j]  ≤ 105

Expected Complexities

class Solution {
    int minCost(int[][] costs) {
        int n = costs.length;
        int m = costs[0].length;
        if (m == 1 && n > 1) return -1;
        int prevMin1 = Integer.MAX_VALUE, prevMin2 = Integer.MAX_VALUE, minIndex = -1;
        for (int j = 0; j < m; j++) {
            int val = costs[0][j];
            if (val < prevMin1) {
                prevMin2 = prevMin1;
                prevMin1 = val;
                minIndex = j;
            } else if (val < prevMin2) {
                prevMin2 = val;
            }
        }
        for (int i = 1; i < n; i++) {

            int currMin1 = Integer.MAX_VALUE, currMin2 = Integer.MAX_VALUE,
                currIndex = -1;

            for (int j = 0; j < m; j++) {
                int cost = costs[i][j] + (j == minIndex ? prevMin2 : prevMin1);
                if (cost < currMin1) {
                    currMin2 = currMin1;
                    currMin1 = cost;
                    currIndex = j;
                } else if (cost < currMin2) {
                    currMin2 = cost;
                }
            }

            prevMin1 = currMin1;
            prevMin2 = currMin2;
            minIndex = currIndex;
        }

        return prevMin1;
    }
}
