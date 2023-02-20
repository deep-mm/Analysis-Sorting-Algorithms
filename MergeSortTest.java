import org.junit.Test;

public class MergeSortTest {
    @Test
    public void testMerge(){
        LinkedList left = new LinkedList();
        LinkedList right = new LinkedList();
        LinkedList finalList = new LinkedList();

        Node left_node1 = new Node(0);
        Node left_node2 = new Node(0);
        Node right_node3 = new Node(0);

        Node node1 = new Node(0);
        Node node2 = new Node(0);
        Node node3 = new Node(0);

        left.head = left_node1;
        left_node1.next = left_node2;
        left.tail = left_node2;

        right.head = right_node3;
        right.tail = right_node3;

        finalList.head = node1;
        node1.next = node2;
        node2.next = node3;
        finalList.tail = node3;

        MergeSort mergeSort = new MergeSort();
        LinkedList mergedList = mergeSort.merge(left,right);
        assert(mergedList.head.data == finalList.head.data);
        assert(mergedList.tail.data == finalList.tail.data);
        assert(mergedList.head.next.data == finalList.head.next.data);
    }    
}
