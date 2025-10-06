The Knight's tour problem
Difficulty: MediumAccuracy: 55.21%Submissions: 10K+Points: 4
You are given an integer n, there is a n × n chessboard with a Knight starting at the top-left corner (0, 0). Your task is to determine a valid Knight's Tour, where the Knight visits every square exactly once, following the standard movement rules of a chess Knight (two steps in one direction and one step perpendicular), for example if a Knight is placed at cell (2, 2), in one move it can move to any of the following cells: (4, 3), (4, 1), (0, 3), (0, 1), (3, 4), (3, 0), (1, 4) and (1, 0).

You have to return the order in which each cell is visited. If a solution exists, return the sequence of numbers (starting from 0) representing the order of visited squares. If no solution is possible, return an empty list.

Note: You can return any valid ordering, if it is correct the driver code will print true else it will print false.

Examples:

Input: n = 5
Output: true
Explanation: A possible Knight's Tour in a 5x5 chessboard is given below where Each number represents the step at which the Knight visits that cell, starting from (0, 0) as step 0.
[[0, 11, 2, 17, 20],
 [3, 16, 19, 12, 7],
 [10, 1, 6, 21, 18],
 [15, 4, 23, 8, 13], 
 [24, 9, 14, 5, 22]]
Input: n = 4
Output: true
Explanation: For n = 4, it is not possible for a valid Knight's Tour so you have to return [].
Constraints:
1 ≤ n ≤ 6


class Solution {
    public boolean isSafe(int x, int y, int n, int[][] board) {
        return (x >= 0 && y >= 0 && x < n && y < n && board[x][y] == -1);
    }

    public boolean knightTourUtil(int x, int y, int step, int n, int[][] board,
                                  int[] dx, int[] dy) {
        if (step == n * n) {
            return true;
        }

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isSafe(nx, ny, n, board)) {
                board[nx][ny] = step;

                if (knightTourUtil(nx, ny, step + 1, n, board, dx, dy)) {
                    return true;
                }

                board[nx][ny] = -1;
            }
        }

        return false;
    }

    public ArrayList<ArrayList<Integer>> knightTour(int n) {
        int[][] board = new int[n][n];
        for (int[] row : board) {
            Arrays.fill(row, -1);
        }

        int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

        board[0][0] = 0;

        if (knightTourUtil(0, 0, 1, n, board, dx, dy)) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            for (int[] row : board) {
                ArrayList<Integer> newRow = new ArrayList<>();
                for (int val : row) {
                    newRow.add(val);
                }
                result.add(newRow);
            }
            return result;
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        return res;
    }
}
