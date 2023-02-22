#!/bin/bash

echo "n,comparison,runtime" > insertion_block.csv
echo "n,comparison,runtime" > merge_block.csv
echo "n,comparison,runtime" > quick_block.csv

# Array starting from 100000 to 10000000 with step 100000
for ((b=1;b<=10000;b+=100))
do
    python3 random_permutation.py 10000 -b $b > random_$b.txt
    # Append n to the csv row before the sort output
    ./run_sort.sh insertion < <(tac random_$b.txt) >> insertion_block.csv &
    ./run_sort.sh merge < <(tac random_$b.txt) >> merge_block.csv &
    ./run_sort.sh quick < <(tac random_$b.txt) >> quick_block.csv
done