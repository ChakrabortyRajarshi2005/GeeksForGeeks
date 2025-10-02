
Unique K-Number Sum
Difficulty: MediumAccuracy: 73.03%Submissions: 8K+Points: 4
Given two integers n and k, the task is to find all valid combinations of k numbers that adds up to n based on the following conditions:

Only numbers from the range [1, 9] used.
Each number can only be used at most once.
Note: You can return the combinations in any order, the driver code will print them in sorted order.

Examples:

Input: n = 9, k = 3
Output: [[1, 2, 6], [1, 3, 5], [2, 3, 4]]
Explanation: There are three valid combinations of 3 numbers that sum to 9: [1 ,2, 6], [1, 3, 5] and [2, 3, 4].
Input: n = 3, k = 3
Output: []
Explanation: It is not possible to pick 3 distinct numbers from 1 to 9 that sum to 3, so no valid combinations exist.
Constraints:
1 ≤ n ≤ 50
1 ≤ k ≤ class Solution {
    public void findCombinations(int n, int k, ArrayList<Integer> subVector,
                                 ArrayList<ArrayList<Integer>> res, int last) {

        if (n == 0 && k == 0) {
            res.add(new ArrayList<>(subVector));
            return;
        }

        if (n < 0 || k < 0) return;

        for (int i = last; i <= 9; i++) {
            subVector.add(i);
            findCombinations(n - i, k - 1, subVector, res, i + 1);
            subVector.remove(subVector.size() - 1);
        }
    }

    public ArrayList<ArrayList<Integer>> combinationSum(int n, int k) {
        if (n < k || n > 9 * k) {
            return new ArrayList<>();
        }

        ArrayList<Integer> subVector = new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        findCombinations(n, k, subVector, res, 1);

        return res;
    }
}

class Solution {
    public void findCombinations(int n, int k, ArrayList<Integer> subVector,
                                 ArrayList<ArrayList<Integer>> res, int last) {

        if (n == 0 && k == 0) {
            res.add(new ArrayList<>(subVector));
            return;
        }

        if (n < 0 || k < 0) return;

        for (int i = last; i <= 9; i++) {
            subVector.add(i);
            findCombinations(n - i, k - 1, subVector, res, i + 1);
            subVector.remove(subVector.size() - 1);
        }
    }

    public ArrayList<ArrayList<Integer>> combinationSum(int n, int k) {
        if (n < k || n > 9 * k) {
            return new ArrayList<>();
        }

        ArrayList<Integer> subVector = new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        findCombinations(n, k, subVector, res, 1);

        return res;
    }
}
