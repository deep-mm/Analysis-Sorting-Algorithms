# Analysis-Sorting-Algorithms
This repository contains programs to analyze and compare various sorting algorithms

Compile java program:
```
javac Sort.java
```

To create an input file with random numbers:
```
python random_permutation.py 10000 -b 5 > random.txt
```

To use sorting algorithm:
```
./run_sort.sh {name_of_algo, e.g. insertion} < <(tac random.txt)
```

Running tests on the sample files provided:
```
1) Go to Github Actions
2) Run the workflow "Run-File-Tests"
3) Monitor the progress for the jobs 

This will run the insertion, merge and quick sort on all of the sample input files provided.
```

Following java source code files are present as part of this directory:
1. Node.java
2. LinkedList.java
3. Timer.java
4. Comparison.java
5. Sort.java
6. InsertionSort.java
7. QuickSort.java
8. MergeSort.java

collaborators.csv: Contains names of project's contributors

random_permutation.py: Generates random numbers based on input parameters

run_sort.sh: Shell script to run the sorting algorithms which takes input as a file containing input values

run_experiments.ipynb: This file contains all the graphs that were generated as part of the experiments performed on the various sorting algorithms

github_workflows directory contains the following two workflows that can be ran on GitHub:

1. Run-File-Tests: This workflow runs all the tests and ensures the algorithm has output as expected
2. Analysis-Sorting-Algorithm: This workflow allows to run any algorithm on any input or generate input by providing number of inputs and block size

Inputs directory contains all the pre-defined input files that can be used to test the algorithms.

Experiments directory contains the csv outputs generated as part of the experiments and the shell scripts which were used to perform various experiments.