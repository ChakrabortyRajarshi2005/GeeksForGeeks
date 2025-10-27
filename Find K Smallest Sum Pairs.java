Find K Smallest Sum Pairs
Difficulty: MediumAccuracy: 54.64%Submissions: 10K+Points: 4
Given two integer arrays arr1[] and arr2[] sorted in ascending order and an integer k, your task is to find k pairs with the smallest sums, such that one element of each pair belongs to arr1[] and the other belongs to arr2[].

Return the list of these k pairs, where each pair is represented as [arr1[i], arr2[j]].

Note: You can return any possible k pairs with the smallest sums, the driver code will print true if it is correct else it will print false.

Examples:

Input: arr1[] = [1, 7, 11], arr2[] = [2, 4, 6], k = 3
Output: true
Explanation: All possible combinations of elements from the two arrays are:
[1, 2], [1, 4], [1, 6], [7, 2], [7, 4], [7, 6], [11, 2], [11, 4], [11, 6]. 
Among these, the three pairs with the minimum sums are [1, 2], [1, 4], [1, 6].
Input: arr1[] = [1, 3], arr2[] = [2, 4] k = 2
Output: true
Explanation: All possible combinations are [1, 2], [1, 4], [3, 2], [3, 4]. 
Among these, the two pairs with the minimum sums are [1, 2], [3, 2].
Constraints:
1 ≤ arr1.size(), arr2.size() ≤ 5*104
1 ≤ arr1[i], arr2[j] ≤ 109
1 ≤ k ≤ 103

class Solution {
    public ArrayList<ArrayList<Integer>> kSmallestPair(int[] arr1, int[] arr2, int k) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (arr1.length == 0 || arr2.length == 0 || k <= 0) return ans;

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        Set<String> my_set = new HashSet<>();
        pq.offer(new int[] {arr1[0] + arr2[0], 0, 0});
        my_set.add("0,0");

        while (k > 0 && !pq.isEmpty()) {
            int[] temp = pq.poll();
            int sum = temp[0], i = temp[1], j = temp[2];
            ans.add(new ArrayList<>(Arrays.asList(arr1[i], arr2[j])));
            k--;

            if (i + 1 < arr1.length) {
                String key1 = (i + 1) + "," + j;
                if (!my_set.contains(key1)) {
                    pq.offer(new int[] {arr1[i + 1] + arr2[j], i + 1, j});
                    my_set.add(key1);
                }
            }

            if (j + 1 < arr2.length) {
                String key2 = i + "," + (j + 1);
                if (!my_set.contains(key2)) {
                    pq.offer(new int[] {arr1[i] + arr2[j + 1], i, j + 1});
                    my_set.add(key2);
                }
            }
        }

        return ans;
    }
}
