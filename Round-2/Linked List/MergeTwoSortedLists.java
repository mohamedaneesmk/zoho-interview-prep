/*
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: list1 = [], list2 = []
Output: []

Example 3:
Input: list1 = [], list2 = [0]
Output: [0]
*/



class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        // Example 1: list1 = [1, 2, 4], list2 = [1, 3, 4]
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        System.out.print("Example 1: ");
        printList(mergeTwoLists(list1, list2)); // Expected: 1 1 2 3 4 4
        System.out.println();

        // Example 2: list1 = [], list2 = []
        list1 = null;
        list2 = null;
        System.out.print("Example 2: ");
        printList(mergeTwoLists(list1, list2)); // Expected: (empty)
        System.out.println();

        // Example 3: list1 = [], list2 = [0]
        list1 = null;
        list2 = new ListNode(0);
        System.out.print("Example 3: ");
        printList(mergeTwoLists(list1, list2)); // Expected: 0
        System.out.println();
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1); // Dummy node
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Attach the remaining nodes
        if (list1 != null) current.next = list1;
        if (list2 != null) current.next = list2;

        return dummy.next; // Skip dummy node
    }

    public static void printList(ListNode head) {
        if (head == null) {
            System.out.print("[]");
            return;
        }
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " -> " : ""));
            head = head.next;
        }
    } 
}

