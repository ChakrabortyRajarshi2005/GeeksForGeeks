
Sum of Mode
Difficulty: HardAccuracy: 54.28%Submissions: 11K+Points: 8Average Time: 20m
Given an array arr[] of positive integers and an integer k. You have to find the sum of the modes of all the subarrays of size k.
Note: The mode of a subarray is the element that occurs with the highest frequency. If multiple elements have the same highest frequency, the smallest such element is considered the mode.

Examples:

Input: arr[] = [1, 2, 3, 2, 5, 2, 4, 4], k = 3
Output: 13
Explanation: The mode of each k size subarray is [1, 2, 2, 2, 2, 4] and sum of all modes is 13.
Input: arr[] = [1, 2, 1, 3, 5], k = 2
Output: 6
Explanation: The mode of each k size subarray is [1, 1, 1, 3] and sum of all modes is 6.
Constraints:
1 ≤ k ≤ arr.size() ≤105
1 ≤ arr[i] ≤ 105class Solution {
    public int sumOfModes(int[] arr, int k) {
        int n = arr.length;
        int sum = 0;

        // Stores frequency of elements
        // in current window
        Map<Integer, Integer> mp = new HashMap<>();

        // Stores (frequency, -value) to maintain
        // order of mode selection
        TreeSet<int[]> st = new TreeSet<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            }
        });

        // Build frequency map for the first window
        for (int i = 0; i < k; i++) {
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        }

        // Populate the set with initial frequency pairs
        for (Map.Entry<Integer, Integer> x : mp.entrySet()) {
            st.add(new int[] {x.getValue(), -x.getKey()});
        }

        // Add mode of the first window
        int mode = -st.last()[1];
        sum += mode;

        // Slide the window across the array
        for (int i = k; i < n; i++) {
            int out = arr[i - k];
            int in = arr[i];

            // Remove the outgoing element's
            // previous frequency pair
            int outFreq = mp.get(out);
            st.remove(new int[] {outFreq, -out});

            // Decrement frequency of
            // outgoing element
            mp.put(out, outFreq - 1);

            // If frequency is still positive,
            // reinsert updated pair
            if (mp.get(out) > 0) {
                st.add(new int[] {mp.get(out), -out});
            } else {
                mp.remove(out);
            }

            // Increment frequency of incoming element
            mp.put(in, mp.getOrDefault(in, 0) + 1);

            // Insert updated frequency pair
            // for incoming element
            st.add(new int[] {mp.get(in), -in});

            // Get current mode and add to sum
            mode = -st.last()[1];
            sum += mode;
        }

        return sum;
    }
}
