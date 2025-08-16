Form the Largest Number
Difficulty: MediumAccuracy: 37.82%Submissions: 182K+Points: 4
Given an array of integers arr[] representing non-negative integers, arrange them so that after concatenating all of them in order, it results in the largest possible number. Since the result may be very large, return it as a string.

Examples:

Input: arr[] = [3, 30, 34, 5, 9]
Output: 9534330
Explanation: Given numbers are [3, 30, 34, 5, 9], the arrangement [9, 5, 34, 3, 30] gives the largest value.
Input: arr[] = [54, 546, 548, 60]
Output: 6054854654
Explanation: Given numbers are [54, 546, 548, 60], the arrangement [60, 548, 546, 54] gives the largest value.
Input: arr[] = [3, 4, 6, 5, 9]
Output: 96543
Explanation: Given numbers are [3, 4, 6, 5, 9], the arrangement [9, 6, 5, 4, 3] gives the largest value.
Constraints:
1 ≤ arr.size() ≤ 105
0 ≤ arr[i] ≤ 105



class Solution {

    // Custom comparator to compare concatenated strings
    static boolean myCompare(String s1, String s2) {
        return (s1 + s2).compareTo(s2 + s1) > 0;
    }

    public String findLargest(int[] arr) {

        // Convert the array of integers to an array of strings
        ArrayList<String> numbers = new ArrayList<>();
        for (int ele : arr) {
            numbers.add(Integer.toString(ele));
        }

        // Sort the array using the custom comparator
        Collections.sort(numbers, (s1, s2) -> myCompare(s1, s2) ? -1 : 1);

        // Handle the case where all numbers are zero.
        // We are sorting in descending order, so zero
        // in front means complete array contains zero
        if (numbers.get(0).equals("0")) {
            return "0";
        }

        // Concatenate the sorted array
        StringBuilder res = new StringBuilder();
        for (String num : numbers) {
            res.append(num);
        }

        return res.toString();
    }
}
