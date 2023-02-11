public class Comparison {

    String name;
    int count;

    public Comparison (String name) {
        this.name = name;
        this.count = 0;
    }

    public void increment (){
        this.count++;
    }

    public int getTotalComparisons (){
        return this.count;
    }

    public String toString() {
        return String.format(this.name + "\tcomparisons\t" + getTotalComparisons());
    }
}