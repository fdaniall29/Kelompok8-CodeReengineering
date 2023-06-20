import java.util.ArrayList;
import java.util.List;

class Employee {
    private String name;
    private List<Employee> subordinates;

    public Employee(String name) {
        this.name = name;
        this.subordinates = new ArrayList<>();
    }

    public void addSubordinate(Employee employee) {
        subordinates.add(employee);
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    public String getName() {
        return name;
    }
}

public class UnfactoredHierarchyExample {
    public static void main(String[] args) {
        Employee ceo = new Employee("John (CEO)");
        
        Employee manager1 = new Employee("Mike (Manager 1)");
        Employee manager2 = new Employee("Lisa (Manager 2)");
        
        Employee employee1 = new Employee("Alice (Employee 1)");
        Employee employee2 = new Employee("Bob (Employee 2)");
        Employee employee3 = new Employee("Eve (Employee 3)");
        
        ceo.addSubordinate(manager1);
        ceo.addSubordinate(manager2);
        
        manager1.addSubordinate(employee1);
        manager1.addSubordinate(employee2);
        
        manager2.addSubordinate(employee3);
        
        // Traversing the hierarchy
        traverseHierarchy(ceo, 0);
    }
    
    public static void traverseHierarchy(Employee employee, int level) {
        StringBuilder indentation = new StringBuilder();
        for (int i = 0; i < level; i++) {
            indentation.append("  "); // Two spaces per level
        }
        
        System.out.println(indentation + employee.getName());
        
        for (Employee subordinate : employee.getSubordinates()) {
            traverseHierarchy(subordinate, level + 1);
        }
    }
}
