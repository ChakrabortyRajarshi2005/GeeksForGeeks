Balancing Consonants and Vowels Ratio
Difficulty: MediumAccuracy: 52.97%Submissions: 14K+Points: 4
You are given an array of strings arr[], where each arr[i] consists of lowercase english alphabets. You need to find the number of balanced strings in arr[] which can be formed by concatinating one or more contiguous strings of arr[].
A balanced string contains the equal number of vowels and consonants. 

Examples:

Input: arr[] = ["aeio", "aa", "bc", "ot", "cdbd"]
Output: 4
Explanation: arr[0..4], arr[1..2], arr[1..3], arr[3..3] are the balanced substrings with equal consonants and vowels.
Input: arr[] = ["ab", "be"]
Output: 3
Explanation: arr[0..0], arr[0..1], arr[1..1] are the balanced substrings with equal consonants and vowels.
Input: arr[] = ["tz", "gfg", "ae"]
Output: 0
Explanation: There is no such balanced substring present in arr[] with equal consonants and vowels.
Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ arr[i].size() ≤ 105
Total number of lowercase english characters in arr[] is lesser than 105.

class Solution {
    public static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public int countBalanced(String[] arr) {
        int n = arr.length;
        int res = 0;
        int prefix = 0;

        // Map to store frequency of prefix sums
        Map<Integer, Integer> freq = new HashMap<>();

        // Initial prefix sum is 0 (empty prefix is considered balanced)
        freq.put(0, 1);

        // Traverse the array of strings
        for (int i = 0; i < n; i++) {
            int score = 0;

            // Calculate net score of current
            // string: +1 for vowel, -1 for consonant
            for (char ch : arr[i].toCharArray()) {
                if (isVowel(ch))
                    score++;
                else
                    score--;
            }

            // Update the running prefix sum
            prefix += score;

            // If this prefix sum has been seen before,
            // then the subarray between previous and
            // current prefix is balanced
            res += freq.getOrDefault(prefix, 0);

            // Increment the frequency of this prefix sum
            freq.put(prefix, freq.getOrDefault(prefix, 0) + 1);
        }

        return res;
    }
}
