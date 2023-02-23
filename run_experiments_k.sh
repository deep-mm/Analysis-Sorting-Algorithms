#!/bin/bash

echo "n,comparison,runtime" > insertion_k2.csv
echo "n,comparison,runtime" > merge_k.csv
#echo "n,comparison,runtime" > quick_k.csv

# Array starting from 100000 to 10000000 with step 100000
for ((n=100;n<=10000;n+=100))
do
    # Create variable b with value $n/2
    b=$((n/5))
    python3 random_permutation.py $n -b $b > random_$n.txt
    # Append n to the csv row before the sort output
    ./run_sort.sh insertion < <(tac random_$n.txt) >> insertion_k2.csv &
    ./run_sort.sh merge < <(tac random_$n.txt) >> merge_k.csv
    #./run_sort.sh quick < <(tac random_$n.txt) >> quick_k.csv
done