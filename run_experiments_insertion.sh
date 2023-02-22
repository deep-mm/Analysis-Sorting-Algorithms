echo "n,comparison,runtime" > insertion.csv

# Array starting from 100000 to 10000000 with step 100000
for n in {1000..100000..1000}
do
    python random_permutation.py $n -b $n > random_$n.txt
    # Append n to the csv row before the sort output
    ./run_sort.sh insertion < <(tac random_$n.txt) >> insertion.csv
done