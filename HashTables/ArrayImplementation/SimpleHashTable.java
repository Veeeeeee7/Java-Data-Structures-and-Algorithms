package HashTables.ArrayImplementation;

public class SimpleHashTable {
    private Employee[] hashtable;

    // Constructor
    public SimpleHashTable() {
        hashtable = new Employee[10];
    }

    // Put method: adds an employee to the hashtable using the hashed key as the
    // index
    public void put(String key, Employee employee) {
        int hashedKey = hashKey(key);
        if (hashtable[hashedKey] != null) {
            System.out.println("Sorry, there's already an employee at position " + hashedKey);
        } else {
            hashtable[hashedKey] = employee;
        }
    }

    // Get method: retrieves an employee from the hashtable using the hashed key as
    // the index
    public Employee get(String key) {
        int hashedKey = hashKey(key);
        return hashtable[hashedKey];
    }

    // Remove method: removes an employee from the hashtable using the hashed key as
    // the index
    public void remove(String key) {
        int hashedKey = hashKey(key);
        hashtable[hashedKey] = null;
    }

    // Hashes a string key to an int
    private int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    // Print method: prints the hashtable
    public void printHashtable() {
        for (int i = 0; i < hashtable.length; i++) {
            System.out.println(hashtable[i]);
        }
    }
}
