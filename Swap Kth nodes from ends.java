
Swap Kth nodes from ends
Difficulty: MediumAccuracy: 35.5%Submissions: 75K+Points: 4Average Time: 45m
Given the head of a singly linked list and an integer k. Swap the kth node (1-based index) from the beginning and the kth node from the end of the linked list. Return the head of the final formed list and if it's not possible to swap the nodes return the original list.

Examples:

Input: k = 1,
  
Output: 5 -> 2 -> 3 -> 4 -> 1
Explanation: Here k = 1, hence after swapping the 1st node from the beginning and end the new list will be 5 -> 2 -> 3 -> 4 -> 1.
  
Input: k = 2,
  
Output: 5 -> 9 -> 8 -> 5 -> 10 -> 3
Explanation: Here k = 2, hence after swapping the 2nd node from the beginning and end the new list will be 5 -> 9 -> 8 -> 5 -> 10 -> 3.
  
Constraints:
1 ≤ list size ≤ 104
1 ≤ node->data ≤ 106
1 ≤ k ≤ 104

class Solution {
    public Node swapKth(Node head, int k) {

        if (head == null) return head;

        // Count length
        int n = 0;
        Node temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }

        // if k is more than length, no swap
        if (k > n) return head;

        // if kth from start and end are same, no swap
        if (2 * k - 1 == n) return head;

        // find kth node from start and its prev
        Node prevX = null;
        Node x = head;
        for (int i = 1; i < k; i++) {
            prevX = x;
            x = x.next;
        }

        // find kth node from end and its prev
        Node prevY = null;
        Node y = head;
        for (int i = 1; i < n - k + 1; i++) {
            prevY = y;
            y = y.next;
        }

        // adjust previous pointers
        if (prevX != null) prevX.next = y;
        if (prevY != null) prevY.next = x;

        // swap next pointers
        Node tempNext = x.next;
        x.next = y.next;
        y.next = tempNext;

        // change head if needed
        if (k == 1) head = y;
        if (k == n) head = x;

        return head;
    }
}
