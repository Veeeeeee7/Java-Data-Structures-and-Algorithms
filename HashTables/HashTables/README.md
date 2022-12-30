# HashTables

JDK HashTable Implementation

-   no null keys or values
-   synchronized

JDK HashMap Implementation

-   constant for basic operations unless resizing the backing array is needed
-   allows null keys and values
-   no duplicate keys
-   no synchronized

JDK LinkedHashMap Implementation

-   backed by an array, but also has a linkedlist to store the order of the items added
-   has a removeEldestEntry() method that removes the oldest entry
    -   can remove the oldest entry everytime a new entry is added (useful for caching)
