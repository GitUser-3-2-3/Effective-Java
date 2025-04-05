package factory_pattern;

public class WebDeveloper implements Employee {
      @Override
      public int salary() {
            System.out.println("Web Developer Salary");
            return 120_000;
      }
}
