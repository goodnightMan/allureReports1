import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CleanSelenideTest {
    private static final String BASE_URL = "https://github.com/";
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String NAME_ISSUE = "Listeners NamedBy";

    @Test
    public void lookIssueTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());
        // перейти на гитхаб
        open(BASE_URL);
        // ищем репозиторий eroshenkoam/allure-example
        $("[name=q]").val(REPOSITORY).pressEnter();
        // перейти в репозиторий eroshenkoam/allure-example
        $(byAttribute("href", "/" + REPOSITORY)).click();
        // перейти по Issues
        $(byAttribute("href", "/" + REPOSITORY + "/issues")).click();
        // проверка что ошибка 68 с названием Listeners NamedBy видна
        $(byText(NAME_ISSUE)).shouldBe(Condition.visible);
    }
}
