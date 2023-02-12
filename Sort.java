public class Sort {

    public static void main (String args[]){
        switch (args[0]){
            case "insertion": // Insertion Sort
                InsertionSort insertionSort = new InsertionSort();
                insertionSort.sortList();
                break;
            case "merge":
                // Run Merge Sort
                break;
            case "quick":
                // Run Quick Sort
                break;
            default:
                System.out.println("Please enter a valid sorting algorithm");
        }
    }
}