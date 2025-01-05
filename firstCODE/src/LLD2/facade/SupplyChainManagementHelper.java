package LLD2.facade;

public class SupplyChainManagementHelper
{
    private SupplyChainManagement scm = new SupplyChainManagement();
    public void shipAndTrackOrder()
    {
        scm.getTimeToDelivery();
        scm.initiateOrderShipment();
        scm.getTrackingLink();
    }
}
