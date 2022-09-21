import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static io.qameta.allure.Allure.step;

public class Parent {
    @Test
    @Tag("EXTENSION")
    @Epic("@Epic")
    @AllureId("777")
    @DisplayName("This is from the Parent class with test - JUnit5 DisplayName annotation")
    @Description("@That description describes some information about test")
    @Link(name = "@Link", url = "https://qameta.io")
    void test1() {
        step("Add Suite, Epic, Feature, Story and Links by allure label", () -> {
            Allure.link("It's a label link", "https://qameta.io");
            Allure.suite("Suite1 label example");
            Allure.epic("Epic1 label example");
            Allure.feature("Feature1 label example");
            Allure.story("Story1 label example");
        });
        step("Allure annotations is missed in Child class", () -> {
            textAttachment("Final", "@AllureId(\"777\")");
            textAttachment("Final", "@Link(name = \"@Link\", url = \"https://qameta.io\")");
            textAttachment("Final", "@Description(\"@That description describes some information about test\")");
            textAttachment("Final", "@Epic(\"@Epic\")");
        });
    }
    @Attachment(value = "Annotated attachment [{type}]", type = "text/plain", fileExtension = ".txt")
    public byte[] textAttachment(String type, String content) {
        return content.getBytes(StandardCharsets.UTF_8);
    }
}
