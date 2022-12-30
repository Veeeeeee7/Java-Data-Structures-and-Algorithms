package HashTables.LinearProbing;

public class SimpleHashTable {
    private StoredEmployee[] hashtable;

    // Constructor
    public SimpleHashTable() {
        hashtable = new StoredEmployee[10];
    }

    // Put method: adds an employee to the hashtable using the hashed key as the
    // index
    // If the index is occupied, it will find the next available index
    public void put(String key, Employee employee) {
        int hashedKey = hashKey(key);
        int stopIndex = hashedKey;

        // Loops through the hashtable until it finds an empty index
        while (occupied(hashedKey) && hashedKey != stopIndex) {
            hashedKey = (hashedKey + 1) % hashtable.length;
        }

        // If the index is still occupied after trying to look for an empty index, every
        // index is already occupied
        if (occupied(hashedKey)) {
            System.out.println("Sorry, there's already an employee at every position.");
        } else {
            hashtable[hashedKey] = new StoredEmployee(key, employee);
        }
    }

    // Get method: retrieves an employee from the hashtable using the key found by
    // the findKey() method as the index
    public Employee get(String key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null;
        }
        return hashtable[hashedKey].employee;
    }

    // Remove method: removes an employee from the hashtable using the key found by
    // the findKey() method as the index
    public Employee remove(String key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null;
        }

        Employee employee = hashtable[hashedKey].employee;
        // hashtable[hashedKey] = null;

        StoredEmployee[] oldHashtable = hashtable;
        hashtable = new StoredEmployee[oldHashtable.length];
        for (int i = 0; i < oldHashtable.length; i++) {
            if (oldHashtable[i] != null) {
                put(oldHashtable[i].key, oldHashtable[i].employee);
            }
        }

        return employee;
    }

    // Prints out the hashtable
    private int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    // Finds the key in the hashtable for the given string key
    private int findKey(String key) {
        int hashedKey = hashKey(key);

        // If the hashed key is the same as the key in the hashtable (ie no
        // collision/linear probing has occurred), return the hashed key
        //
        // If the hashtable is empty at that key, return the hashed key
        if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        }

        // If the hashed key is not the same as the key in the hashtable (ie collision/
        // linear probing has occurred), loop until the hashed key finds an empty index,
        // itself somewhere else because of collion/linear probing, or loops back
        int stopIndex = hashedKey;
        hashedKey = (hashedKey + 1) % hashtable.length;

        while (hashedKey != stopIndex && hashtable[hashedKey] != null && !hashtable[hashedKey].key.equals(key)) {
            hashedKey = (hashedKey + 1) % hashtable.length;
        }

        // If there is no empty index and the hashed key is not in the hashtable, return
        // -1
        if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        } else {
            return -1;
        }
    }

    // Checks if the index is occupied
    private boolean occupied(int index) {
        return hashtable[index] != null;
    }

    // Prints out the hashtable
    public void printHashtable() {
        for (int i = 0; i < hashtable.length; i++) {
            if (hashtable[i] == null) {
                System.out.println("empty");
            } else {
                System.out.println("Position " + i + ": " + hashtable[i].employee);
            }
        }
    }
}
