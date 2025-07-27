


Upgrade to Premium for Doubt Support across all your problems and courses.

Explore Premium
Redirection Icon
Set Matrix Zeros
Difficulty: MediumAccuracy: 52.54%Submissions: 49K+Points: 4
You are given a 2D matrix mat[][] of size n x m. The task is to modify the matrix such that if mat[i][j] is 0, all the elements in the i-th row and j-th column are set to 0.

Examples:

Input: 
    
Output: 
    
Explanation: mat[1][1] = 0, so all elements in row 1 and column 1 are updated to zeroes.
Input: 
    
Output: 
    
Explanation: mat[0][0] and mat[0][3] are 0s, so all elements in row 0, column 0 and column 3 are updated to zeroes.
Constraints:
1 ≤ n, m ≤ 500
- 231 ≤ mat[i][j] ≤ 231 - 1class Solution {
    public void setMatrixZeroes(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int c0 = 1;

        // Traverse the arr and mark first
        // cell of each row and column
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {

                    // mark i-th row
                    mat[i][0] = 0;

                    // mark j-th column
                    if (j == 0)
                        c0 = 0;
                    else
                        mat[0][j] = 0;
                }
            }
        }

        // Traverse and mark the matrix from
        // (1, 1) to (n - 1, m - 1)
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {

                // Check for col & row
                if (mat[i][0] == 0 || mat[0][j] == 0) {
                    mat[i][j] = 0;
                }
            }
        }

        // Mark the first row
        if (mat[0][0] == 0) {
            for (int j = 0; j < m; j++) mat[0][j] = 0;
        }

        // Mark the first column
        if (c0 == 0) {
            for (int i = 0; i < n; i++) mat[i][0] = 0;
        }
    }
}
