package LLD2.factory;

import LLD2.factory.components.button.Button;
import LLD2.factory.components.button.IOSButton;
import LLD2.factory.components.dropdown.Dropdown;
import LLD2.factory.components.dropdown.IOSDropdown;
import LLD2.factory.components.menu.Menu;
import LLD2.factory.components.menu.IOSMenu;

public class IOSUIFactory implements UIFactory
{
    @Override
    public Button createButton()
    {
        return new IOSButton();
    }

    @Override
    public Dropdown createDropdown()
    {
        return new IOSDropdown();
    }

    @Override
    public Menu createMenu()
    {
        return new IOSMenu();
    }
}
