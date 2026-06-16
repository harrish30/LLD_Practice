package LLD2.factory;

import LLD2.factory.components.button.AndroidButton;
import LLD2.factory.components.button.Button;
import LLD2.factory.components.dropdown.Dropdown;
import LLD2.factory.components.dropdown.MacDropdown;
import LLD2.factory.components.menu.AndroidMenu;
import LLD2.factory.components.menu.Menu;

public class MacUIFactory implements UIFactory
{
    @Override
    public Menu createMenu()
    {
        return new AndroidMenu();
    }

    @Override
    public Dropdown createDropdown()
    {
        return new MacDropdown();
    }

    @Override
    public Button createButton()
    {
        return new AndroidButton();
    }
}
