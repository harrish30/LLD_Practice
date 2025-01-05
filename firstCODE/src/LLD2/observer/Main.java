package LLD2.observer;

public class Main
{
    public static void main(String[] args)
    {
        CustomerNotificationService customerNotificationService = new CustomerNotificationService();
        InvoiceGeneratorService invoiceGeneratorService = new InvoiceGeneratorService();
        Amazon amazon = Amazon.getInstance();
        amazon.subscribe(customerNotificationService);
        amazon.subscribe(invoiceGeneratorService);
        amazon.orderPlaced();
        amazon.unsubscribe(customerNotificationService);
        amazon.orderPlaced();
    }
}
