/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as:
    class Node {
        int data;
        Node next;
    }
*/

boolean hasCycle(Node head) {
    HashSet<Node> set = new HashSet<>();
    Node currentItem = head;
    while (currentItem != null) {
        if (set.contains(currentItem)) {
            return true;
        }
        set.add(currentItem);
        currentItem = currentItem.next;
    }
    return false;
}
