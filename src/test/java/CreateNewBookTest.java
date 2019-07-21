import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


// A simple test which creates a new book with all fields filled
// Verifying that the book is in the library
// Cleaning up after itself by deleting the created record
// The values are hardcoded, although could be parsed from JSON file with proper libraries used.
// Default browser for Selenide is Firefox, i have changed the configuration to Chrome. Left the BeforeTest open, because you can later specify the browser in the command line in Babmoo.

public class CreateNewBookTest {


    @BeforeTest
    public void setUp(){
        Configuration.timeout = 5000;
        Configuration.startMaximized = true;
    }

    @Test
    public void createNewBookWithAllFieldsFilled(){
        LibraryPage.createNewBook();
    }

    @Test
    public void verifyThatBookIsListedInCatalogue(){
        LibraryPage.openCatalogAndSelectCreatedBook();
    }


    @AfterClass
    public void cleanUp(){
        LibraryPage.deleteBook();
    }

}
