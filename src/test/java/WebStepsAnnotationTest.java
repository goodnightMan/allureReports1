import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebStepsAnnotationTest {

    private static final String BASE_URL = "https://github.com/";
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String NAME_ISSUE = "Listeners NamedBy";

    @Step("Открываем главную страницу github")
    public void openPage() {
        open(BASE_URL);
    }

    @Step("Ищем репозиторий")
    public void searchToRepository() {
        $("[name=q]").val(REPOSITORY).pressEnter();
    }

    @Step("Переходим в репозиторий")
    public void goToRepository() {
        $(byAttribute("href", "/" + REPOSITORY)).click();
    }

    @Step("Открываем раздел Ошибки")
    public void openIssue() {
        $(byAttribute("href", "/" + REPOSITORY + "/issues")).click();
    }

    @Step("Проверка что ошибка 68 с названием Listeners NamedBy видна")
    public void assertIssue() {
        $(byText(NAME_ISSUE)).shouldBe(Condition.visible);
    }

}
