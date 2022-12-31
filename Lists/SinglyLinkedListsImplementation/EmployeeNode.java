package Lists.SinglyLinkedListsImplementation;

/*
 * This class is used to create an Employee Node object
 */

public class EmployeeNode {

    private Employee employee;
    private EmployeeNode next;

    // Constructor: each node only needs to know its own object (employee) and the
    // next node
    public EmployeeNode(Employee employee) {
        this.employee = employee;
    }

    // Getters and Setters
    public Employee getEmployee() {
        return employee;
    }

    public EmployeeNode getNext() {
        return next;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setNext(EmployeeNode next) {
        this.next = next;
    }

    // when printing the node, it prints the each employee's toString method
    public String toString() {
        return employee.toString();
    }
}
