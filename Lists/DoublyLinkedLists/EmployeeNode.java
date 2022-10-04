package DoublyLinkedLists;

/*
 * This class is used to create a doubly linked list of Employee objects.
 */

public class EmployeeNode {

    private Employee employee;
    private EmployeeNode next;
    private EmployeeNode previous;

    // Constructor
    public EmployeeNode(Employee employee) {
        this.employee = employee;
    }

    // Getters and Setters
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeNode getNext() {
        return next;
    }

    public void setNext(EmployeeNode next) {
        this.next = next;
    }

    public EmployeeNode getPrevious() {
        return previous;
    }

    public void setPrevious(EmployeeNode previous) {
        this.previous = previous;
    }

    // uses the to string of the employee object
    public String toString() {
        return employee.toString();
    }

}
