#! /usr/bin/env python3

"""
Allows user to create files with random permutations of distinct
integers, possibly divided into blocks so that integers in a block are
greater than those in the previous block
"""

import argparse
import sys
import random

def parse_arguments():
    parser = argparse.ArgumentParser(description="Generates a random sequence of"
                                     + " distinct integers, one per line")
    parser.add_argument("num_ints", help="number of integers in the output", type=int)
    parser.add_argument("-b", "--block_size",
                        help="size of each block: ints in a block are > those in the previous block",
                        type=int)
    parser.add_argument("-s", "--seed",
                        help="random seed; if not specified, system clock is used",
                        type=int)
    args = parser.parse_args()
    return args
                      
"""
@return a randomly permuted list of distinct integers in the range [bottom, top-1] 
"""
def permutation(bottom, top):
    output_list = [ i for i in range(bottom, top) ]
    random.shuffle(output_list)
    return output_list

if __name__ == '__main__':
    args = parse_arguments()
    num_ints = args.num_ints
    block_size = num_ints
    if args.block_size:
        block_size = args.block_size
    random.seed(args.seed)
    bottom_of_range = 1
    int_list = []
    while bottom_of_range <= num_ints:
        top = min(bottom_of_range + block_size, num_ints + 1)
        int_list.extend(permutation(bottom_of_range, top))
        bottom_of_range += block_size
    for i in int_list:
        print(i)

#  [Last modified: 2021 01 21 at 20:23:18 GMT]