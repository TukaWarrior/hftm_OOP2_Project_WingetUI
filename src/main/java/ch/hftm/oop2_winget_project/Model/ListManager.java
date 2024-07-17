package ch.hftm.oop2_winget_project.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListManager implements Serializable {

//    DTO = Data Transfer Object
//    This class is a simpler version of it's corresponding model class.
//    It is used to convert complex data types that are not serializable into simpler datatypes that are serializable.
//    JavaFX Observables are not seralizable.

//    Variables
    private static final long serialVersionUID = 1L;
    private static ListManager instance;
    private List<PackageList> lists;

    // Instantiation
    public static ListManager getInstance() {
        if (instance == null) {
            synchronized (ListManager.class) { // Synchronized to prevent multiple threads checking, returning null and creating multiple instances.
                if (instance == null) {
                    instance = new ListManager();
                }
            }
        }
        return instance;
    }

    // Constructors
    public ListManager() {
        this.lists = new ArrayList<>();
    }

    // Methods
    public List<PackageList> getList() {
        return this.lists;
    }
    public void setList(List<PackageList> list) {
        this.lists = list;
    }
}