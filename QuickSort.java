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
    sortElements();
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
  public void sortElements() {}
}
