import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class QuickSort {

  LinkedList list; //Store all the input data and the sorted list
  Node mid;
  Scanner scanner; //Read user input
  Timer timer; //Used to calculate total time taken by an algorithm to run
  Comparison comparison; //Used to calculate the total number of comparisons by an algorithm

  public QuickSort() {
    list = new LinkedList();
    mid = null;
    scanner = new Scanner(System.in);
    timer = new Timer("Quick Sort");
    comparison = new Comparison("Quick Sort");
  }

  /*
   * Responsible for taking user input as list of integers and adding it to the linked list,
   * and then sorting the linked list
   */
  public void sortList() {
    while (scanner.hasNextInt()) {
      int elementToInsert = scanner.nextInt();
      this.list.add(elementToInsert);
    }
    timer.start();
    this.list = sortElements(this.list);
    timer.stop();
    System.out.println("Sorted List: ");
    this.list.printLinkedList();
    System.err.println(comparison.toString());
    System.err.println(timer.toString());
  }

  /*
   * Perform quick sort on the elements in the linked list
   */
  private LinkedList sortElements(LinkedList linkedList) {
    if (linkedList.head == linkedList.tail) { // If list has just one element
      return linkedList;
    } else if (linkedList.head.next == linkedList.tail) { // If list has just two elements
      if (linkedList.head.compareTo(linkedList.tail) > 0) {
        linkedList.tail = linkedList.insertElementBtwnNodes(linkedList.tail, linkedList.head);
        return new LinkedList(linkedList.tail, linkedList.head);
      }
      else return linkedList;
    }

    LinkedList[] partitions = partition(linkedList);
    LinkedList left = sortElements(partitions[0]);
    LinkedList center = partitions[1];
    LinkedList right = sortElements(partitions[2]);

    if (left.head == null) left.head = center.head;
    else left.tail.next = center.head;

    if (right.head == null) right.tail = center.tail;
    else center.tail.next = right.head;

    return new LinkedList(left.head, right.tail);
  }

  /*
   * Partition the linked list into 3 parts:
   * 1. Less than Pivot
   * 2. Pivot and Equal to Pivot
   * 3. Greater than Pivot
   */
  public LinkedList[] partition(LinkedList list) {
    this.list = list;
    Node left = list.head; // Start left pointer from left most element
    mid = list.getMiddleElement(); // Get middle element
    Node last = list.tail; // Get last element
    Node right = mid; // Start right pointer from middle element

    Node pivot = getMedian(left, mid, last); // Get median of 3 elements and use it as a pivot
    LinkedList equal = new LinkedList(); // List to store all elements equal to pivot

    Node leftPrev = null;
    Node rightPrev = null;
    Node rightEndElement = null;
    int compare = 0;

    // If pivot is left element, move it to mid
    if (pivot == left) {
      left = left.next;
      pivot.next = mid.next;
      mid.next = pivot;
      list.head = left;
    }

    // If equal is last element, move it to mid
    if (pivot == list.tail) {
      pivot.next = mid.next;
      mid.next = pivot;
      rightEndElement = pivot;
    }

    mid = pivot;
    right = mid.next;
    rightPrev = mid;

    while (true) {
      if (right == pivot){
        rightPrev.next = null;
        right = null;
        rightEndElement = null;
      }

      // Iterate through right until last element or if an element smaller than pivot is found
      while (right != rightEndElement) {
        compare = right.compareTo(pivot);
        if (compare > 0){
          rightPrev = right;
          right = right.next;
        }
        else if (compare == 0) right = addToEqualElementsList(right, rightPrev, equal);
        else break;
      }

      // Iterate through left until mid or if an element larger than pivot is found
      while (left != mid) {
        compare = left.compareTo(pivot);
        if (compare < 0){
          leftPrev = left;
          left = left.next;
        }
        else if (compare == 0) left = addToEqualElementsList(left, leftPrev, equal);
        else break;
      }

      // Exchange elements based on conditions met
      if (left != mid && right != rightEndElement) {
        list.exchangeNodes(left, leftPrev, right, rightPrev); // Exchange left and right elements
        // Update pointers to next elements
        Node temp = left.next;
        leftPrev = right;
        rightPrev = left;
        left = right.next;
        right = temp;
      } else if (right != rightEndElement) { // If left has reached mid but right still has elements to check
        Node temp = right.next;
        leftPrev = transferElement(right, rightPrev, left, leftPrev);
        right = temp;
      } else if (left != mid) { // If right has reached last, but left still has elements to check
        Node temp = left.next;
        rightPrev = transferElement(left, leftPrev, right, rightPrev);
        left = temp;
      } else break;
    }

    if (right == pivot){
      rightPrev.next = null;
      right = null;
      rightEndElement = null;
    }

    // Update mid, pivot, list.head
    mid = mid.next;
    pivot.next = null;
    if (list.head == pivot) {
      list.head = null;
      leftPrev = null;
    }

    if (list.head == null) leftPrev = null;
    else if (leftPrev == list.head) leftPrev = list.head.next != null ? list.head.next : list.head;
    else leftPrev.next = null;

    if (mid == null) rightPrev = null;

    equal.add(pivot);

    // Return 3 linked lists, left, equal and right
    return new LinkedList[] {
      new LinkedList(list.head, leftPrev),
      new LinkedList(equal.head, equal.tail),
      new LinkedList(mid, rightPrev),
    };
  }

  /*
   * Get median of 3 nodes
   */
  public Node getMedian(Node n1, Node n2, Node n3) {
    List<Node> nodes = new ArrayList<>();
    nodes.add(n1);
    nodes.add(n2);
    nodes.add(n3);
    Collections.sort(nodes);
    return nodes.get(1);
  }

  /*
   * Transfer node1 to node2.next
   */
  public Node transferElement(
    Node node1,
    Node node1Prev,
    Node node2,
    Node node2Prev
  ) {
    if (list.head == node1) list.head = node1.next;

    if (node1Prev!=null) node1Prev.next = node1.next;
    node1.next = node2;
    
    if (node2Prev != null) node2Prev.next = node1;
    node2Prev = node1;

    return node2Prev;
  }

  /*
   * Remove element that is equal to pivot from the linked list and add to the equal list
   */
  public Node addToEqualElementsList(Node node, Node nodePrev, LinkedList equal) {
    Node temp = node.next;
    if (list.head == node) list.head = temp;
    if (nodePrev != null) nodePrev.next = temp;
    node.next = null;
    equal.add(node);
    return temp;
  }
}
