Maximum sum Rectangle
Difficulty: HardAccuracy: 49.78%Submissions: 50K+Points: 8
Given a 2D matrix mat[][] with dimensions n×m. Find the maximum possible sum of any submatrix within the given matrix.

Examples:

Input: mat[][] = [[1, 2, -1, -4, -20], [-8, -3, 4, 2, 1], [3, 8, 10, 1, 3], [-4, -1, 1, 7, -6]]
Output: 29
Explanation: The matrix is as follows and the green rectangle denotes the maximum sum rectangle which is equal to 29.

Input: mat[][] = [[-1, -2], [-3, -4]]
Output: -1
Explanation: Taking only the first cell is the optimal choice.
Constraints:
1 ≤ n, m ≤ 300
-1000 ≤ mat[i][j] ≤ 1000


class Solution {
    // Kadane's algorithm to find the maximum sum subarray
    // in a 1D array
    public int kadane(int[] temp) {
        int rows = temp.length;
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < rows; i++) {
            currSum += temp[i];

            // Update maxSum if the current sum is greater
            if (maxSum < currSum) {
                maxSum = currSum;
            }

            // If the current sum becomes negative, reset it
            // to 0
            if (currSum < 0) {
                currSum = 0;
            }
        }

        return maxSum;
    }

    public int maxRectSum(int mat[][]) {
        int rows = mat.length;
        int cols = mat[0].length;

        int maxSum = Integer.MIN_VALUE;

        // Initialize a temporary array to store row-wise
        // sums between left and right boundaries
        int[] temp = new int[rows];

        // Check for all possible left and right boundaries
        for (int left = 0; left < cols; left++) {

            // Reset the temporary array for each new left
            // boundary
            for (int i = 0; i < rows; i++) {
                temp[i] = 0;
            }

            for (int right = left; right < cols; right++) {

                // Update the temporary array with the
                // current column's values
                for (int row = 0; row < rows; row++) {
                    temp[row] += mat[row][right];
                }

                // Find the maximum sum of the subarray for
                // the current column boundaries
                int sum = kadane(temp);

                // Update the maximum sum found so far
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
};
