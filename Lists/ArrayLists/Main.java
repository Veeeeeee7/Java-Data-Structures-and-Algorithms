package ArrayLists;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // creates the array list and adds the employee objects
        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(new Employee("Jane", "Jones", 123));
        employeeList.add(new Employee("John", "Doe", 4567));
        employeeList.add(new Employee("Mary", "Smith", 22));
        employeeList.add(new Employee("Mike", "Wilson", 3245));

       // prints the array list
//        employeeList.forEach(employee -> System.out.println(employee));

        // prints the employee at index 1 (the second employee)
//        System.out.println(employeeList.get(1));

        // prints if the array list is empty
//        System.out.println(employeeList.isEmpty());

        // sets the employee at index 1 to a new employee
        employeeList.set(1, new Employee("John", "Adams", 4568));
//        employeeList.forEach(employee -> System.out.println(employee));
//
        // prints the size of the array list (which hasn't changed because we didn't add or remove anything)
//        System.out.println(employeeList.size());

        // adds a new employee to the array list at index 3
        employeeList.add(3, new Employee("John", "Doe", 4567));
//        employeeList.forEach(employee -> System.out.println(employee));

        // creates an array from the array list (basically gets the backing array)
//        Employee[] employeeArray = employeeList.toArray(new Employee[employeeList.size()]);

        // prints the array
//        for (Employee employee: employeeArray) {
//            System.out.println(employee);
//        }

        // prints if the array list contains this employee
//        System.out.println(employeeList.contains(new Employee("Mary", "Smith", 22)));

        // prints the index of this employee
//        System.out.println(employeeList.indexOf(new Employee("John", "Doe",  4567)));

        // removes the employee at index 2
        employeeList.remove(2);

        // prints the array list
        employeeList.forEach(employee -> System.out.println(employee));
    }
}
