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
  public LinkedList sortElements(LinkedList linkedList) { // In Progress
    LinkedList[] partitions = partition(linkedList);
    LinkedList left = partitions[0];
    LinkedList center = partitions[1];
    LinkedList right = partitions[2];

    left.tail.next = center.head;
    center.tail.next = right.head;

    return new LinkedList(left.head, right.tail);
  }

  public LinkedList[] partition(LinkedList list) {
    Node left = list.head; // Start left pointer from left most element
    Node mid = list.findMid(); // Get middle element
    Node last = list.tail; // Get last element
    Node right = mid; // Start right pointer from middle element

    Node pivot = getMedian(left, mid, last); // Get median of 3 elements and use it as a pivot
    Node equal = null; // Nodes equal to pivot
    Node equalHead = null; // Head of nodes equal to pivot

    Node leftPrev = null;
    Node rightPrev = null;
    int pivotIndicator = 2; // 0 - left, 1 - mid, 2 - right

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
      while (left.next != mid && left.compareTo(pivot) <= 0) {
        if (left.compareTo(pivot) == 0) addElementToPivotEqualList(
          equal,
          equalHead,
          left,
          leftPrev
        ); else leftPrev = left;

        left = left.next;
      }

      while (right != list.tail && right.compareTo(pivot) >= 0) {
        if (right.compareTo(pivot) == 0) addElementToPivotEqualList(
          equal,
          equalHead,
          right,
          rightPrev
        ); else rightPrev = right;

        right = right.next;
      }

      if (left.next != mid && right != list.tail) {
        boolean flag = false;
        if (left == list.head) {
          flag = true;
        }
        list.exchangeNodes(left, leftPrev, right, rightPrev);
        Node temp = left.next;
        leftPrev = right;
				rightPrev = left;
        left = right.next;
        right = temp;
        if (flag) {
          list.head = leftPrev;
        }
      } else break;
    }

    while (right != list.tail) {
      if (right.compareTo(pivot) == 0) addElementToPivotEqualList(
        equal,
        equalHead,
        right,
        rightPrev
      ); else if (right.compareTo(pivot) < 0) transferElement(
        right,
        rightPrev,
        left,
        leftPrev
      ); else rightPrev = right;

      right = right.next;
    }

    if (right == list.tail) {
      if (list.tail.compareTo(pivot) == 0) {
        right = rightPrev;
        right.next = null;
        list.tail = right;
      } else if (list.tail.compareTo(pivot) < 0) {
        leftPrev.next = right;
        right.next = left;
        leftPrev = right;

        right = rightPrev;
        right.next = null;
        list.tail = right;
      } else {
        rightPrev = right;
        right = right.next;
      }
    }

    while (left.next != mid) {
      if (left.compareTo(pivot) == 0) addElementToPivotEqualList(
        equal,
        equalHead,
        left,
        leftPrev
      ); else if (left.compareTo(pivot) > 0) transferElement(
        left,
        leftPrev,
        right,
        rightPrev
      ); else leftPrev = left;

      left = left.next;
    }

    if (left.compareTo(pivot) == 0) {
      addElementToPivotEqualList(equal, equalHead, left, leftPrev);
      left = leftPrev;
    } else if (left.compareTo(pivot) > 0) {
      leftPrev.next = left.next;
      left.next = right.next;
      right.next = left;
      rightPrev = right;
      right = right.next;
      left = leftPrev;
    }

    switch (pivotIndicator) {
      case 0:
        list.head = pivot.next;
        break;
      case 1:
        mid = mid.next;
        break;
      case 2:
        list.tail = right;
        break;
      default:
        break;
    }

    left.next = pivot;
    if (equalHead != null) {
      pivot.next = equalHead;
      equal.next = mid;
    } else {
      pivot.next = mid;
      equal = pivot;
    }

    return new LinkedList[] {
      new LinkedList(list.head, left),
      new LinkedList(pivot, equal),
      new LinkedList(mid, list.tail),
    };
  }

  public Node getMedian(Node n1, Node n2, Node n3) {
    List<Node> nodes = new ArrayList<>();
    nodes.add(n1);
    nodes.add(n2);
    nodes.add(n3);
    Collections.sort(nodes);
    return nodes.get(1);
  }

  /*
   * Add node to existing list of elements equal to the pivot
   */
  public void addElementToPivotEqualList(
    Node equal,
    Node equalHead,
    Node node,
    Node nodePrev
  ) {
    if (equal == null) {
      equal = node;
      equalHead = node;
    } else {
      equal.next = node;
      equal = equal.next;
    }

    nodePrev.next = node.next;
  }

  /*
   * Transfer node1 to node2.next
   */
  public void transferElement(
    Node node1,
    Node node1Prev,
    Node node2,
    Node node2Prev
  ) {
    Node temp = node1.next;
    node1.next = node2.next;
    node2.next = node1;
    node2Prev = node2;
    node2 = node2.next;
    node1Prev.next = temp;
  }
}
