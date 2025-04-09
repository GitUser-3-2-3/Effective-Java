package facade_pattern.scenario1;

public class EmployeeClient {
      public static void main(String[] args) {
            EmployeeFacade employeeFacade = new EmployeeFacade();
            employeeFacade.insert(new Employee());

            Employee empDetails = employeeFacade.getEmployeeDetails(12134);
            System.out.println(empDetails);
      }
}
