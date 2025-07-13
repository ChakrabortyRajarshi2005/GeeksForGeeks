Triplet Sum in Array
Difficulty: MediumAccuracy: 35.0%Submissions: 332K+Points: 4Average Time: 15m
Given an array arr[] and an integer target, determine if there exists a triplet in the array whose sum equals the given target.

Return true if such a triplet exists, otherwise, return false.

Examples

Input: arr[] = [1, 4, 45, 6, 10, 8], target = 13 
Output: true 
Explanation: The triplet {1, 4, 8} sums up to 13
Input: arr[] = [1, 2, 4, 3, 6, 7], target = 10 
Output: true 
Explanation: The triplets {1, 3, 6} and {1, 2, 7} both sum to 10. 
Input: arr[] = [40, 20, 10, 3, 6, 7], target = 24 
Output: false 
Explanation: No triplet in the array sums to 24
Constraints:
3 ≤ arr.size() ≤ 103
1 ≤ arr[i] ≤ 105


class Solution {
  public:
    // Function to find if there exists a triplet in the
    // array arr[] which sums up to the target.
    bool hasTripletSum(vector<int> &arr, int target) {
        int n = arr.size();
        int l, r;

        // Sorting the elements.
        sort(arr.begin(), arr.end());

        // Traversing the array elements.
        for (int i = 0; i < n - 2; i++) {
            // Taking two pointers. One at element after ith index and another
            // at the last index.
            l = i + 1;
            r = n - 1;
            while (l < r) {
                // If sum of elements at indexes i, l and r is equal
                // to the target, we return true.
                if (arr[i] + arr[l] + arr[r] == target)
                    return true;
                // Else if the sum is less than the target, we increase the left pointer
                // l.
                else if (arr[i] + arr[l] + arr[r] < target)
                    l++;
                // Else the sum is more than the target, so we decrease the right
                // pointer r.
                else
                    r--;
            }
        }

        // Returning false if no triplet sum equal to the target is present.
        return false;
    }
};
