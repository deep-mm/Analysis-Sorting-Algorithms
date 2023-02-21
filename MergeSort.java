import java.util.Scanner;

public class MergeSort {

  LinkedList list; 
  Scanner scanner; 
  Timer timer; 
  Comparison comparison; 

	/*
   * Constructor for MergeSort class
   * - Initializes the linked list, scanner, timer and comparison objects
   * - The linked list is used to store the input data and the sorted list
   * - The scanner is used to read user input
   * - The timer is used to calculate the total time taken by an algorithm to run
   * - The comparison is used to calculate the total number of comparisons by an algorithm
   */
  public MergeSort() {
    list = new LinkedList();
    scanner = new Scanner(System.in);
    timer = new Timer("Merge Sort");
    comparison = new Comparison("Merge Sort");
  }

  /* Main method
   * - reads the input data from the user
   * - sorts the input data using the merge sort algorithm
   * - prints the sorted list
   * - prints the total time taken by the algorithm to run
   */
  public void sortList() {

	// Read the input data from the user
    while (scanner.hasNextInt()) {
      int newElement = scanner.nextInt();
      this.list.add(newElement);
    }

	// Sorts the elements as well as tracks the time taken by the algorithm to run
	timer.start();
    this.list = sortElements(this.list);
    timer.stop();
    
	// Prints the sorted list
    System.out.println("Sorted List: ");
    this.list.printLinkedList();

	// Prints the total time and comparisons taken by the algorithm to run
    System.err.println(comparison.toString());
    System.err.println(timer.toString());
  }

  /*  
  	Recursive method to split the list into two halves and calls the merge method at the end
  */
  public LinkedList sortElements(LinkedList localList){
	
	// Gets the middle element of the list and splits the list into two halves
	Node middleElement = localList.findMid();
	Node tempMiddleNextElement = middleElement.next;
	middleElement.next = null;

	// Base case: If only one element is present in the list, return the list
	if(localList.head == middleElement){
		return localList;
	}
	
	// Base case: If only two elements are present in the list, compare the two elements and return the list
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

	// Recursive call to sort the elements of the left and right halves of the list
	LinkedList leftSortedList = sortElements(new LinkedList(localList.head,middleElement));
	LinkedList rightSortedList = sortElements(new LinkedList(tempMiddleNextElement, localList.tail));

	// Merges the two sorted lists and returns the merged list
	return merge(leftSortedList,rightSortedList);
  }

  /* 
  	Iterative method to merge the two sorted lists
	- Compares the elements of left and right lists and manages the right list as the final merged list 
  */ 
  public LinkedList merge(LinkedList left, LinkedList right){

	Node rightPrevPointer = null;
	Node leftPointer = left.head;
	Node rightPointer = right.head;
	Node startPointer = null;

	//Iterates through the left and right lists till any one of the list is empty
	while(leftPointer != null && rightPointer != null){
		int result = leftPointer.compareTo(rightPointer);

		//Used to set the start pointer of the merged list
		if(startPointer == null){

			//If the first element of the right list is smaller than the first element of the left list
			if(result >= 0){
				startPointer = right.head;
			}
			else{
				startPointer = left.head;
			}
		}

		//If the element of the left list is smaller than the element of the right list
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

	//If the right list is empty, append the left list to the right list and return the merged list
	if(leftPointer != null){
		rightPrevPointer.next = leftPointer;
		return new LinkedList(startPointer,left.tail);
	}

	//returns the merged list
	return new LinkedList(startPointer,rightPointer);
  }
}
