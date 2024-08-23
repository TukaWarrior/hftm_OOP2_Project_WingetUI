package ch.hftm.oop2_winget_project.Controller;

import ch.hftm.oop2_winget_project.App;
import ch.hftm.oop2_winget_project.Util.ResourceProvider;
import ch.hftm.oop2_winget_project.Util.StageAndSceneManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable
{
    @FXML
    private BorderPane mainWindowBorderPane;
    @FXML
    private ToggleButton maximizeWindowButton;
    @FXML
    private AnchorPane titleBar;
    @FXML
    private Button buttonSearchPackages;
    @FXML
    private Button buttonUpdatePackages;
    @FXML
    private Button buttonInstalledPackages;
    @FXML
    private Button buttonFavorites;

    private String activeFxml;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        // Start with search packages view
        StageAndSceneManager.loadFxmlToBorderPaneLeft(mainWindowBorderPane, ResourceProvider.SEARCHPACKAGES_VIEW_NAME);
        activeFxml = "searchView";
    }

    @FXML
    private void menuSearchButtonClick()
    {
        StageAndSceneManager.loadFxmlToBorderPaneLeft(mainWindowBorderPane, ResourceProvider.SEARCHPACKAGES_VIEW_NAME);
        activeFxml = "searchView";
    }

    @FXML
    private void menuUpdateButtonClick()
    {
        StageAndSceneManager.loadFxmlToBorderPaneLeft(mainWindowBorderPane, ResourceProvider.UPGRADEPACKAGES_VIEW_NAME);
        activeFxml = "updateView";
    }

    @FXML
    private void menuInstalledPackagesButtonClick()
    {
        StageAndSceneManager.loadFxmlToBorderPaneLeft(mainWindowBorderPane, ResourceProvider.INSTALLEDPACKAGES_VIEW_NAME);
        activeFxml = "installedView";
    }

    @FXML
    private void menuFavouritesButtonClick()
    {
        StageAndSceneManager.loadFxmlToBorderPaneLeft(mainWindowBorderPane, ResourceProvider.LISTMANAGER_VIEW_NAME);
        activeFxml = "favoritesView";
    }

    public BorderPane getMainWindowBorderPane() {
        return mainWindowBorderPane;
    }

    public void switchMainWindowToPackageList()
    {
        StageAndSceneManager.loadFxmlToBorderPaneLeft(mainWindowBorderPane, ResourceProvider.PACKAGELIST_VIEW_NAME);
    }
}
