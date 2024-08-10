package test.practice.ds;

public class MyLinkedList {

	Node head;

	public static MyLinkedList insert(MyLinkedList list, String data)
	{
		// creating new node with input param 
		Node newNode = new Node(data);
		newNode.next = null;
		if (list.head == null) {
			list.head = newNode;
		} else {     // finding last node where next contains value as null
			Node lstNode = list.head;
			while (lstNode.next != null) {
				lstNode = lstNode.next;
			}
			lstNode.next = newNode;
		}
		
		return list;
	}
	
	private void getValues(MyLinkedList myList) {
		Node current_node = myList.head;
		while (current_node != null) {
			System.out.println(current_node.data);
			current_node = current_node.next;
		}

	}

	public Node getMiddleNode(MyLinkedList list) {
		Node currentNode = list.head;
		if(currentNode.next == null) {
			return currentNode;
		}
		else {
			int counter = 1;
			Node middleNode = list.head;
			while (head != null) {
				if (counter % 2 == 0) {
					middleNode = middleNode.next;
				}
				head = head.next;
				counter++;

			}
			return middleNode;
		}
	}
	public static void main(String[] args) {
		MyLinkedList myList = new MyLinkedList();
		myList.insert(myList, "1");
		myList.insert(myList, "2");
		myList.insert(myList, "3");
		myList.insert(myList, "4");
		myList.insert(myList, "5");
		myList.insert(myList, "6");

		System.out.println(myList);
		
		// displaying values
		myList.getValues(myList);
		System.out.println(" middle node value is "+myList.getMiddleNode(myList).data);
	}

}
