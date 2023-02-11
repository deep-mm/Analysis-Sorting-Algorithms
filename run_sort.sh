if [ $1 = insertion ]; then
    # run insertion sort
elif [ $1 = merge ]; then
    # run merge sort
elif [ $1 = quick ]; then
    # run Quicksort
else
    echo "unknown sorting algorithm $1"
fi