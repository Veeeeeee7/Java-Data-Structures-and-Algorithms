# Selection Sort

Define a variable that stores the index of the largest number. Set index 1 as the largest number and traverse the list to compare the next number to the largest number. If a larger number is found, set the variable to the index of that number. Once the traversal is finished, swap the largest number with the last index of the array. Then traverse the list (not including the last number).

20, 35, -15, 7, **55**, 1, -22

20, **35**, -15, 7, -22, 1, 55

**20**, 1, -15, 7, -22, 35, 55

-22, 1, -15, **7**, 20, 35, 55

-22, **1**, -15, 7, 20, 35, 55

-22, **-15**, 1, 7, 20, 35, 55

-22, -15, 1, 7, 20, 35, 55

-   In-place algorithm
-   O(n<sup>2</sup>) time complexity
    -   100 steps to sort 10 items, 10000 steps to sort 100 items
    -   Doesn't require as much swapping as bubble sort (usually performs better than bubble sort)
-   Unstable algorithm
