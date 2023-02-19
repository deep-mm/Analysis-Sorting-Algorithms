import java.util.Scanner;

public class MergeSort {

  LinkedList list; //Store all the input data and the sorted list
  Scanner scanner; //Read user input
  Timer timer; //Used to calculate total time taken by an algorithm to run
  Comparison comparison; //Used to calculate the total number of comparisons by an algorithm

  public MergeSort() {
    list = new LinkedList();
    scanner = new Scanner(System.in);
    timer = new Timer("Merge Sort");
    comparison = new Comparison("Merge Sort");
  }

  /*
   * Responsible for taking user input as list of integers and adding it to the linked list,
   * and then sorting the linked list
   */
  public void sortList() {

    while (scanner.hasNextInt()) {
      int newElement = scanner.nextInt();
      this.list.add(newElement);
    }

	timer.start();
    this.list = sortElements(this.list);
    timer.stop();
    
    System.out.println("Sorted List: ");
    this.list.printLinkedList();
    System.err.println(comparison.toString());
    System.err.println(timer.toString());
  }

  public LinkedList sortElements(LinkedList localList){
	
	Node middleElement = localList.findMid();
	Node tempMiddleNextElement = middleElement.next;
	middleElement.next = null;

	if(localList.head == middleElement){
		return localList;
	}
	
	if(localList.tail == middleElement){
		int result = localList.head.compareTo(middleElement);
		if(result == 1){
			middleElement.next = localList.head;
			localList.head.next = null;
			return new LinkedList(middleElement,localList.head);
		}
		else{
			return localList;
		}
	}

	LinkedList leftSortedList = sortElements(new LinkedList(localList.head,middleElement));
	LinkedList rightSortedList = sortElements(new LinkedList(tempMiddleNextElement, localList.tail));

	return merge(leftSortedList,rightSortedList);
  }

  public LinkedList merge(LinkedList left, LinkedList right){

	Node rightPrevPointer = null;
	Node leftPointer = left.head;
	Node rightPointer = right.head;
	Node startPointer = null;

	while(leftPointer != null && rightPointer != null){
		int result = leftPointer.compareTo(rightPointer);

		if(startPointer == null){
			if(result == 1){
				startPointer = right.head;
			}
			else{
				startPointer = left.head;
			}
		}

		if(result == -1){
			Node tempNextLeft = leftPointer.next;
			if(rightPrevPointer == null){
				leftPointer.next = rightPointer;
				rightPrevPointer = leftPointer;
			}
			else{
				rightPrevPointer = right.insertElementBtwnNodes(rightPrevPointer, leftPointer).next;
			}
			leftPointer = tempNextLeft;
		}
		else {
			rightPrevPointer = rightPointer;
			rightPointer = rightPointer.next;
		}
	}

	if(leftPointer != null){
		rightPrevPointer.next = leftPointer;
		return new LinkedList(startPointer,left.tail);
	}

	return new LinkedList(startPointer,rightPointer);
  }
}
