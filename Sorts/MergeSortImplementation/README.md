# Merge Sort

Divide and conquer algorithm. Also it is usually written recursively.

Splitting Phase: The algorithm splits the array until it gets to arrays of one single number. These arrays are by default sorted.

Merging Phase: Merge every left/right pair of sibling arrays and sort into a sorted 2-element array. Then, merge these 2-element arrays with their sibling 2-element arrays and sort. Continue until all the arrays have merged together into one array.

20, 35, -15, 7, 55, 1, -22 &larr; split the array

**_{_** (20), **[** (35), (-15) **]** **_}_** , **_{_** **[** (7), (55) **]**, **[** (1), (-22) **]** **_}_** &larr; once the array is split, merge the 1-element arrays with their sibling arrays

**_{_** (20), **[** -15, 35 **]** **_}_** , **_{_** **[** 7, 55 **]**, **[** -22, 1 **]** **_}_** &larr; merge the 2-element arrays with their sibling arrays

**_{_** -15, 20, 35 **_}_** , **_{_** -22, 1, 7, 55 **_}_** &larr; merge the last 2 arrays

**_{_** -22, -15, 1, 7, 20, 35, 55 **_}_**

-   Not an in-place algorithm
-   O(nlog<sub>2</sub>n)
    -   repeated dividing the array in half during the splitting phase
-   Stable algorithm
