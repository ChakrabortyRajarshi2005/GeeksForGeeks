Reverse a Doubly Linked List
Difficulty: EasyAccuracy: 70.38%Submissions: 198K+Points: 2Average Time: 15m
You are given the head of a doubly linked list. You have to reverse the doubly linked list and return its head.

Examples:

Input:
   
Output: 5 <-> 4 <-> 3
Explanation: After reversing the given doubly linked list the new list will be 5 <-> 4 <-> 3.
   
Input: 
   
Output: 196 <-> 59 <-> 122 <-> 75
Explanation: After reversing the given doubly linked list the new list will be 196 <-> 59 <-> 122 <-> 75.
   
Constraints:
1 ≤ number of nodes ≤ 106
0 ≤ node->data ≤ 104

class Solution {
    public Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node currNode = head;
        Node prevNode = null;

        // Traverse the list and reverse the links
        while (currNode != null) {

            // Swap the next and prev pointers
            prevNode = currNode.prev;
            currNode.prev = currNode.next;
            currNode.next = prevNode;

            // Move to the next node in the original list
            // (which is now previous due to reversal)
            currNode = currNode.prev;
        }

        // Update head of Doubly Linked List
        head = prevNode.prev;

        return head;
    }
}
