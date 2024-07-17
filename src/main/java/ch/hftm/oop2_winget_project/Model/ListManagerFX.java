package ch.hftm.oop2_winget_project.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

/**
 * The ListManager class manages a list of PackageList objects.
 * There is only one such list in the application, it is a singelton.
 * This list is observable, meaning it can update the UI automatically when items are added or removed.
 * The class provides methods to add and remove PackageLists, and to
 * get the entire list to use elsewhere.
 */

public class ListManagerFX {

    // Variables
    private static ListManagerFX instance;
    private ObservableList<PackageListFX> lists;
    private PackageListFX selectedPackage;

    // Instantiation
    public static ListManagerFX getInstance() {
        if (instance == null) {
            synchronized (ListManager.class) { // Synchronized to prevent multiple threads checking, returning null and creating multiple instances.
                if (instance == null) {
                    instance = new ListManagerFX();
                }
            }
        }
        return instance;
    }

    // Constructors
    private ListManagerFX() {
        this.lists = FXCollections.observableArrayList();
    }

    // Getters, Setters
    public void setLists(List<PackageListFX>lists) {
        this.lists.setAll(lists);
    }
    public List<PackageListFX> getLists() {
        return new ArrayList<>(this.lists);
    }
    public ObservableList<PackageListFX> getFXLists() {
        return this.lists;
    }


    public PackageListFX getSelectedPackageList() {
        return this.selectedPackage;
    }
    public void setSelectedPackageList(PackageListFX selectedPackage) {
        this.selectedPackage = selectedPackage;
    }

    // Methods
    public void createPackageList(String packageListName){
        PackageListFX newPackageList = new PackageListFX(packageListName);
        lists.add(newPackageList);
    }

    // Used one time for favourite creation.
    public void createFavouriteList() {
        System.out.println("Favlist does not exist");
        PackageListFX newPackageList = new PackageListFX("Favourites", "favourite-list-uuid");
        lists.add(newPackageList);
    }

    public void deletePackageList(PackageListFX packageList) {
        lists.remove(packageList);
    }
}