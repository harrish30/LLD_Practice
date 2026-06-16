package LLD2.observer;

public class CustomerNotificationService implements OrderPlacedSubscriber
{
    @Override
    public void orderPlaceEvent()
    {
        System.out.println("Send SMS to customer");
        System.out.println("Send email to customer");
    }
}
