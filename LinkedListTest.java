import org.junit.Test;

public class LinkedListTest {

    public static LinkedList createOddElementsList(){
        LinkedList list = new LinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        list.head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        list.tail = node5;
        return list;
    }

    public static LinkedList createEvenElementsLinkedList(){
        LinkedList list = new LinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        list.head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        list.tail = node4;
        return list;
    }

    public static LinkedList createSingleElementLinkedList(){
        LinkedList list = new LinkedList();
        Node node1 = new Node(1);
        list.head = node1;
        list.tail = node1;
        return list;
    }

    public static LinkedList createEmptyLinkedList(){
        LinkedList list = new LinkedList();
        return list;
    }

    @Test
    public void testFindMid(){
        LinkedList oddElementsList = createOddElementsList();
        LinkedList evenElementsList = createEvenElementsLinkedList();
        LinkedList singleElementList = createSingleElementLinkedList();
        LinkedList emptyList = createEmptyLinkedList();

        Node midOdd = oddElementsList.findMid();
        Node midEven = evenElementsList.findMid();
        Node midSingle = singleElementList.findMid();
        Node midEmpty = emptyList.findMid();

        assert(midOdd.data == 3);
        assert(midEven.data == 3);
        assert(midSingle.data == 1);
        assert(midEmpty == null);
    }
}
