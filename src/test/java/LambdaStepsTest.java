import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaStepsTest {

    private static final String BASE_URL = "https://github.com/";
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String NAME_ISSUE = "Listeners NamedBy";

    @Test
    public void lookIssueTest() {
        // лямбда степы
        step("Открываем главную страницу github", () -> {
            open(BASE_URL);
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $("[name=q]").val(REPOSITORY).pressEnter();
        });
        step("Переходим в репозиторий " + REPOSITORY, () -> {
            $(byAttribute("href", "/" + REPOSITORY)).click();
        });
        step("Открываем раздел Ошибки "+ REPOSITORY, () -> {
            $(byAttribute("href", "/" + REPOSITORY + "/issues")).click();
        });
        step("Проверка что ошибка 68 с названием " + NAME_ISSUE +" видна", () -> {
            $(byText(NAME_ISSUE)).shouldBe(Condition.visible);
        });
    }
}
