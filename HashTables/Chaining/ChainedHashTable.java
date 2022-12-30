package HashTables.Chaining;

import java.util.LinkedList;
import java.util.ListIterator;

public class ChainedHashTable {
    private LinkedList<StoredEmployee>[] hashtable;

    // Constructor
    public ChainedHashTable() {
        hashtable = new LinkedList[10];
        for (int i = 0; i < hashtable.length; i++) {
            hashtable[i] = new LinkedList<StoredEmployee>();
        }
    }

    // Put method: adds an employee to the linkedlist located at the index of the
    // hashed key of the string
    public void put(String key, Employee employee) {
        int hashedKey = hashKey(key);
        hashtable[hashedKey].add(new StoredEmployee(key, employee));
    }

    // Get method: retrieves an employee from the linkedlist located at the index of
    // the hashed key of the string
    public Employee get(String key) {
        int hashedKey = hashKey(key);
        ListIterator<StoredEmployee> iterator = hashtable[hashedKey].listIterator();
        StoredEmployee employee = null;

        // Iterate through the linkedlist at the hashed key index to find the employee
        // with the same key
        // This key is the original string, which is different from the hashed key
        while (iterator.hasNext()) {
            employee = iterator.next();
            if (employee.key.equals(key)) {
                return employee.employee;
            }
        }
        return null;
    }

    // Remove method: removes an employee from the linkedlist located at the index
    // of the hashed key of the string
    public Employee remove(String key) {
        int hashedKey = hashKey(key);
        ListIterator<StoredEmployee> iterator = hashtable[hashedKey].listIterator();
        StoredEmployee employee = null;
        int index = -1;

        // Iterate through the linkedlist at the hashed key index to find the index of
        // the employee with the same key
        // This key is the original string, which is different from the hashed key
        while (iterator.hasNext()) {
            employee = iterator.next();
            index++;
            if (employee.key.equals(key)) {
                break;
            }
        }

        if (employee == null) {
            return null;
        } else {
            // Iterates through the linkedlist again to remove the employee at the found
            // index
            hashtable[hashedKey].remove(index);
            return employee.employee;
        }
    }

    // Hashes a string key to an int
    private int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    // Print method: prints the hashtable
    public void printHashtable() {
        for (int i = 0; i < hashtable.length; i++) {
            if (hashtable[i].isEmpty()) {
                System.out.println("Position " + i + ": empty");
            } else {
                System.out.print("Position " + i + ": ");
                ListIterator<StoredEmployee> iterator = hashtable[i].listIterator();
                while (iterator.hasNext()) {
                    System.out.print(iterator.next().employee);
                    System.out.print(" -> ");
                }
                System.out.println("null");
            }
        }
    }

}
