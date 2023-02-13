import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
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
      insertElement(elementToInsert);
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
   * Inserts a new element at the end of existing list
   */
  public void insertElement(int element) {
    Node head = this.list.head;
    Node nodeToAdd = new Node(element);

    if (head == null) {
      this.list.head = nodeToAdd;
      this.list.tail = nodeToAdd;
    } else {
      this.list.tail.next = nodeToAdd;
      this.list.tail = nodeToAdd;
    }
  }

  /*
   * Perform quick sort on the elements in the linked list
   */
  public LinkedList sortElements(LinkedList linkedList) { // In Progress
    Node first = linkedList.head;
    Node mid = linkedList.findMid();
    Node last = linkedList.tail;
    
    Node median = getMedian(first, mid, last);

    System.out.println("Median: " + median.data);

    return linkedList;
  }

  public Node getMedian(Node n1, Node n2, Node n3){
    List<Node> nodes = new ArrayList<Node>();
    nodes.add(n1);
    nodes.add(n2);
    nodes.add(n3);
    Collections.sort(nodes);
    return nodes.get(1);
  }
}
