package test.practice.ds;

public class MyLinkedList {

    Node head;

    public static MyLinkedList insert(MyLinkedList list, String data) {
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
        Node traversingNode = list.head;
        if (currentNode.next == null) {
            return currentNode;
        } else {
            int counter = 1;
            Node middleNode = list.head;
            while (traversingNode != null) {
                if (counter % 2 == 0) {
                    middleNode = middleNode.next;
                }
                traversingNode = traversingNode.next;
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
        Node middleNode = myList.getMiddleNode(myList);
        System.out.println(" Approach 1 middle node value is " + middleNode.data);

        Node middleNodeApproach2 = myList.getMiddleNodeApproach2(myList);
        System.out.println("middleNodeApproach2 = " + middleNodeApproach2.data);

        Node myRevLinkedList = myList.reverseLinkedList(myList);
        System.out.println("Printing rev linked list values");
        myList.printList(myRevLinkedList);

    }

    /* In this approach we use slow and fast pointers concept it means 
     slow pointer moves one step forward, fast pointer moves 2 steps at a time.
    when the fast pointer reaches last element then slow pointer is reaches to middle position
	*/
    public Node getMiddleNodeApproach2(MyLinkedList list) {
        Node slowPointer = list.head;
        Node fastPointer = list.head;
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;

    }
    /*
   1. Initialize three pointers prev as NULL, curr as head, and next as NULL.
2. Iterate through the linked list. In a loop, do the following:
    a.  Store the next node, next = curr -> next
    b.  Update the next pointer of curr to prev, curr -> next = prev
    c.  Update prev as curr and curr as next, prev = curr and curr = next
     */
    public Node reverseLinkedList(MyLinkedList list) {
        Node currentNode, prevNode, nextNode;
        // initializing currentNode, PrevNode, Next node with starting node head;
        currentNode = list.head;
        prevNode = null;
        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }

        return prevNode;
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(" " + node.data);
            node = node.next;
        }
    }
}
