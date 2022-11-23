import java.util.*;

public class Employee {
    private String name;
    private String designation;
    private int salary;
    static LinkedList<String> manages = new LinkedList<String>();
    static int count = 0;

    Employee(String name, String designation, int salary) {
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    public void addSubordinate(String employee) {
        manages.add(employee);
    }

    static boolean findSubordinates(String root, Employee employee) {    
        int ans = -1;
        boolean status = false;
        List<String>foundEmployees = new ArrayList<String>();         
        String resultEmployee;

        // Traversing through  Linked List
        for (int i = 0; i < manages.size(); i++) {

            //check linked list
            String foundEmp = manages.get(i);

            // Checking if found
            if (foundEmp == employee.name) {
                // assign index
                ans = i;
                foundEmployees.add(foundEmp);
                status = true;
                break;                
            }
        }
        // Checking if the element is present in the Linked
        // List
        if (ans == -1) {
            status = false;
        } else {
            System.out.println("There are "+foundEmployees.size()+" employees working under "+employee.name);
            for(int i = 0; i < foundEmployees.size(); i++) {
                System.out.println((i+1)+" "+employee.designation+" and their tottal salary is: "+employee.salary);
            }
            resultEmployee = manages.get(ans);            
        }        
        return status;
    }
}
