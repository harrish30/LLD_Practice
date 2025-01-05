package LLD2.factory;

import LLD2.factory.components.button.AndroidButton;
import LLD2.factory.components.button.Button;
import LLD2.factory.components.dropdown.AndroidDropdown;
import LLD2.factory.components.dropdown.Dropdown;
import LLD2.factory.components.menu.AndroidMenu;
import LLD2.factory.components.menu.Menu;

public class AndroidUIFactory implements UIFactory
{
    @Override
    public Menu createMenu()
    {
        return new AndroidMenu();
    }

    @Override
    public Dropdown createDropdown()
    {
        return new AndroidDropdown();
    }

    @Override
    public Button createButton()
    {
        return new AndroidButton();
    }
}
