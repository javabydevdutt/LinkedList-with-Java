package com.devdutt.linear;

public class LinkedList {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }//contructor
    }//node

    private Node head;
    private Node tail;

    //Operation:01 Insertion
    //Add at Beginning
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    //Add at Last
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    //Add at Middle
    public void add(int pos, int data) {
        int count = 1;
        Node currentNode = head;
        if (pos == 1) {
            addFirst(data);
            return;
        }
        while (count < pos - 1) {
            count++;
            currentNode = currentNode.next;
        }
        Node newNode = new Node(data);
        newNode.next = currentNode.next;
        currentNode.next = newNode;

    }

    //Operation:02-Deletion
    //Delete at Beginning
    public int deleteFirst() {
        if (isEmpty()) {
            throw new RuntimeException("List is Empty");
        }
        Node curretNode = head;
        head = head.next;
        curretNode.next = null;
        if (isEmpty()) {
            tail = null;
        }
        return curretNode.data;
    }

    //Delete at Last
    public int deleteLast() {
        if (isEmpty()) {
            throw new RuntimeException("List is Empty");
        }

        if (head == tail) {
            int val = head.data;
            head = null;
            tail = null;
            return val;
        }
        Node currentNode = head;
        Node previousNode = null;
        while (currentNode.next != null) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        previousNode.next = null;
        tail = previousNode;
        return currentNode.data;
    }

    //Delete at Middle
    public int delete(int pos) {
        if (isEmpty()) {
            throw new RuntimeException("List is Empty");
        }
        if (pos == 1) {
            deleteFirst();
        }
        Node currentNode = head;
        Node previousNode = null;
        int count = 1;

        while (count < pos) {
            count++;
            previousNode = currentNode;
            currentNode = currentNode.next;
        }//while
        previousNode.next = currentNode.next;
        currentNode.next = null;
        return currentNode.data;
    }

    //Operation:03- Searching
    public boolean search(int data) {
        Node currentNode = head;
        while (currentNode != null) {
            if (data == currentNode.data) {
                return true;
            }
            currentNode = currentNode.next;
        }//while
        return false;
    }

    //check List is empty or not
    public boolean isEmpty() {
        return head == null;
    }

    //Print the LinkedList
    public void print() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + "->");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    // Driver Method
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.addFirst(20);
        System.out.print("After Adding 20 at First : ");
        ll.print();

        ll.addFirst(10);
        System.out.print("After Adding 10 at First : ");
        ll.print();

        ll.addLast(30);
        System.out.print("After Adding 30 at Last  : ");
        ll.print();

        ll.addLast(40);
        System.out.print("After Adding 40 at Last  : ");
        ll.print();

        ll.addFirst(5);
        System.out.print("After Adding  5 at First : ");
        ll.print();

        ll.add(4, 25);
        System.out.print("After Adding 25 at Pos 4 : ");
        ll.print();

        ll.deleteFirst();
        System.out.print("After Deleting First Node: ");
        ll.print();

        ll.deleteLast();
        System.out.print("After Deleting Last Node : ");
        ll.print();

        ll.delete(3);
        System.out.print("After Deleting Node at pos 3 : ");
        ll.print();
    }//main
}//customLinkedList
