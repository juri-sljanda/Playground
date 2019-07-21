
import com.codeborne.selenide.Condition;
import java.util.logging.Logger;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class LibraryPage {
    private static Logger log = Logger.getLogger(LibraryPage.class.getName());

    public static void createNewBook(){

        log.info("Creating a new book");
        open("https://raamatukogu.herokuapp.com/catalog/book/create");

        log.info("Entering title");
        $("#title").shouldBe(Condition.visible).setValue("Hello There");

        log.info("Choosing Author");
        $("#author").shouldBe(Condition.visible).selectOption("General, Kenobi");

        log.info("Entering summary");
        $("#summary").shouldBe(Condition.visible).setValue("no genre");

        log.info("Entering ISBN");
        $("#isbn").shouldBe(Condition.visible).setValue("test123");

        log.info("Choosing Fiction genre");
        $(byText("Fiction")).shouldBe(Condition.visible).click();

        log.info("Clicking Submit");
        $(byText("Submit")).shouldBe(Condition.visible).click();

        log.info("Verifying");
        $("body > div > div > div.col-sm-10 > h1").shouldHave(Condition.text("Title: Hello There"));

    }

    public static void openCatalogAndSelectCreatedBook(){
        log.info("Opening Catalog");
        open("https://raamatukogu.herokuapp.com/catalog/books");

        log.info("Verifying that book exists and clicking on the title");
        $(byText("Hello There")).should(Condition.exist).click();

        log.info("Double check for the title");
        $("body > div > div > div.col-sm-10 > h1").shouldHave(Condition.text("Title: Hello There"));
    }

    public static void deleteBook(){
        log.info("Opening Catalog");
        open("https://raamatukogu.herokuapp.com/catalog/books");

        log.info("Verifying that book exists and clicking on the title");
        $(byText("Hello There")).should(Condition.exist).click();

        log.info("Clicking Delete book");
        $(byText("Delete Book")).shouldBe(Condition.visible).click();

        log.info("Confirming delete");
        $(byText("Delete")).shouldBe(Condition.visible).click();

        log.info("Verifying that record is not present");
        $(byText("Hello There")).shouldNot(Condition.exist);

    }

}
