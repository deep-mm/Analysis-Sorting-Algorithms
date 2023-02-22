public class Sort {

  public static long compareCount;

  public static void main(String args[]) {
    switch (args[0]) {
      case "insertion": // Insertion Sort
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sortList();
        break;
      case "merge":
        MergeSort mergeSort = new MergeSort();
        mergeSort.sortList();
        break;
      case "quick":
        QuickSort quickSort = new QuickSort();
        quickSort.sortList();
        break;
      default:
        System.out.println("Please enter a valid sorting algorithm");
        break;
    }
  }
}
