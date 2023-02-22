mkdir logs
./run_sort.sh quick < <(tac inputs/100_reversed.txt) > logs/100_reversed_quick.log &
./run_sort.sh quick < <(tac inputs/100_sorted.txt) > logs/100_sorted_quick.log &
./run_sort.sh quick < <(tac inputs/b_1000000_1000.txt) > logs/b_1000000_1000_quick.log &
./run_sort.sh quick < <(tac inputs/five_worst.txt) > logs/five_worst_quick.log &
./run_sort.sh quick < <(tac inputs/r_128_01.txt) > logs/r_128_01_quick.log &
./run_sort.sh quick < <(tac inputs/sixteen.txt) > logs/sixteen_quick.log &
./run_sort.sh quick < <(tac inputs/sixteen_reversed.txt) > logs/sixteen_reversed_quick.log &
./run_sort.sh quick < <(tac inputs/zr_1000000.txt) > logs/zr_1000000_quick.log &
./run_sort.sh quick < <(tac inputs/zr_5000000.txt) > logs/zr_5000000_quick.log &
./run_sort.sh insertion < <(tac inputs/100_reversed.txt) > logs/100_reversed_insertion.log &
./run_sort.sh insertion < <(tac inputs/100_sorted.txt) > logs/100_sorted_insertion.log &
./run_sort.sh insertion < <(tac inputs/b_1000000_1000.txt) > logs/b_1000000_1000_insertion.log &
./run_sort.sh insertion < <(tac inputs/five_worst.txt) > logs/five_worst_insertion.log &
./run_sort.sh insertion < <(tac inputs/r_128_01.txt) > logs/r_128_01_insertion.log &
./run_sort.sh insertion < <(tac inputs/sixteen.txt) > logs/sixteen_insertion.log &
./run_sort.sh insertion < <(tac inputs/sixteen_reversed.txt) > logs/sixteen_reversed_insertion.log &
./run_sort.sh merge < <(tac inputs/100_reversed.txt) > logs/100_reversed_merge.log &
./run_sort.sh merge < <(tac inputs/100_sorted.txt) > logs/100_sorted_merge.log &
./run_sort.sh merge < <(tac inputs/b_1000000_1000.txt) > logs/b_1000000_1000_merge.log &
./run_sort.sh merge < <(tac inputs/five_worst.txt) > logs/five_worst_merge.log &
./run_sort.sh merge < <(tac inputs/r_128_01.txt) > logs/r_128_01_merge.log &
./run_sort.sh merge < <(tac inputs/sixteen.txt) > logs/sixteen_merge.log &
./run_sort.sh merge < <(tac inputs/sixteen_reversed.txt) > logs/sixteen_reversed_merge.log &
./run_sort.sh merge < <(tac inputs/zr_1000000.txt) > logs/zr_1000000_merge.log &
./run_sort.sh merge < <(tac inputs/zr_5000000.txt) > logs/zr_5000000_merge.log
