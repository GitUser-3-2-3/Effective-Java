package facade_pattern.scenario1;

public class EmployeeFacade {

      EmployeeDAO employeeDAO;

      public EmployeeFacade() {
            employeeDAO = new EmployeeDAO();
      }

      public void insert(Employee employee) {
            employeeDAO.insert(employee);
      }

      public Employee getEmployeeDetails(int empId) {
            return employeeDAO.getEmployeeDetails(empId);
      }
}
