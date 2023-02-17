package components.popups;

import data.menu.HeaderMenuItemData;
import data.menu.ISubMenu;

public interface ISubMenuPopup {
    public void popupShouldNotBeVisible(HeaderMenuItemData headerMenuItemData);
    public void popupShouldBeVisible(HeaderMenuItemData headerMenuItemData);
}
