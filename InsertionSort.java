import java.util.Scanner;

public class InsertionSort {

    LinkedList list;
    Scanner scanner;
    Timer timer;
    Comparison comparison;
    
    public InsertionSort (){
        list = new LinkedList();
        scanner = new Scanner(System.in);
        timer = new Timer("Insertion Sort");
        comparison = new Comparison ("Insertion Sort");
    }

    public void sortList(){
        timer.start();
        while (scanner.hasNextInt()){
            int elementToInsert = scanner.nextInt();
            insertElement(elementToInsert);
        }
        timer.stop();
        this.list.printLinkedList();
        System.err.println(comparison.toString());
        System.err.println(timer.toString());
    }

    public void insertElement (int element){
        Node curr = this.list.head;
        Node prev = null;
        Node nodeToAdd = new Node(element);
        if (curr == null || element < curr.data){
            nodeToAdd.next = curr;
            this.list.head = nodeToAdd;
            if (this.list.tail == null){
                this.list.tail = this.list.head;
            }
            return;
        }
        else{
            prev = curr;
            curr = curr.next;
        }
        comparison.increment();

        while (curr!=null){
            if (element < curr.data){
                this.list.insertElementBtwnNodes(prev, nodeToAdd);
                return;
            }
            prev = curr;
            curr = curr.next;
            comparison.increment();
        }

        if (this.list.tail == null){
            this.list.tail = nodeToAdd;
        }
        else{
            this.list.tail.next = nodeToAdd;
            this.list.tail = nodeToAdd;
        }
        comparison.increment();
    }
}