public class Comparison {

    String name; //Name of the sorting algorithm
    int count; //Maintains the total count of comparisons

    public Comparison (String name) {
        this.name = name;
        this.count = 0;
    }

    /*
     * Increment the comparison count by one
     */
    public void increment (){
        this.count++;
    }

    /*
     * Return total number of current comparisons
     */
    public int getTotalComparisons (){
        return this.count;
    }

    /*
     * Print the algorithm name and total current comparisons
     */
    public String toString() {
        return String.format(this.name + "\tcomparisons\t" + getTotalComparisons());
    }
}