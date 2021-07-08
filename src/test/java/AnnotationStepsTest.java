import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class AnnotationStepsTest {

    private final WebStepsAnnotationTest steps = new WebStepsAnnotationTest();

    @Test
    @Feature("LookIssue")
    @Owner("goodnightMen")
    @Severity(SeverityLevel.BLOCKER)
    public void testIssueSearch() {

        steps.openPage();
        steps.searchToRepository();
        steps.goToRepository();
        steps.openIssue();
        steps.assertIssue();
    }
}
