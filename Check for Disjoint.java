
Check for Disjoint
Difficulty: EasyAccuracy: 68.8%Submissions: 1K+Points: 2
Given two arrays a[] and b[], check if they are disjoint, i.e., there is no element common between both the arrays. Return true if if they are disjoint, otherwise, false.

Examples:

Input: a[] = [2, 34, 11, 9, 3], b[] = [2, 1, 3, 5]
Output: false
Explanation: 3 is common in both the arrays.
Input: a[] = [12, 34, 11, 9, 3], b[] = [7, 2, 1, 5]
Output: true 
Explanation: There is no common element in both the sets.
Input: a[] = [1, 2, 3, 4], b[] = [4, 3, 2, 1]
Output: false
Explanation: All the elements are common in both the arrays.
Constraints:
1 <= arr.size() <= 106
1 <= arr[i] <= 106

Expected Complexities
Time Complexity: O(n + m)
Auxiliary Space: O(n)
// User function Template for Java
class Solution {
    public boolean areDisjoint(int[] a, int[] b) {
        // code here
        
        HashSet<Integer> hs = new HashSet<>();
        for(int nums:a){
            hs.add(nums);
        }
        
        for(int nums :b){
            if(hs.contains(nums)){
                return false;
            }        
            
        }
        return true;
        
    }
}
