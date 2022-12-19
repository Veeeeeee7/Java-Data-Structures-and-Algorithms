# Hash Tables

This folder focuses on Hash Tables and its array implementation and uses.

-   Abstract data type
-   Consists of key/value pairs (data types don't have to match)
    -   Keys don't have to be an integer
-   Provide access to elements using keys in constant time
    -   Optimized for retrieval of data
-   Underneath, keys are turned into an integer using a hash function: Object.hashCode()
    -   Collisions occur when more than one object has the same hash code
-   Load Factor = # of elements / capacity
    -   Tells how full a hash table is
    -   If load factor is too high, collisions occur more often
    -   If load factor is too low, there are too many empty spaces
