import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps extends BaseTest {

    @Step("Открываем главную страницу")
    @DisplayName("Открываем браузер")
    public void openMainPage() {
        open("/");
    }

    @Step("Ищем репозиторий {repo}")
    @DisplayName("Заполняем нужным значением поисковик и нажимаем enter")
    public void searchForRepository(String repo) {
        $("[data-target='qbsearch-input.inputButtonText']").click();
        $("#query-builder-test").sendKeys(repo);
        $("#query-builder-test").submit();
    }

    @Step("Кликаем по ссылке репозитория {repo}")
    @DisplayName("Кликаем по нужной ссылке")
    public void clickOnRepositoryLink(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Открываем таб Issues")
    @DisplayName("Открываем Issues")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие Issue с номером {issue}")
    @DisplayName("Проверяем наличие Issue с нужным номером")
    public void shouldSeeIssueWithNumber(int issue) {
        $(withText("#" + issue)).should(Condition.exist);
    }

}