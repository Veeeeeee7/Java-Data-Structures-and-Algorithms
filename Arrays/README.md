# Arrays

-   a collection of elements of the same type stored in contiguous memory locations
-   determined size when created
-   elements can be accessed using an index

## Reverse Array

-   while loop O(n)
    -   use a start and end pointer and swap the values
-   recursive O(n)
    -   also use a start and end pointer to swap the values, but instead of a while loop, call the function recursively

## Rotate Array

-   Juggling Algorithm
    -   O(n) with O(1) space
    -   find the greatest common divisor of the array size and the number of rotations
    -   separate the array into set of size gcd/size
    -   each set contains numbers that are exactly gcd indices apart
    -   rotate each set
