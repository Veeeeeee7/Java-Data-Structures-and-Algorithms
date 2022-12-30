package HashTables.HashTables;

import java.util.HashMap;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

        HashMap<String, Employee> hashMap = new HashMap<>();
        hashMap.put("Jones", janeJones);
        hashMap.put("Doe", johnDoe);
        hashMap.put("Smith", marySmith);

        // Checks if the key already exists and if it does, it will not put the new
        // value in and will return the old value
        Employee employee = hashMap.putIfAbsent("Doe", mikeWilson);
        System.out.println(employee);

        // Doesn't check if the key already exists, puts in the new value and returns
        // the old value
        employee = hashMap.put("Doe", mikeWilson);
        System.out.println(employee);

        // containsKeys() should be faster than containsValue()
        System.out.println(hashMap.containsKey("Doe"));
        System.out.println(hashMap.containsValue(janeJones));

        // Iterator<Employee> iterator = hashMap.values().iterator();
        // while (iterator.hasNext()) {
        // System.out.println(iterator.next());
        // }

        hashMap.forEach((k, v) -> System.out.println("Key = " + k + ", Employee = " + v));
    }
}
