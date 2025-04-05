package factory_pattern;

public class DeveloperClient {

      public static void main(String[] args) {
            Employee employee = EmployeeFactory.getEmployee("ANDROID DEVELOPER");
            System.out.println();
            if (employee != null) {
                  int salary = employee.salary();
                  System.out.println(salary);
            }
      }
}
