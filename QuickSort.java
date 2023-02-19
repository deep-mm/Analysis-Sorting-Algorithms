import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class QuickSort {

  LinkedList list; //Store all the input data and the sorted list
  Scanner scanner; //Read user input
  Timer timer; //Used to calculate total time taken by an algorithm to run
  Comparison comparison; //Used to calculate the total number of comparisons by an algorithm

  public QuickSort() {
    list = new LinkedList();
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
        linkedList.insertElementBtwnNodes(linkedList.tail, linkedList.head);
        return new LinkedList(linkedList.tail, linkedList.head);
      }
      else return linkedList;
    }

    LinkedList[] partitions = partition(linkedList);
    LinkedList left = sortElements(partitions[0]);
    LinkedList center = partitions[1];
    LinkedList right = sortElements(partitions[2]);

    if (left.head == null) left.head = center.head; else left.tail.next =
      center.head;
    center.tail.next = right.head;

    return new LinkedList(left.head, right.tail);
  }

  /*
   * Partition the linked list into 3 parts:
   * 1. Less than Pivot
   * 2. Pivot and Equal to Pivot
   * 3. Greater than Pivot
   */
  public LinkedList[] partition(LinkedList list) {
    Node left = list.head; // Start left pointer from left most element
    Node mid = list.findMid(); // Get middle element
    Node last = list.tail; // Get last element
    Node right = mid; // Start right pointer from middle element

    Node pivot = getMedian(left, mid, last); // Get median of 3 elements and use it as a pivot
    LinkedList equal = new LinkedList(); // List to store all elements equal to pivot

    Node leftPrev = null;
    Node rightPrev = null;
    int pivotIndicator = 2; // 0 - left, 1 - mid, 2 - right
    int compare = 0;

    if (left == pivot) {
      leftPrev = left;
      left = left.next;
      pivotIndicator = 0;
    } else if (right == pivot) {
      rightPrev = right;
      right = right.next;
      pivotIndicator = 1;
    }

    while (true) {
      compare = left.compareTo(pivot);
      while (left != mid && compare <= 0) {
        if (compare == 0) {
          equal.add(left);
          if (leftPrev == null) leftPrev = left; else leftPrev.next = left.next;
        } else leftPrev = left;

        left = left.next;
        compare = left.compareTo(pivot);
      }

      compare = right.compareTo(pivot);
      while (right != list.tail && compare >= 0) {
        if (compare == 0) {
          equal.add(right);
          if (rightPrev == null) rightPrev = right; else rightPrev.next =
            right.next;
        } else rightPrev = right;

        right = right.next;
        compare = right.compareTo(pivot);
      }

      if (left != mid && right != list.tail) {
        boolean flag = false;
        if (left == list.head) flag = true;

        list.exchangeNodes(left, leftPrev, right, rightPrev); // Exchange left and right elements
        if (right == mid) mid = mid.next;
        // Update pointers to next elements
        Node temp = left.next;
        leftPrev = right;
        rightPrev = left;
        left = right.next;
        right = temp;

        if (flag) list.head = leftPrev;
      } else if (right != list.tail) {
        Node temp = right.next;

        boolean flag = false;
        if (left == list.head) flag = true;

        leftPrev = transferElement(right, rightPrev, left, leftPrev);
        if (right == mid) mid = mid.next;
        right = temp;

        if (flag) list.head = leftPrev != null ? leftPrev : left;
      } else if (left != mid) {
        Node temp = left.next;

        boolean flag = false;
        if (left == list.head) flag = true;

        rightPrev = transferElement(left, leftPrev, right, rightPrev);
        left = temp;

        if (flag) list.head = leftPrev != null ? leftPrev : left;
      } else break;
    }

    compare = right.compareTo(pivot);
    if (compare <= 0) {
      Node temp = rightPrev;
      if (compare == 0 && pivotIndicator != 2) equal.add(right); 
      else if (compare < 0) {
        boolean flag = false;
        if (left == list.head) flag = true;

        leftPrev = transferElement(right, rightPrev, left, leftPrev);
        if (right == mid) mid = mid.next;

        if (flag) list.head = leftPrev != null ? leftPrev : left;
      }

      right = temp;
      right.next = null;
      list.tail = right;
    }

    switch (pivotIndicator) {
      case 0:
        list.head = pivot.next;
        break;
      case 1:
        mid = mid.next;
        break;
      case 2:
        list.tail = rightPrev;
        break;
      default:
        break;
    }

    if (list.head == mid) {
      list.head = null;
      leftPrev = null;
    } else leftPrev.next = null;
    pivot.next = null;
    equal.add(pivot);
    list.tail.next = null;

    return new LinkedList[] {
      new LinkedList(list.head, leftPrev),
      new LinkedList(equal.head, equal.tail),
      new LinkedList(mid, list.tail),
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
    // if (node2.next == node1) return node2Prev;
    if (node1Prev!=null) node1Prev.next = node1.next;

    node1.next = node2;
    if (node2Prev != null) node2Prev.next = node1;
    node2Prev = node1;

    return node2Prev;
  }
}
