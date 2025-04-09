package facade_pattern.scenario1;

public class EmployeeDAO {

      public void insert(Employee employee) {
            // insert into employee table
      }

      public void updateEmployee(Employee employee) {
            // update employee table
      }

      public Employee getEmployeeDetails(String emailId) {
            // get employee details based on employee id
            return new Employee();
      }

      public Employee getEmployeeDetails(int empId) {
            // get employee details based on employee id
            return new Employee();
      }
}
