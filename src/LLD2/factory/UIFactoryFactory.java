package LLD2.factory;

public class UIFactoryFactory
{
    public static UIFactory getUIFactory(Platform platform)
    {
        switch (platform)
        {
            case MAC: return new MacUIFactory();
            case IOS: return new IOSUIFactory();
            case ANDROID: return new AndroidUIFactory();
        }
        return null;
    }
}
//practical factory
//this still violates OCP, but since it's not in the main function, it's considered in the grey area
