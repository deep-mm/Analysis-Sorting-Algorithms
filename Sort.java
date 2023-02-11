public class Sort {

    public static void main (String args[]){
        switch (args[0]){
            case "insertion":
                InsertionSort insertionSort = new InsertionSort();
                insertionSort.sortList();
                break;
            default:
                System.out.println("Please enter a valid sorting algorithm");
        }
    }
}