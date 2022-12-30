# Bucket Sort

-   uses hashing
    -   Scattering: distributes the items based on their hashed values
    -   Sorting: sorts each bucket
    -   Gathering: merges the buckets (adding one bucket after another)
    -   Similar to counting sort, but uses the hashed key to distribute the items
-   makes assumptions about the data, allowing O(n) time complexity
-   performs best when hashed values are evenly distributed without collisions
-   not in-place
-   stability will depend on sorting algorithm used to sort each bucket
    -   insertion sort is often used, but not in this implemenetation
