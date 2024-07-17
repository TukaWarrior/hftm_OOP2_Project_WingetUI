// package Persistence;

// import ch.hftm.oop2_winget_project.Model.*;
// import static org.junit.jupiter.api.Assertions.*;

// import ch.hftm.oop2_winget_project.Persistence.DTOConverter;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import javafx.collections.FXCollections;

// import java.util.ArrayList;
// import java.util.List;

// public class DTOConverterTest {

//     private ListManagerFX listManager;
//     private ListManager listManagerDTO;
//     private PackageListFX packageList;
//     private PackageList packageListDTO;
//     private WinGetPackageFX winGetPackage;
//     private WinGetPackage winGetPackageDTO;

//     @BeforeEach
//     void setUp() {
//         // Initialize test objects.
//         listManager = ListManagerFX.getInstance();
//         listManagerDTO = new ListManager();

//         packageList = new PackageListFX("TestPackageList");
//         packageListDTO = new PackageList();
//         packageListDTO.setName("TestPackageListDTO");

//         winGetPackage = new WinGetPackageFX("TestName", "TestId", "TestVersion", "TestSource");
//         winGetPackageDTO = new WinGetPackage();
//         winGetPackageDTO.setName("TestNameDTO");

//         // Populate the models
//         packageList.addPackage(winGetPackage);
//         listManager.createPackageList("TestPackageList");

//         // Populate the DTOs
//         // packageListDTO.setPackages(FXCollections.observableArrayList(winGetPackageDTO));
//         // listManagerDTO.setList(FXCollections.observableArrayList(packageListDTO));

//         List<WinGetPackage> winGetPackageDTOList = new ArrayList<>();
//         winGetPackageDTOList.add(winGetPackageDTO);
//         packageListDTO.setPackages(winGetPackageDTOList);

//         List<PackageList> packageListDTOList = new ArrayList<>();
//         packageListDTOList.add(packageListDTO);
//         listManagerDTO.setList(packageListDTOList);
//     }

//     @Test
//     void testToListManagerDTO() {
//         ListManager result = DTOConverter.toListManagerDTO(listManager);
//         assertNotNull(result);
//         assertFalse(result.getList().isEmpty());
//         assertEquals(listManager.getLists().size(), result.getList().size());
//         // Additional assertions based on your data structure and requirements
//     }

//     @Test
//     void testFromListManagerDTO() {
//         ListManagerFX result = DTOConverter.fromListManagerDTO(listManagerDTO);
//         assertNotNull(result);
//         assertFalse(result.getLists().isEmpty());
//         assertEquals(listManagerDTO.getList().size(), result.getLists().size());
//         // Additional assertions
//     }

//     @Test
//     void testToPackageListDTO() {
//         PackageList result = DTOConverter.toPackageListDTO(packageList);
//         assertNotNull(result);
//         assertEquals(packageList.getName(), result.getName());
//         assertEquals(packageList.getPackages().size(), result.getPackages().size());
//         // Additional assertions
//     }

//     @Test
//     void testFromPackageListDTO() {
//         PackageListFX result = DTOConverter.fromPackageListDTO(packageListDTO);
//         assertNotNull(result);
//         assertEquals(packageListDTO.getName(), result.getName());
//         assertEquals(packageListDTO.getPackages().size(), result.getPackages().size());
//         // Additional assertions
//     }

//     @Test
//     void testToWinGetPackageDTO() {
//         WinGetPackage result = DTOConverter.toWinGetPackageDTO(winGetPackage);
//         assertNotNull(result);
//         assertEquals(winGetPackage.getName(), result.getName());
//         assertEquals(winGetPackage.getId(), result.getId());
//         assertEquals(winGetPackage.getVersion(), result.getVersion());
//         assertEquals(winGetPackage.getSource(), result.getSource());
//         // Additional assertions
//     }

//     @Test
//     void testFromWinGetPackageDTO() {
//         WinGetPackageFX result = DTOConverter.fromWinGetPackageDTO(winGetPackageDTO);
//         assertNotNull(result);
//         assertEquals(winGetPackageDTO.getName(), result.getName());
//         assertEquals(winGetPackageDTO.getId(), result.getId());
//         assertEquals(winGetPackageDTO.getVersion(), result.getVersion());
//         assertEquals(winGetPackageDTO.getSource(), result.getSource());
//         // Additional assertions
//     }
// }