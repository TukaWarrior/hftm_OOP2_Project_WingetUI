// package Model;

// import ch.hftm.oop2_winget_project.Model.ListManagerFX;
// import ch.hftm.oop2_winget_project.Model.PackageListFX;
// import javafx.collections.FXCollections;
// import javafx.collections.ObservableList;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

// import java.util.ArrayList;
// import java.util.List;

// import static org.junit.jupiter.api.Assertions.*;

// class ListManagerTest {

//     private ListManagerFX listManager;

//     @BeforeEach
//     void setUp() {
//         // Initialize ListManager singleton instance; Used in multiple tests.
//         listManager = ListManagerFX.getInstance();
//         listManager.setLists(new ArrayList<>()); // Ensure it's empty before each test.
//     }

//     @Test
//     void testSingletonInstance() {
//         ListManagerFX anotherInstance = ListManagerFX.getInstance();
//         assertNotNull(listManager, "ListManager instance should not be null");
//         assertSame(listManager, anotherInstance, "Instances should be the same (singleton)");
//     }

//     @Test
//     void testCreateAndDeletePackageList() {
//         String listName = "TestList";
//         listManager.createPackageList(listName);
//         assertEquals(1, listManager.getLists().size(), "List size should be 1 after adding a list");
//         assertEquals(listName, listManager.getLists().get(0).getName(), "The name of the package list should be 'TestList'");

//         listManager.deletePackageList(listManager.getLists().get(0));
//         assertTrue(listManager.getLists().isEmpty(), "List should be empty after removing the package list");
//     }

//     @Test
//     void testSetAndGetLists() {
//         ObservableList<PackageListFX> newLists = FXCollections.observableArrayList(new PackageListFX("NewList"));
//         listManager.setFXLists(newLists);
//         assertEquals(newLists, listManager.getFXLists(), "The lists should match the set lists");
//         assertEquals(1, listManager.getLists().size(), "The size should reflect the new lists' size");
//     }

//     @Test
//     void testSelectedPackageListGetterSetter() {
//         PackageListFX newPackageList = new PackageListFX("SelectedList");
//         listManager.setSelectedPackageList(newPackageList);
//         assertEquals(newPackageList, listManager.getSelectedPackageList(), "The selected package list should match the new package list");
//     }

//     @Test
//     void testGetListsReturnsCopy() {
//         listManager.createPackageList("ImmutableList");
//         List<PackageListFX> retrievedLists = listManager.getLists();
//         assertNotSame(retrievedLists, listManager.getFXLists(), "getLists should return a copy, not the original list");
//         assertEquals(retrievedLists.size(), listManager.getFXLists().size(), "The copy should have the same size as the original");
//     }

//     @Test
//     void testModifyingRetrievedListDoesNotAffectOriginal() {
//         listManager.createPackageList("TestList");
//         List<PackageListFX> retrievedLists = listManager.getLists();
//         retrievedLists.remove(0);
//         assertFalse(listManager.getLists().isEmpty(), "Modifying the retrieved list should not affect the original list");
//     }
// }