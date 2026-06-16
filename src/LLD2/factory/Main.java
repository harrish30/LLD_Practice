package LLD2.factory;

import LLD2.factory.components.button.Button;
import LLD2.factory.components.dropdown.Dropdown;
import LLD2.factory.components.menu.Menu;

public class Main
{
    public static void main(String[] args)
    {
        Flutter flutter = new Flutter(Platform.ANDROID);
        UIFactory factory = flutter.createUI();
        Menu menu = factory.createMenu();
        Dropdown dropdown = factory.createDropdown();
        Button button = factory.createButton();
    }
}
