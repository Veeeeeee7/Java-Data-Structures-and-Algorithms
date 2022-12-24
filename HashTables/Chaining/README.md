# Chaining

Instead of storing the value directly into the backing array, each array position will store a linked list of values. This is a very simple way to handle collisions as if there are two values that hash to the same position, they can be easily added to the linked list because they don't have a size limit.
