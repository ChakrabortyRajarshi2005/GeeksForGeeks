Tywin's War Strategy
Difficulty: EasyAccuracy: 50.0%Submissions: 17K+Points: 2
You are given an array arr[] of size n, where arr[i] represents the number of soldiers in the i-th troop. You are also given an integer k. A troop is considered "lucky" if its number of soldiers is a multiple of k. Find the minimum total number of soldiers to add across all troops so that at least ⌈n / 2⌉ troops become lucky.

Examples:

Input: arr = [5, 6, 3, 2, 1], k = 2
Output: 1
Explanation: By adding 1 soldier for the troop with 1 soldier, we get [5, 6, 3, 2, 2]. Now 3 out of 5 troops (6, 2, and 2) are multiples of 2 that satisfy the requirement.
Input: arr = [3, 5, 6, 7, 9, 10], k = 4
Output: 4
Explanation: We need at least 3 lucky troops since ⌈6 / 2⌉ = 3. Currently, no troop is divisible by 4.
Add 1 soldier for troop 3 → 4,
Add 2 for troop 6 → 8,
Add 1 for troop 7 → 8.
New array: [4, 5, 8, 8, 9, 10] with 3 lucky troops (4, 8, 8).
Total soldiers added = 4.
Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ k ≤ 105
1 ≤ arr[i] ≤ 105
class Solution {
    public int minSoldiers(int[] arr, int k) {
        int n = arr.length;
        int need = (n + 1) / 2;
        List<Integer> costs = new ArrayList<>();

        for (int num : arr) {
            if (num % k == 0) {
                costs.add(0);
            } else {
                costs.add(k - (num % k));
            }
        }

        // Sort the costs in ascending order
        costs.sort(null);

        // Add up the smallest `need` costs
        int total = 0;
        for (int i = 0; i < need; ++i) {
            total += costs.get(i);
        }

        return total;
    }
}
