Median in a row-wise sorted Matrix
Difficulty: HardAccuracy: 55.05%Submissions: 158K+Points: 8
Given a row-wise sorted matrix mat[][] of size n*m, where the number of rows and columns is always odd. Return the median of the matrix.

Examples:

Input: mat[][] = [[1, 3, 5], 
                [2, 6, 9], 
                [3, 6, 9]]
Output: 5
Explanation: Sorting matrix elements gives us [1, 2, 3, 3, 5, 6, 6, 9, 9]. Hence, 5 is median.
Input: mat[][] = [[2, 4, 9],
                [3, 6, 7],
                [4, 7, 10]]
Output: 6
Explanation: Sorting matrix elements gives us [2, 3, 4, 4, 6, 7, 7, 9, 10]. Hence, 6 is median.
Input: mat = [[3], [4], [8]]
Output: 4
Explanation: Sorting matrix elements gives us [3, 4, 8]. Hence, 4 is median.
Constraints:
1 ≤ n, m ≤ 400
1 ≤ mat[i][j] ≤ 2000

class Solution {
    // helper function to find the upper bound of a
    // number in a row
    public int upperBound(int[] row, int num) {
        int low = 0, high = row.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (row[mid] <= num) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public int median(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        // initializing the minimum and maximum values
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        // iterating through each row of the matrix
        for (int i = 0; i < n; i++) {

            // updating the minimum value if current
            // element is smaller
            if (mat[i][0] < min) min = mat[i][0];

            // updating the maximum value if current
            // element is larger
            if (mat[i][m - 1] > max) max = mat[i][m - 1];
        }

        // calculating the desired position of the median
        int desired = (n * m + 1) / 2;

        // using binary search to find the median value
        while (min < max) {

            // calculating the middle value
            int mid = min + (max - min) / 2;

            // counting the number of elements less than
            // or equal to mid
            int place = 0;
            for (int i = 0; i < n; i++) {
                place += upperBound(mat[i], mid);
            }

            // updating the search range based on the count
            if (place < desired) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        // returning the median value
        return min;
    }
}
