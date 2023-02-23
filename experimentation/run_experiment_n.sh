#!/bin/bash

echo "n,comparison,runtime" > insertion_n.csv
echo "n,comparison,runtime" > merge_n.csv
echo "n,comparison,runtime" > quick_n.csv

python3 random_permutation.py 1000 -b 500 > random_n.txt

# Array starting from 100000 to 10000000 with step 100000
for ((n=1;n<=10;n+=1))
do
    # Append n to the csv row before the sort output
    ./run_sort.sh insertion < <(tac random_n.txt) >> insertion_n.csv &
    ./run_sort.sh merge < <(tac random_n.txt) >> merge_n.csv &
    ./run_sort.sh quick < <(tac random_n.txt) >> quick_n.csv
done