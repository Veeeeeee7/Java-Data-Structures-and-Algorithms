# Radix Sort

It assumes that the data has the same radix and width. Radix is the number of numbers a number can represent, a binary number can represent 2 numbers and a hexadecimal can represent 16 numbers. Width is how many numbers there are (4589 and 2753 both have width 4). Sorts based on each individual digit. Starts from the ones digit and then goes to the highest digit. Since two numbers can have the same number in the same digit, it is critical to use stable sort algorithm so that the order of the past sort needs to be remembered.

4725, 4586, 1330, 8792, 1594, 5729

1330, 8792, 1594, 4725, 4586, 5729

4725, 5729, 1330, 4586, 8792, 1594

1330, 4586, 1594, 4725, 5729, 8792

1330, 1594, 4586, 4725, 5729, 8792

-   Counting sort is often used as the sort algorithm for radix sort (but must be stable counting sort)
-   O(n) time complexity can be achieved because of the assumptions made about the data
    -   However, it often runs slower than O(nlog<sub>2</sub>n) algorithms because of the overhead involved just to figure out what number is at each digit
-   In-place depending on which sort algorithm used
-   Stable algorithm
