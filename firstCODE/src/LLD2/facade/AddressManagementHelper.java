package LLD2.facade;

public class AddressManagementHelper
{
    private AddressManagement adm = new AddressManagement();
    public void verify()
    {
        adm.verifyPincode();
        adm.verifyAddress();
    }
}
