public class Node implements Comparable<Node> {

  int data; // Stores integer data
  Node next; // Pointer to the next element

  public Node(int data) {
    this.data = data;
    this.next = null;
  }

  @Override
  public int compareTo(Node otherNode) {
      Sort.compareCount+=1;
      return Integer.compare(this.data, otherNode.data);
  }
}
