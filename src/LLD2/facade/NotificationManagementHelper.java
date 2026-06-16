package LLD2.facade;

public class NotificationManagementHelper
{
    private NotificationManagement nfm = new NotificationManagement();
    public void notification()
    {
        nfm.sendSMS();
        nfm.sendMail();
    }
}
