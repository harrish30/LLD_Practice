package LLD2.factory;

import LLD2.factory.components.button.Button;
import LLD2.factory.components.dropdown.Dropdown;
import LLD2.factory.components.menu.Menu;

public interface UIFactory
{
    public Menu createMenu();

    public Dropdown createDropdown();

    public Button createButton();
}
