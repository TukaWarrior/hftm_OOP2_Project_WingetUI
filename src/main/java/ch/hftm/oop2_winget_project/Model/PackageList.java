package ch.hftm.oop2_winget_project.Model;

import java.io.Serializable;
import java.util.List;

public class PackageList implements Serializable {

//    DTO = Data Transfer Object
//    This class is a simpler version of it's corresponding model class.
//    It is used to convert complex data types that are not serializable into simpler datatypes that are serializable.
//    JavaFX Observables are not seralizable.


    // Variables
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private int size;
    private List<WinGetPackage> packages;


    // Constructors
    public PackageList() {
    }


    // Getters, Setters
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }


    public List<WinGetPackage> getPackages() {
        return this.packages;
    }

    public void setPackages(List<WinGetPackage> packages) {
        this.packages = packages;
    }
}