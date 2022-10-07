# Quick Sort

Divide and conquer algorithm. Often written recursively. Partition array into two halfs. Create a pivot variable that is set to the first number. Then traverse the array from right to left looking for the first number that's less than the pivot number. Then set the first number of the array to that number. Then set the number that was smaller than the pivot number to the first number that is greater than pivot traversing from left to right. The first number is not lost because it is stored in pivot. Then repeat again with the next number, until the index of the first number from left to right that is greater than pivot becomes equal to or larger than the index of the first number from right to left that is smaller than pivot.

**20**, 35, -15, 7, 55, 1, -22 &larr; 20 is set as pivot

**-22**, 35, -15, 7, 55, 1, -22 &larr; 20 is replaced with -22, the first number that is less than 20 when traversing from right to left

-22, 35, -15, 7, 55, 1, **35** &larr; the -22 at the end if replaced with 35, the first number that is greater than 20 when traversing from left to right

-22, **1**, -15, 7, 55, 1, 35 &larr; 35 is replaced with 1, the first number that is less than 20 when traversing from right to left

-22, 1, -15, 7, 55, **55**, 35 &larr; 1 is replaced with 55, the first number that is greater than 20 when traversing from left to right

-22, 1, -15, 7, **20**, 55, 35 &larr; since the index of 55 in the last step was 4 and the index of the next possible smallest number from right to left is 4 the algorithm stops and 20 is inserted at position 4

Once this is complete, 20 is in the sorted position of the array and then partition the array again with 20 as the middle. (index 0-3 and index 5-6) Then run quick sort with those arrays and keep going until you have sorted the 2-element arrays. Then combine all the arrays together.

-   In-place algorithm
-   O(nlog<sub>2</sub>n)
    -   Usually runs faster than merge sort
-   Unstable algorithm
