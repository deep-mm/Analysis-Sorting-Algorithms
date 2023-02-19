public class LinkedList {

  Node head; // Pointer to the head of linked list
  Node tail; // Pointer to the tail of linked list

  public LinkedList() {
    this.head = null;
    this.tail = null;
  }

  public LinkedList(Node head, Node tail) {
    this.head = head;
    this.tail = tail;
  }

  /*
   * Add a new element to the linked list
   */
  public void add(int element) {
    Node newElement = new Node(element);
    if(this.head == null){
      this.head = newElement;
    }
    else{
      this.tail.next = newElement;
    }
    this.tail = newElement;
  }

  /*
   * Add a new node to the linked list
   */
  public void add(Node element) {
    if(this.head == null){
      this.head = element;
    }
    else{
      this.tail.next = element;
    }
    this.tail = element;
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
    if(existing == this.tail){
      this.tail = toAdd;
    }
    Node temp = existing.next;
    existing.next = toAdd;
    toAdd.next = temp;
    return existing;
  }

  /*
   * Exchange 2 nodes
   */
  public void exchangeNodes(Node first, Node firstPrev, Node second, Node secondPrev) {
    if (firstPrev != null && firstPrev != second)
      firstPrev.next = second;
    
    if (secondPrev != null && secondPrev != first)
      secondPrev.next = first;

    Node temp = first.next;
    first.next = second.next;
    second.next = temp == second ? first : temp;
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