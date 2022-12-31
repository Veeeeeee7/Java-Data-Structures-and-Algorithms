package HashTables;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

        /*
         * HashMaps
         */

        HashMap<String, Employee> hashMap = new HashMap<>();

        // adds a key and value pair to the hashMap
        hashMap.put("Jones", janeJones);
        hashMap.put("Doe", johnDoe);
        hashMap.put("Smith", marySmith);

        // gets the value of the key
        System.out.println(hashMap.get("Jones"));

        // Checks if the key already exists and if it does, it will not put the new
        // value in and will return the old value
        Employee employee = hashMap.putIfAbsent("Doe", mikeWilson);
        System.out.println(employee);

        // Doesn't check if the key already exists, puts in the new value and returns
        // the old value
        employee = hashMap.put("Doe", mikeWilson);
        System.out.println(employee);

        // checks if the key/value exists
        // containsKeys() should be faster than containsValue()
        System.out.println(hashMap.containsKey("Doe"));
        System.out.println(hashMap.containsValue(janeJones));

        // prints the hashMap
        hashMap.forEach((k, v) -> System.out.println("Key = " + k + ", Employee = " + v));
    }
}
