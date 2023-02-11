public class LinkedList {

    Node head;
    Node tail;

    public LinkedList (){
        this.head = null;
    }

    public void add(int element){
        Node newElement = new Node (element);
        this.tail.next = newElement;
        this.tail = newElement;
    }

    public Node getLinkedList() {
        return this.head;
    }

    public Node getLastElement() {
        return this.tail;
    }

    public Node insertElementBtwnNodes(Node existing, Node toAdd) {
        Node temp = existing.next;
        existing.next = toAdd;
        toAdd.next = temp;
        return existing;
    }

    public void printLinkedList(){
        Node curr = head;
        while (curr != null){
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
}