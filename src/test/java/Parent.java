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
    @DisplayName("Just Title Example")
    @Description("That description describes some information about test")
    @Severity(SeverityLevel.BLOCKER)
    @Link(name = "@Link", url = "https://qameta.io")
    void test1 () {
        Allure.suite("Suite1 label example");

        step("Arrange", () -> {
            step("Go here", () -> {
                step("Take first value");
            });
            step("Another point", () -> {
                step("Take second value");
            });
        });
        step("Act", () -> {
            step("Some actions", () -> {
                step("First step");
                step("Second step");
                step("Looks like we need to attach something", () -> {
                    textAttachment("Middle", "Some text inside test");
                });

                Allure.link("It's a link", "https://qameta.io");
                Allure.link("Another link", "https://qameta.io");

                Allure.epic("Epic1 label example");
                Allure.feature("Feature1 label example");
                Allure.story("Story1 label example");

            });
        });
        step("Assert", () -> {
            step("Simple assert of first and second values");
            textAttachment("Final", "That's all folks!");
        });
    }

    @Attachment(value = "Annotated attachment [{type}]", type = "text/plain", fileExtension = ".txt")
    public byte[] textAttachment(String type, String content) {
        return content.getBytes(StandardCharsets.UTF_8);
    }

}
