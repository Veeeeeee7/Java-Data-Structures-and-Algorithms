package HashTables.ChainingImplementation;

public class StoredEmployee {
    public String key;
    public Employee employee;

    // Constructor
    public StoredEmployee(String key, Employee employee) {
        this.key = key;
        this.employee = employee;
    }
}
