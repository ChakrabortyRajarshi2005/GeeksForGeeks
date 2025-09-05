Sort a linked list of 0s, 1s and 2s
Difficulty: MediumAccuracy: 60.75%Submissions: 270K+Points: 4Average Time: 30m
Given the head of a linked list where nodes can contain values 0s, 1s, and 2s only. Your task is to rearrange the list so that all 0s appear at the beginning, followed by all 1s, and all 2s are placed at the end.

Examples:

Input: head = 1 → 2 → 2 → 1 → 2 → 0 → 2 → 2
   
Output: 0 → 1 → 1 → 2 → 2 → 2 → 2 → 2
Explanation: All the 0s are segregated to the left end of the linked list, 2s to the right end of the list, and 1s in between. The final list will be:
   
Input: head = 2 → 2 → 0 → 1
   
Output: 0 → 1 → 2 → 2
Explanation: After arranging all the 0s, 1s and 2s in the given format, the output will be:
   
Constraints:
1 ≤ no. of nodes ≤ 106
0 ≤ node->data ≤ 2
class Solution {
  public:
    Node* segregate(Node* head) {
        if (!head || !(head->next))
            return head;

        // creating three dummy nodes to point to beginning of three linked lists.
        Node* zeroD = new Node(0);
        Node* oneD = new Node(0);
        Node* twoD = new Node(0);

        // initializing current pointers for three lists.
        Node *zero = zeroD, *one = oneD, *two = twoD;

        // traversing over the list with a pointer.
        Node* curr = head;
        while (curr) {

            // we check data at current node and store the node in it's respective
            // list and update the link part of that list.
            if (curr->data == 0) {
                zero->next = curr;
                zero = zero->next;
                curr = curr->next;
            } else if (curr->data == 1) {
                one->next = curr;
                one = one->next;
                curr = curr->next;
            } else {
                two->next = curr;
                two = two->next;
                curr = curr->next;
            }
        }

        // attaching the three lists containing 0s,1s and 2s respectively.
        zero->next = (oneD->next) ? (oneD->next) : (twoD->next);
        one->next = twoD->next;
        two->next = NULL;

        // updating the head of the list.
        head = zeroD->next;

        // deleting dummy nodes.
        delete zeroD;
        delete oneD;
        delete twoD;

        return head;
    }
};
