package linkedList;

import java.util.Scanner;

public class LinkedListUse {

	
	public static Node<Integer> takeInput() {
		//head is start pointer and tail is last node pointer
		
		//for only node both are null
		Node<Integer> head = null, tail = null;
		Scanner sc = new Scanner(System.in);
		
		int data = sc.nextInt();
		
		while(data != -1) {
			
			Node<Integer> newNode = new Node<Integer>(data);
			//setup of first node
			if(head == null) {
				//first element added
				head = newNode;	
				tail = newNode;
			}
			//traverse to last node and attach N.next = newN
			else {
				//starting from first node
//				Node<Integer> temp = head;
//				//baby steps
//				while(temp.next != null) {
//					temp = temp.next;
//				}
//				temp.next = newNode;	
				tail.next = newNode;
				tail = newNode; //or tail = tail.next
			}
			data = sc.nextInt();
		}
		return head;
	}
	
	
	public static void print(Node<Integer> head) {
		//stores head in case again needed
//		Node<Integer> temp = head;
		while(head != null) {
			System.out.print(head.data+" ");
			//traversing each node using head -> head.next
			head = head.next;
		}
//		head = temp;
//		while(head != null) {
//			System.out.print(head.data+" ");
//			//traversing each node using head -> head.next
//			head = head.next;
//		}
	}
	
	
	public static Node<Integer> insertAt(Node<Integer> head,int data, int pos) {
		Node<Integer> newNode = new Node<Integer>(data);
		
		if(pos == 0) {
			newNode.next = head;
			
			return newNode;
		}
		
		
		int i = 0;
		Node<Integer> temp = head;
		while( i < pos - 1 ) {
			temp = temp.next;
			i++;
		}
		newNode.next = temp.next;
		temp.next = newNode;
		
		return head;
	}
	
	
	public static Node<Integer> removeAt(Node<Integer> head,int pos){
		int i = 1;

		Node<Integer> temp = head;
		while( i < pos - 1) {
			temp = temp.next;
			i++;
		}
		int data = temp.data;
		temp.next = temp.next.next;
		return head;
	}
	
	public static int getLength(Node<Integer> head) {
		int length = 0;
		
		Node<Integer> temp= head;
		
		while(temp != null) {
			temp = temp.next;
			length++;
		}
		
		return length;
	}
	
	
	public static void main(String args[]) {
		
		Node<Integer> head = takeInput();
		head = insertAt(head, 80, 0);

		System.out.println("Adding 80 at 0th Posn");
		print(head);
		head = removeAt(head, 3);
		System.out.println();
		System.out.println("Removing third element!");
		print(head);
		System.out.println("Lenght of LinkedList : "+getLength(head));
		
//		Node<Integer> node1 = new Node<Integer>(10);
//		Node<Integer> node2 = new Node<Integer>(20);
//		Node<Integer> node3 = new Node<Integer>(30);
//		
//		//linking nodes
//		node1.next = node2;
//		node2.next = node3;
//		
//		//refs to first node
//		Node<Integer> heada = node1;
//		print(heada);
	}
}
