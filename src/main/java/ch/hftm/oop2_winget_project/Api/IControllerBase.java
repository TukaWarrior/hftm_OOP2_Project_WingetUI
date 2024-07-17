package ch.hftm.oop2_winget_project.Api;

import ch.hftm.oop2_winget_project.Model.WinGetPackageFX;

public interface IControllerBase
{
    void setTableViewData();
    void setTableViewSource();
    void refreshTableViewContent();
    WinGetPackageFX getObjectFromSelection();
    void addButtonToTableView();
}