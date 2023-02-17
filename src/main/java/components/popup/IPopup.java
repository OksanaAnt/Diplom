package components.popups;

import data.menu.ISubMenu;

public interface IPopup {
    public void popupShouldNotBeVisible(ISubMenu subMenu);
    public void popupShouldBeVisible(ISubMenu subMenu);
}
