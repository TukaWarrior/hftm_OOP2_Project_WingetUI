package ch.hftm.oop2_winget_project.Persistence;

import ch.hftm.oop2_winget_project.Model.ListManagerFX;
import ch.hftm.oop2_winget_project.Model.ListManager;
import ch.hftm.oop2_winget_project.Model.PackageListFX;
import ch.hftm.oop2_winget_project.Model.PackageList;
import ch.hftm.oop2_winget_project.Model.WinGetPackageFX;
import ch.hftm.oop2_winget_project.Model.WinGetPackage;

import javafx.collections.FXCollections;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class DTOConverter {
//  DTO: Data Transfer Object (An object used to transfer data from one system to another).
//  This class converts the instances of ListManager > PackageList > WinGetPackage to ListManagerDTO > PackageListDTO > WinGetPackageDTO and back.
//  This conversion was implemented because the model classes contain JavaFX elements, which can not be serialized.
//  Converting to an DTO model replaces the JavaFX elements with regular attributes and vice-versa if a DTO model gets converted back.

    private static final Logger LOGGER = Logger.getLogger(DTOConverter.class.getName());

    // Converts ListManager to ListManagerDTO.
    public static ListManager toListManager(ListManagerFX listManagerFX) {
        System.out.println("DTOConverter: Conversion ListManager to ListManagerDTO starting.");
        LOGGER.log(Level.INFO, "Conversion ListManager to ListManagerDTO starting.");
        try {
            ListManager listManager = new ListManager();
            List<PackageList> packageListDTOs = listManagerFX.getLists()
                    .stream()
                    .map(DTOConverter::toPackageList)
                    .collect(Collectors.toList());
            listManager.setList(packageListDTOs);
            System.out.println("DTOConverter: Conversion ListManager to ListManagerDTO for successful.");
            LOGGER.log(Level.INFO, "Conversion ListManager to ListManagerDTO successful.");
            return listManager;
        } catch (Exception e) {
            System.out.println("DTOConverter: Conversion ListManager to ListManagerDTO failed: " + e.getMessage());
            LOGGER.log(Level.WARNING, "Conversion ListManager to ListManagerDTO failed: {0}", e.getMessage());
            return null;
        }
    }

    // Converts ListManagerDTO back to ListManager.
    public static ListManagerFX toListManagerFX(ListManager listManager) {
        System.out.println("DTOConverter: Conversion ListManagerDTO to ListManager starting.");
        LOGGER.log(Level.INFO, "Conversion ListManagerDTO to ListManager starting.");
        try {
            ListManagerFX listManagerFX = ListManagerFX.getInstance();
            listManagerFX.setLists(FXCollections.observableArrayList(listManager.getList().stream()
                    .map(DTOConverter::toPackageListFX)
                    .collect(Collectors.toList())));
            System.out.println("DTOConverter: Conversion ListManagerDTO to ListManager for successful.");
            LOGGER.log(Level.INFO, "Conversion ListManagerDTO to ListManager successful.");
            return listManagerFX;
        } catch (Exception e) {
            System.out.println("DTOConverter: Conversion ListManagerDTO to ListManager failed: " + e.getMessage());
            LOGGER.log(Level.WARNING, "Conversion ListManagerDTO to ListManager failed: {0}", e.getMessage());
            return null;
        }
    }

    // Converts PackageList to PackageListDTO.
    public static PackageList toPackageList(PackageListFX packageListFX) {
        System.out.println("DTOConverter: Conversion PackageList to PackageListDTO for " + (packageListFX == null ? "null" : packageListFX.getName()) + " starting.");
        LOGGER.log(Level.INFO, "Conversion PackageList to PackageListDTO for {0} starting.", packageListFX != null ? packageListFX.getName() : "null");
        try {
            PackageList packageList = new PackageList();
            packageList.setId(packageListFX.getId());
            packageList.setName(packageListFX.getName());
            packageList.setSize(packageListFX.getSize());
            List<WinGetPackage> winGetPackageDTOs = packageListFX.getFXPackages()
                    .stream()
                    .map(DTOConverter::toWinGetPackage)
                    .collect(Collectors.toList());
            packageList.setPackages(winGetPackageDTOs);
            System.out.println("DTOConverter: Conversion PackageList to PackageListDTO for " + packageListFX.getName() + " successful.");
            LOGGER.log(Level.INFO, "Conversion PackageList to PackageListDTO for {0} successful.", packageListFX.getName());
            return packageList;
        } catch (Exception e) {
            System.out.println("DTOConverter: Conversion PackageList to PackageListDTO failed: " + e.getMessage());
            LOGGER.log(Level.WARNING, "Conversion PackageList to PackageListDTO failed: {0}", e.getMessage());
            return null;
        }
    }

    // Converts PackageListDTO back to PackageList.
    public static PackageListFX toPackageListFX(PackageList packageList) {
        System.out.println("DTOConverter: Conversion PackageListDTO to PackageList for " + (packageList == null ? "null" : packageList.getName()) + " starting.");
        LOGGER.log(Level.INFO, "Conversion PackageListDTO to PackageList for {0} starting.", packageList != null ? packageList.getName() : "null");
        try {
            PackageListFX packageListFX = new PackageListFX(packageList.getName());
            packageListFX.setId(packageList.getId());
            packageListFX.setName(packageList.getName());
            packageListFX.setSize(packageList.getSize());
            packageListFX.setPackages(packageList.getPackages().stream()
                    .map(DTOConverter::toWinGetPackageFX)
                    .collect(Collectors.toCollection(FXCollections::observableArrayList)));
            System.out.println("DTOConverter: Conversion PackageListDTO to PackageList for " + packageList.getName() + " successful.");
            LOGGER.log(Level.INFO, "Conversion PackageListDTO to PackageList for {0} successful.", packageList.getName());
            return packageListFX;
        } catch (Exception e) {
            System.out.println("DTOConverter: Conversion PackageListDTO to PackageList failed: " + e.getMessage());
            LOGGER.log(Level.WARNING, "Conversion PackageListDTO to PackageList failed: {0}", e.getMessage());
            return null;
        }

    }

    // Converts WinGetPackage to WinGetPackageDTO.
    public static WinGetPackage toWinGetPackage(WinGetPackageFX winGetPackageFX) {
        System.out.println("DTOConverter: Conversion WinGetPackage to WinGetPackageDTO for " + (winGetPackageFX == null ? "null" : winGetPackageFX.getName()) + " starting.");
        LOGGER.log(Level.INFO, "Conversion WinGetPackage to WinGetPackageDTO for {0} starting.", winGetPackageFX != null ? winGetPackageFX.getName() : "null");
        try {
            WinGetPackage winGetPackage = new WinGetPackage();
            winGetPackage.setName(winGetPackageFX.getName());
            winGetPackage.setId(winGetPackageFX.getId());
            winGetPackage.setVersion(winGetPackageFX.getVersion());
            winGetPackage.setSource(winGetPackageFX.getSource());
            System.out.println("DTOConverter: Conversion WinGetPackage to WinGetPackageDTO for " + winGetPackageFX.getName() + " successful.");
            LOGGER.log(Level.INFO, "Conversion WinGetPackage to WinGetPackageDTO for {0} successful.", winGetPackageFX.getName());
            return winGetPackage;
        } catch (Exception e) {
            System.out.println("DTOConverter: Conversion WinGetPackage to WinGetPackageDTO failed: " + e.getMessage());
            LOGGER.log(Level.WARNING, "Conversion WinGetPackage to WinGetPackageDTO failed: {0}", e.getMessage());
            return null;
        }
    }

    // Converts WinGetPackageDTO back to WinGetPackage.
    public static WinGetPackageFX toWinGetPackageFX(WinGetPackage winGetPackage) {
        System.out.println("DTOConverter: Conversion WinGetPackageDTO to WinGetPackage for " + (winGetPackage == null ? "null" : winGetPackage.getName()) + " starting.");
        LOGGER.log(Level.INFO, "Conversion WinGetPackageDTO to WinGetPackage for {0} starting.", winGetPackage != null ? winGetPackage.getName() : "null");
        try {
            WinGetPackageFX winGetPackageFX = new WinGetPackageFX();
            winGetPackageFX.setName(winGetPackage.getName());
            winGetPackageFX.setId(winGetPackage.getId());
            winGetPackageFX.setVersion(winGetPackage.getVersion());
            winGetPackageFX.setSource(winGetPackage.getSource());
            System.out.println("DTOConverter: Conversion WinGetPackageDTO to WinGetPackage for " + winGetPackage.getName() + " successful.");
            LOGGER.log(Level.INFO, "Conversion WinGetPackageDTO to WinGetPackage for {0} successful.", winGetPackage.getName());
            return winGetPackageFX;
        } catch (Exception e) {
            System.out.println("DTOConverter: Conversion WinGetPackageDTO to WinGetPackage failed: " + e.getMessage());
            LOGGER.log(Level.WARNING, "Conversion WinGetPackageDTO to WinGetPackage failed: {0}", e.getMessage());
            return null;
        }
    }
}