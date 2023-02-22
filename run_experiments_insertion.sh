#!/bin/bash

echo "n,comparison,runtime" > insertion.csv

# Array starting from 100000 to 10000000 with step 100000
for ((n=1000;n<=100000;n+=1000))
do
    python3 random_permutation.py $n -b $n > random_$n.txt
    # Append n to the csv row before the sort output
    ./run_sort.sh insertion < <(tac random_$n.txt) >> insertion.csv
done