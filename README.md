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