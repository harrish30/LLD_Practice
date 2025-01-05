package LLD2.factory;

public class Flutter
{
    Platform platform;
    public Flutter(Platform platform)
    {
        this.platform = platform;
    }
    public void setRefreshRate()
    {
        System.out.println("Refresh rate is set");
    }
    public void setTheme()
    {
        System.out.println("Theme is set");
    }
    //abstract factory
    public UIFactory createUI()
    {
        return UIFactoryFactory.getUIFactory(platform);
    }
}
