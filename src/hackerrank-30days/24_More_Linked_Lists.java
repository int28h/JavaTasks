/**
 * A Node class is provided for you in the editor. A Node object has an integer data field, data, 
 * and a Node instance pointer, next, pointing to another node (i.e.: the next node in a list).
 *
 * A removeDuplicates function is declared in your editor, which takes a pointer to the head node 
 * of a linked list as a parameter. Complete removeDuplicates so that it deletes any duplicate nodes 
 * from the list and returns the head of the updated list.
 *
 * Note: The head pointer may be null, indicating that the list is empty. 
 * Be sure to reset your pointer when performing deletions to avoid breaking the list.
 */
import java.io.*;
import java.util.*;
class Node{
	int data;
	Node next;
	Node(int d){
        data=d;
        next=null;
    }
	
}
class Solution {
	public static Node removeDuplicates(Node head) {
        Node current = head;
        while(current.next != null){
            if(current.data != current.next.data) {
                current = current.next;
            } else {
                Node temp = current.next.next;
                current.next = temp;
            }        
        }
        return head;
    }
	
	public static  Node insert(Node head,int data) {
		Node p=new Node(data);			
        if(head==null)
            head=p;
        else if(head.next==null)
            head.next=p;
        else {
            Node start=head;
            while(start.next!=null)
                start=start.next;
            start.next=p;

        }
        return head;
    }
	
    public static void display(Node head) {
		Node start=head;
		while(start!=null) {
			System.out.print(start.data+" ");
			start=start.next;
		}
	}
	
    public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		Node head=null;
		int T=sc.nextInt();
		while(T-->0){
			int ele=sc.nextInt();
			head=insert(head,ele);
		}
		head=removeDuplicates(head);
		display(head);
	}
}
	
	