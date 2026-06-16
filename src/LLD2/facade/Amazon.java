package LLD2.facade;

public class Amazon
{
    String productId;
    int quantity;
    Amazon(String productId, int quantity)
    {
        this.productId = productId;
        this.quantity = quantity;
    }
    private InventoryManagementHelper ivmHelper = new InventoryManagementHelper();
    private AddressManagementHelper admHelper = new AddressManagementHelper();
    private PaymentManagementHelper pmHelper = new PaymentManagementHelper();
    private SupplyChainManagementHelper scmHelper = new SupplyChainManagementHelper();
    private NotificationManagementHelper nfmHelper = new NotificationManagementHelper();
    public void placeOrder()
    {
        ivmHelper.checkAndUpdateInventory();
        admHelper.verify();
        pmHelper.pay();
        scmHelper.shipAndTrackOrder();
        nfmHelper.notification();
    }
}
