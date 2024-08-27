import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class AllureTest extends BaseTest {
    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("sergey_qa")
    @Link(value = "Testing", url = "https://github.com")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Поиск Issue для авторизированного пользователя")
    public void testIssueSearchTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("/");
        });
        step("Кликаем на поиск", () -> {
            $("[data-target='qbsearch-input.inputButtonText']").click();
        });
        step("Вводим значение в поисковик" + LINK_TEXT, () -> {
            $("#query-builder-test").sendKeys(LINK_TEXT);
        });
        step("Нажимаем кнопку  ENTER", () -> {
            $("#query-builder-test").submit();
        });
        step("Кликаем на ссылочный текст" + LINK_TEXT, () -> {
            $(linkText(LINK_TEXT)).click();
        });
        step("Выбираем раздел Issue", () -> {
            $("#issues-tab").click();
        });
        step("Убеждаемся, что на странице присутствует данная подстрока" + ISSUE, () -> {
            $(withText("#" + ISSUE)).should(Condition.exist);
        });
    }

    private static final String LINK_TEXT = "eroshenkoam/allure-example";

    private static final int ISSUE = 80;

    @Test
    public void testAnnotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(LINK_TEXT);
        steps.clickOnRepositoryLink(LINK_TEXT);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(ISSUE);

    }
}