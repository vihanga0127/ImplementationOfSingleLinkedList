package ImplementationOfSingleLinkedList;

public class SinglyLinkedList {

    // Node class represents a single element in the list
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head of the linked list
    private Node head;

    // Method to add a new node at the beginning of the list (prepend)
    public void push(int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
    }

    // Method to add a new node at the end of the list (append)
    public void append(int newData) {
        Node newNode = new Node(newData);
        if (head == null) {
            head = newNode;
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
    }

    // Method to delete the first occurrence of a given value
    public void delete(int key) {
        Node temp = head;
        Node prev = null;

        // If the head node itself holds the key to be deleted
        if (temp != null && temp.data == key) {
            head = temp.next;
            return;
        }

        // Search for the key to be deleted, keep track of the previous node
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        // If the key was not present in the list
        if (temp == null) {
            return;
        }

        // Unlink the node from the linked list
        prev.next = temp.next;
    }

    // Method to search for a node with a specific value
    public boolean search(int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Method to print the contents of the Linked List
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main method to create a sample linked list and test methods
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.push(89);
        list.push(76);
        list.push(32);
        list.append(67);
        list.append(51);

        System.out.println("Created Linked List: ");
        list.printList();

        System.out.println("Deleting 3 from Linked List:");
        list.delete(32);
        list.printList();

        System.out.println("Searching for 2 in Linked List: " + list.search(89));
        System.out.println("Searching for 10 in Linked List: " + list.search(10));
    }
}
