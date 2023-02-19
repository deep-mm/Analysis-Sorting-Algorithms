public class Comparison {

  String name; //Name of the sorting algorithm

  public Comparison(String name) {
    this.name = name;
    Sort.compareCount = 0;
  }

  /*
   * Return total number of current comparisons
   */
  public int getTotalComparisons() {
    return Sort.compareCount;
  }

  /*
   * Print the algorithm name and total current comparisons
   */
  public String toString() {
    return String.format(this.name + "\tcomparisons\t" + getTotalComparisons());
  }
}
