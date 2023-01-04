# Heap Sort

-   add the values to a heap (min heap in this case)
-   remove the root and add it to the sorted array
-   continue until there are no more values in the heap

80, 75, 60, 68, 55, 40, 52, 67

**40**, 75, 60, 68, 55, 40, 52, 67

40, **52**, 60, 68, 55, 40, 52, 67

40, 52, **55**, 68, 55, 40, 52, 67

40, 52, 55, **60**, 55, 40, 52, 67

40, 52, 55, 60, **67**, 40, 52, 67

40, 52, 55, 60, 67, **68**, 52, 67

40, 52, 55, 60, 67, 68, **75**, 67

40, 52, 55, 60, 67, 68, 75, **80**
