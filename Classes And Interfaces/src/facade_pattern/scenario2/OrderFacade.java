package facade_pattern.scenario2;

public class OrderFacade {

      ProductDAO productDAO;
      Invoice invoice;
      Payment payment;
      SendNotification notification;

      public OrderFacade() {
            productDAO = new ProductDAO();
            invoice = new Invoice();
            payment = new Payment();
            notification = new SendNotification();
      }

      public void createOrder() {
            Product product = productDAO.getProduct(1234513);
            payment.makePayment();
            invoice.generateInvoice();
            notification.sendNotification();
            // Order creation successful
      }
}
