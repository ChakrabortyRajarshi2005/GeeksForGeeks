Count Unique Vowel Strings
Difficulty: MediumAccuracy: 50.99%Submissions: 13K+Points: 4
You are given a lowercase string s, determine the total number of distinct strings that can be formed using the following rules:

Identify all unique vowels (a, e, i, o, u) present in the string.
For each distinct vowel, choose exactly one of its occurrences from s. If a vowel appears multiple times, each occurrence represents a unique selection choice.
Generate all possible permutations of the selected vowels. Each unique arrangement counts as a distinct string.
Return the total number of such distinct strings.

Examples:

Input: s = "aeiou"
Output: 120
Explanation: Each vowel appears once, so the number of different strings can form is 5! = 120.
Input: s = "ae"
Output: 2
Explanation: Pick a and e, make all orders → "ae", "ea".
Input: s = "aacidf"
Output: 4 
Explanation: Vowels in s are 'a' and 'i', Pick each 'a' once with a single 'i', make all orders → "ai", "ia", "ai", "ia".
Constraints:
1 ≤ s.size() ≤ 100



class Solution {
    // Function to calculate factorial of a number
    public static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static int vowelCount(String s) {

        // Map to store the frequency of each vowel
        HashMap<Character, Integer> vowelFrequency = new HashMap<>();

        // List of vowels to check against
        String vowels = "aeiou";

        // Iterate over the string and
        // count occurrences of vowels
        for (char c : s.toCharArray()) {
            // Check if the character is a vowel
            if (vowels.indexOf(c) != -1) {
                vowelFrequency.put(c, vowelFrequency.getOrDefault(c, 0) + 1);
            }
        }

        // If no vowels are found in the string, return 0
        if (vowelFrequency.isEmpty()) return 0;

        int choices = 1;
        for (int count : vowelFrequency.values()) {
            // Multiply the frequency (choices) of each vowel
            choices *= count;
        }

        int distinctVowels = vowelFrequency.size();

        // Return the total number of distinct
        // vowel permutations
        int res = choices * factorial(distinctVowels);
        return res;
    }
}
