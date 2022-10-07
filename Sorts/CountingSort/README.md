# Counting Sort

Makes assumptions about the data (must be within a specific range and can't work with floats and negative numbers). It doesn't use comparisons, but counts the number of occurences of each value. It creates a counting array that holds this. For this implementation, it assumes that the numbers are between 1 to 10. It will therefore create a counting array of length 10. It will then traverse through the array and add to the counting array the amount of times a number occurs.

Array: 2, 5, 9, 8, 2, 8, 7, 10, 4, 3

Counting Array: 0, 2, 1, 1, 1, 0, 1, 2, 1, 1 &larr; This array basically just says that there are x amount of numbers in the array. (ex. there are two 2's in the array). It will then create an array based using this counting array (2, 2, 3, 4, 5, 7, 8, 8, 9, 10).

-   Not an in-place algorithm
-   O(n) can be achieved because of the assumptions
-   Not a stable algorithm by default, but can if a linked-list is used instead of a counting array
