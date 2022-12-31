# Hash Tables

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

## Hashtable Class

-   no null keys or values
-   synchronized

Constructor:

    Hashtable<String, String> ht = new Hashtable<>();

## HashMap Class

-   constant for basic operations unless resizing the backing array is needed
-   allows null keys and values
-   no duplicate keys
-   no synchronized

Code:

    HashMap<String, Employee> hashMap = new HashMap<>();

    // adds a key and value pair to the hashMap
    hashMap.put("Jones", janeJones);

    // gets the value of the key
    Employee employeeJones = hashMap.get("Jones");

    // Checks if the key already exists and if it does, it will not put the new
    // value in and will return the old value
    Employee oldEmployee = hashMap.putIfAbsent("Doe", mikeWilson);

    // Doesn't check if the key already exists, puts in the new value and returns
    // the old value
    Employee replacedEmployee = hashMap.put("Doe", mikeWilson);

    // checks if the key/value exists
    // containsKeys() should be faster than containsValue()
    System.out.println(hashMap.containsKey("Doe"));
    System.out.println(hashMap.containsValue(janeJones));

    // prints the hashMap
    hashMap.forEach((k, v) -> System.out.println("Key = " + k + ", Employee = " + v));

## LinkedHashMap Class

-   backed by an array, but also has a linkedlist to store the order of the items added
-   has a removeEldestEntry() method that removes the oldest entry
    -   can remove the oldest entry everytime a new entry is added (useful for caching)
