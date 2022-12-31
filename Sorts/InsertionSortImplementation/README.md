# Insertion Sort

Create a sorted array and add the first number to the sorted array. Then take the second number and traverse the sorted array from right to left until you find a number that is smaller than or equal to the current number (or the first index of the sorted array).

ex. -15, 20, 35 and insert 7

-15, 20, 35, **7** &larr; 7 is added to the sorted array at the last index

-15, 20, **7**, 35 &larr; 7 is compared to 35 and because 35 is greater than 7, it is shifted left

-15, **7**, 20, 35 &larr; 7 is compared to 20 and because 20 is greater than 7, it is shifted left

-15, **7**, 20, 35 &larr; 7 is compared to -15 and because -15 is smaller than 7, the loop ends

This continues until all the numbers in the original array are inserted into the sorted array.

-   In-place algorithm
-   O(n<sup>2</sup>) time complexity
    -   100 steps to sort 10 items, 10000 steps to sort 100 items
-   Stable algorithm
