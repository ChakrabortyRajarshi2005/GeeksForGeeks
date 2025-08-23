Allocate Minimum Pages
Difficulty: MediumAccuracy: 35.51%Submissions: 322K+Points: 4Average Time: 35m
Given an array arr[] of integers, where each element arr[i] represents the number of pages in the i-th book. You also have an integer k representing the number of students. The task is to allocate books to each student such that:

Each student receives atleast one book.
Each student is assigned a contiguous sequence of books.
No book is assigned to more than one student.
The objective is to minimize the maximum number of pages assigned to any student. In other words, out of all possible allocations, find the arrangement where the student who receives the most pages still has the smallest possible maximum.

Note: If it is not possible to allocate books to all students, return -1.

Examples:

Input: arr[] = [12, 34, 67, 90], k = 2
Output: 113
Explanation: Allocation can be done in following ways:
=> [12] and [34, 67, 90] Maximum Pages = 191
=> [12, 34] and [67, 90] Maximum Pages = 157
=> [12, 34, 67] and [90] Maximum Pages = 113.
The third combination has the minimum pages assigned to a student which is 113.
Input: arr[] = [15, 17, 20], k = 5
Output: -1
Explanation: Since there are more students than total books, it's impossible to allocate a book to each student.
Constraints:
1 ≤ arr.size() ≤ 106
1 ≤ arr[i], k ≤ 103



class Solution {
    // function to check if books can be allocated to
    // all k students without exceeding 'pageLimit'
    public boolean check(int[] arr, int k, int pageLimit) {

        // Starting from the first student
        int cnt = 1;
        int pageSum = 0;
        for (int i = 0; i < arr.length; i++) {

            // If adding the current book exceeds the page
            // limit, assign the book to the next student
            if (pageSum + arr[i] > pageLimit) {
                cnt++;
                pageSum = arr[i];
            } else {
                pageSum += arr[i];
            }
        }

        // If books can assigned to less than k students then
        // it can be assigned to exactly k students as well
        return (cnt <= k);
    }

    public int findPages(int[] arr, int k) {

        // If number of students are more than total books
        // then allocation is not possible
        if (k > arr.length) return -1;

        // Search space for Binary Search
        int lo = Arrays.stream(arr).max().getAsInt();
        int hi = Arrays.stream(arr).sum();
        int res = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (check(arr, k, mid)) {
                res = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return res;
    }
}
