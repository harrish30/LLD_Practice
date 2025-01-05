package LLD2.facade;

public class InventoryManagementHelper
{
    private InventoryManagement ivm = new InventoryManagement();
    public void checkAndUpdateInventory()
    {
        ivm.checkCurrentCount();
        ivm.stockUpdate();
        ivm.priceCheck();
    }
}
