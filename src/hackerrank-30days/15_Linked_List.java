/**
 * Complete the insert function in your editor so that it creates a new Node (pass data as the Node constructor argument) 
 * and inserts it at the tail of the linked list referenced by the head parameter. 
 * Once the new node is added, return the reference to the head node. 
 */
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node next;
	Node(int d) {
        data = d;
        next = null;
    }
}

class Solution {
	 public static Node insert(Node head,int data) {
        Node current = head;
        if (head == null) {
            head = new Node(data);
            return head;
        }
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
        return head;
    }
	
	public static void display(Node head) {
        Node start = head;
        while(start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int N = sc.nextInt();

        while(N-- > 0) {
            int ele = sc.nextInt();
            head = insert(head,ele);
        }
        display(head);
        sc.close();
    }
}