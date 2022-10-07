# Shell Sort

Cuts down on the amount of shifting that takes place in insertion sort. It's a variation of insertion sort where it uses gap values that are greater than one. The gap value will decrease until it reaches 1. Then in the last iteration, it will perform an insertion sort, which will have less shifts because its already partially sorted. The initial gap value will influence the time complexity of the sort. This implementation will initialize gap as array.length / 2. Each time a traversal finishes, the gap is divided by 2.

**20**, 35, -15, **7**, 55, 1, -22

7, 35, -15, 20, 55, 1, -22

7, **35**, -15, 20, **55**, 1, -22

7, 35, **-15**, 20, 55, **1**, -22

7, 35, -15, **20**, 55, 1, **-22**

-22, 35, -15, 7, 55, 1, 20

-   In-place algorithm
-   Difficult to define the time complexity because it depends on the gap. Worst case: O(n<sup>2</sup>), but can perform much better.
    -   Doesn't require as much shifting as insertion sort (usually performs better than insertion sort)
-   Unstable algorithm
