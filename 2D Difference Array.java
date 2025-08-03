2D Difference Array
Difficulty: MediumAccuracy: 57.6%Submissions: 11K+Points: 4Average Time: 14m
You are given a 2D integer matrix mat[][] of size n × m and a list of q operations opr[][]. Each operation is represented as an array [v, r1, c1, r2, c2], where:

v is the value to be added
(r1, c1) is the top-left cell of a submatrix
(r2, c2) is the bottom-right cell of the submatrix (inclusive)
For each of the q operations, add v to every element in the submatrix from (r1, c1) to (r2, c2). Return the final matrix after applying all operations.

Examples:

Input: mat[][] = [[1, 2, 3],  opr[][] = [[2, 0, 0, 1, 1], [-1, 1, 0, 2, 2]]
                [1, 1, 0],
                [4,-2, 2]]
Output: [[3, 4, 3],
        [2, 2, -1],
        [3, -3, 1]] 
Explanation: 
 
Constraint:
1 ≤ n×m, q ≤ 105
0 ≤ r1 ≤ r2 ≤ n - 1
0 ≤ c1 ≤ c2 ≤ m - 1
-104 ≤ mat[i][j], v ≤ 104



class Solution {
    public ArrayList<ArrayList<Integer>> applyDiff2D(int[][] mat, int[][] opr) {
        int n = mat.length;
        int m = mat[0].length;

        // diff matrix of size n x m
        int[][] diff = new int[n][m];

        // apply all operations using 4-point updates
        for (int[] q : opr) {
            int v = q[0];
            int r1 = q[1], c1 = q[2], r2 = q[3], c2 = q[4];

            // top-left -> add
            diff[r1][c1] += v;
            // top-right -> subtract
            if (c2 + 1 < m) diff[r1][c2 + 1] -= v;
            // bottom-left -> subtract
            if (r2 + 1 < n) diff[r2 + 1][c1] -= v;
            // bottim-right -> add
            if (r2 + 1 < n && c2 + 1 < m) diff[r2 + 1][c2 + 1] += v;
        }

        // row-wise prefix sum
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                diff[i][j] += diff[i][j - 1];
            }
        }

        // column-wise prefix sum
        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                diff[i][j] += diff[i - 1][j];
            }
        }

        // apply diff to original matrix
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                row.add(mat[i][j] + diff[i][j]);
            }
            res.add(row);
        }

        return res;
    }
}
