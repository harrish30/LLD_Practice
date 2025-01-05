package LLD2.facade;

public class PaymentManagementHelper
{
    private PaymentManagement pm = new PaymentManagement();
    public void pay()
    {
        pm.initiatePayment();
        pm.verifyPayment();
    }
}
