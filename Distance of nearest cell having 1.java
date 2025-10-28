Distance of nearest cell having 1
Difficulty: MediumAccuracy: 47.7%Submissions: 114K+Points: 4Average Time: 20m
Given a binary grid[][], where each cell contains either 0 or 1, find the distance of the nearest 1 for every cell in the grid.
The distance between two cells (i1, j1)  and (i2, j2) is calculated as |i1 - i2| + |j1 - j2|. 
You need to return a matrix of the same size, where each cell (i, j) contains the minimum distance from grid[i][j] to the nearest cell having value 1.

Note: It is guaranteed that there is at least one cell with value 1 in the grid.

Examples

Input: grid[][] = [[0, 1, 1, 0], 
                [1, 1, 0, 0], 
                [0, 0, 1, 1]]
Output: [[1, 0, 0, 1], 
        [0, 0, 1, 1], 
        [1, 1, 0, 0]]
Explanation: The grid is -

- 0's at (0,0), (0,3), (1,2), (1,3), (2,0) and (2,1) are at a distance of 1 from 1's at (0,1), (0,2), (0,2), (2,3), (1,0) and (1,1) respectively.

Input: grid[][] = [[1, 0, 1], 
                [1, 1, 0], 
                [1, 0, 0]]
Output: [[0, 1, 0], 
        [0, 0, 1], 
        [0, 1, 2]]
Explanation: The grid is -

- 0's at (0,1), (1,2), (2,1) and (2,2) are at a  distance of 1, 1, 1 and 2 from 1's at (0,0), (0,2), (2,0) and (1,1) respectively.

Constraints:
1 ≤ grid.size() ≤ 200
1 ≤ grid[0].size() ≤ 200class Solution {
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ans[i], Integer.MAX_VALUE);
        }

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    ans[i][j] = 0;
                    q.add(new int[] {i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int[] front = q.poll();
                int x = front[0];
                int y = front[1];
                int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

                for (int j = 0; j < directions.length; j++) {
                    int dx = directions[j][0];
                    int dy = directions[j][1];
                    if (x + dx >= 0 && x + dx < n && y + dy >= 0 && y + dy < m &&
                        ans[x + dx][y + dy] == Integer.MAX_VALUE) {
                        ans[x + dx][y + dy] = ans[x][y] + 1;
                        q.add(new int[] {x + dx, y + dy});
                    }
                }
            }
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                row.add(ans[i][j]);
            }
            result.add(row);
        }

        return result;
    }
}
