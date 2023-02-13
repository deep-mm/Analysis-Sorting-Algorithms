import java.util.Scanner;

public class InsertionSort {

  LinkedList list; //Store all the input data and the sorted list
  Scanner scanner; //Read user input
  Timer timer; //Used to calculate total time taken by an algorithm to run
  Comparison comparison; //Used to calculate the total number of comparisons by an algorithm

  public InsertionSort() {
    list = new LinkedList();
    scanner = new Scanner(System.in);
    timer = new Timer("Insertion Sort");
    comparison = new Comparison("Insertion Sort");
  }

  /*
   * Responsible for taking user input as list of integers
   * and providing output of sorted list, total time taken and number of comparisons
   */
  public void sortList() {
    timer.start();
    while (scanner.hasNextInt()) {
      int elementToInsert = scanner.nextInt();
      insertElement(elementToInsert);
    }
    timer.stop();
    System.out.println("Sorted List: ");
    this.list.printLinkedList();
    System.err.println(comparison.toString());
    System.err.println(timer.toString());
  }

  /*
   * Inserts a new element in a way that the updated list is sorted
   */
  public void insertElement(int element) {
    Node curr = this.list.head;
    Node prev = null;
    Node nodeToAdd = new Node(element);

    // If head is null or element to insert is less then head
    if (curr == null || nodeToAdd.compareTo(curr) == -1) {
      // Make the current element head
      nodeToAdd.next = curr;
      this.list.head = nodeToAdd;
      if (this.list.tail == null) {
        this.list.tail = this.list.head;
      }
      return;
    } else {
      prev = curr;
      curr = curr.next;
    }

    // Find a element in existing list such that the new element to insert is less than that
    while (curr != null) {
      if (nodeToAdd.compareTo(curr) == -1) {
        this.list.insertElementBtwnNodes(prev, nodeToAdd);
        return;
      }
      prev = curr;
      curr = curr.next;
    }

    // If the element wasn't inserted anywhere in existing list, it will be made the tail
    if (this.list.tail == null) {
      this.list.tail = nodeToAdd;
    } else {
      this.list.tail.next = nodeToAdd;
      this.list.tail = nodeToAdd;
    }
  }
}
