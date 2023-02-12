public class LinkedList {

  Node head; // Pointer to the head of linked list
  Node tail; // Pointer to the tail of linked list

  public LinkedList() {
    this.head = null;
  }

  /*
   * Add a new element to the linked list
   */
  public void add(int element) {
    Node newElement = new Node(element);
    this.tail.next = newElement;
    this.tail = newElement;
  }

  /*
   * Return head of linked list
   */
  public Node getLinkedList() {
    return this.head;
  }

  /*
   * Return tail of linked list
   */
  public Node getLastElement() {
    return this.tail;
  }

  /*
   * Insert element in between 2 nodes
   */
  public Node insertElementBtwnNodes(Node existing, Node toAdd) {
    Node temp = existing.next;
    existing.next = toAdd;
    toAdd.next = temp;
    return existing;
  }

  /*
   * Print the linked list
   */
  public void printLinkedList() {
    Node curr = head;
    while (curr != null) {
      System.out.println(curr.data);
      curr = curr.next;
    }
  }

  /*
   * This function returns the middle node of the linked list
   */
  public Node findMid() {
    Node first = this.head;
    Node second = this.head;

    while (second!=this.tail){
      if (second.next.next == null){
        second = second.next;
      }
      else{
        second = second.next.next;
      }

      first = first.next;
    }

    return first;
  }
}
