// package Model;

// import ch.hftm.oop2_winget_project.Model.ListManager;
// import ch.hftm.oop2_winget_project.Model.PackageList;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import java.util.ArrayList;
// import java.util.List;

// import static org.junit.jupiter.api.Assertions.*;

// class ListManagerDTOTest {

//     private ListManager listManagerDTO;

//     @BeforeEach
//     void setUp() {
//         // Reset the singleton for each test to ensure a clean state
//         listManagerDTO = ListManager.getInstance();
//         listManagerDTO.setList(new ArrayList<>()); // Ensure it's empty before each test.
//     }

//     @Test
//     void testSingletonInstance() {
//         ListManager anotherInstance = ListManager.getInstance();
//         assertNotNull(listManagerDTO, "ListManagerDTO instance should not be null");
//         assertSame(listManagerDTO, anotherInstance, "Instances should be the same (singleton pattern)");
//     }

//     @Test
//     void testSetAndGetList() {
//         List<PackageList> newList = new ArrayList<>();
//         PackageList packageListDTO = new PackageList();
//         packageListDTO.setId("1");
//         packageListDTO.setName("TestList");
//         packageListDTO.setSize(5);
//         newList.add(packageListDTO);

//         listManagerDTO.setList(newList);
//         assertEquals(newList, listManagerDTO.getList(), "The set and get lists should be the same");
//         assertEquals(1, listManagerDTO.getList().size(), "The list size should be 1 after adding one list");
//     }

//     @Test
//     void testListContents() {
//         PackageList packageListDTO = new PackageList();
//         packageListDTO.setId("2");
//         packageListDTO.setName("AnotherTestList");
//         packageListDTO.setSize(10);

//         listManagerDTO.setList(new ArrayList<>(List.of(packageListDTO)));
//         List<PackageList> retrievedList = listManagerDTO.getList();

//         assertNotNull(retrievedList, "Retrieved list should not be null");
//         assertEquals(1, retrievedList.size(), "Retrieved list should contain one element");
//         assertEquals(packageListDTO, retrievedList.get(0), "The element should match the added PackageListDTO");
//     }

//     @Test
//     void testListModification() {
//         PackageList packageListDTO1 = new PackageList();
//         packageListDTO1.setId("1");
//         packageListDTO1.setName("FirstList");
//         packageListDTO1.setSize(3);

//         PackageList packageListDTO2 = new PackageList();
//         packageListDTO2.setId("2");
//         packageListDTO2.setName("SecondList");
//         packageListDTO2.setSize(7);

//         List<PackageList> initialList = new ArrayList<>(List.of(packageListDTO1, packageListDTO2));
//         listManagerDTO.setList(initialList);

//         // Modify the list after setting it
//         List<PackageList> newList = listManagerDTO.getList();
//         newList.remove(0); // Remove the first element
//         listManagerDTO.setList(newList); // Update the list in DTO

//         assertEquals(1, listManagerDTO.getList().size(), "The list size should be reduced to 1 after removal");
//         assertEquals(packageListDTO2, listManagerDTO.getList().get(0), "The remaining list item should be 'SecondList'");
//     }
// }