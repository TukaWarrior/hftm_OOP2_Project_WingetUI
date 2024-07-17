package ch.hftm.oop2_winget_project.Model;

import ch.hftm.oop2_winget_project.Api.AbstractWinGetPackage;
import javafx.beans.property.SimpleStringProperty;

public class WinGetPackageFX extends AbstractWinGetPackage {


    // Variables
    private SimpleStringProperty name = new SimpleStringProperty();
    private SimpleStringProperty id = new SimpleStringProperty();
    private SimpleStringProperty version = new SimpleStringProperty();
    private SimpleStringProperty updateVersion = new SimpleStringProperty();
    private SimpleStringProperty source = new SimpleStringProperty();
    private boolean isInstalled;


    //Constructors
    public WinGetPackageFX() {
    }

    public WinGetPackageFX(String name, String id, String version, String source) {
        this.setName(name);
        this.setId(id);
        this.setVersion(version);
        this.setSource(source);
    }

    public WinGetPackageFX(String name, String id, String version, String updateVersion, String source) {
        this.setName(name);
        this.setId(id);
        this.setVersion(version);
        this.setUpdateVersion(updateVersion);
        this.setSource(source);
    }

    // Adjusted Constructor to match DTO fields
    public WinGetPackageFX(String name, String id, String version, String source, boolean isInstalled) {
        this.name = new SimpleStringProperty(name);
        this.id = new SimpleStringProperty(id);
        this.version = new SimpleStringProperty(version);
        this.source = new SimpleStringProperty(source);
        this.isInstalled = isInstalled;
    }


    // Getters, Setters
    public String getName() {
        return this.name.get();
    }
    public void setName(String name) {
        this.name.set(name);
    }
    public SimpleStringProperty getFXName() {
        return this.name;
    }
    

    public String getId() {
        return this.id.get();
    }
    public void setId(String id) {
        this.id.set(id);
    }
    public SimpleStringProperty getFXId() {
        return this.id;
    }


    public String getVersion() {
        return this.version.get();
    }
    public void setVersion(String version) {
        this.version.set(version);
    }
    public SimpleStringProperty getFXVersion() {
        return this.version;
    }


    public String getUpdateVersion() {
        return this.updateVersion.get();
    }
    public void setUpdateVersion(String updateVersion) {
        this.updateVersion.set(updateVersion);
    }
    public SimpleStringProperty getFXUpdateVersion() {
        return this.updateVersion;
    }


    public String getSource() {
        return this.source.get();
    }
    public void setSource(String source) {
        this.source.set(source);
    }
    public SimpleStringProperty getFXSource() {
        return this.source;
    }

    
    public boolean isInstalled() {
        return this.isInstalled;
    }
    public void setInstalled(boolean installed) {
        this.isInstalled = installed;
    }
}