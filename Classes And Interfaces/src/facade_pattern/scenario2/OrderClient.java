package facade_pattern.scenario2;

public class OrderClient {
      public static void main(String[] args) {
            OrderFacade facade = new OrderFacade();
            facade.createOrder();
      }
}
