echo "n,comparison,runtime" > insertion.csv
echo "n,comparison,runtime" > merge.csv
echo "n,comparison,runtime" > quick.csv

# Array starting from 100000 to 10000000 with step 100000
for n in {100000..10000000..100000}
do
    python random_permutation.py $n -b $n > random_$n.txt
    # Append n to the csv row before the sort output
    #./run_sort.sh insertion < <(tac random_$n.txt) >> insertion.csv &
    ./run_sort.sh merge < <(tac random_$n.txt) >> merge.csv &
    ./run_sort.sh quick < <(tac random_$n.txt) >> quick.csv
done