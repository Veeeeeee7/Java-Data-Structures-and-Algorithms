# Bubble Sort

Goes from left to right and compares elements next to each other and swap them so that the larger number is on the right. After traversing through the array once, the last index will be sorted. Then traverse through the array again, but not including the end of the array that is already sorted.

20, 35, -15, 7, 55, 1, -22

**20, 35**, -15, 7, 55, 1, -22

20, **35, -15**, 7, 55, 1, -22

20, -15, **35, 7**, 55, 1, -22

20, -15, 7, **35, 55**, 1, -22

20, -15, 7, 35, **55, 1**, -22

20, -15, 7, 35, 1, **55, -22**

20, -15, 7, 35, 1, -22, 55

-   In-place Algorithm
-   O(n<sup>2</sup>)
    -   100 steps to sort 10 items, 10000 steps to sort 100 items
    -   Degrades quickly
