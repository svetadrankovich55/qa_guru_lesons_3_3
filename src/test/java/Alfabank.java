import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class Alfabank {

    @Test
    void testAlfa() {
        Configuration.browserSize = "1900x1200";
        open("https://alfabank.ru/");

        $(byText("Вклады")).click();
        $$(byText("Депозиты")).find(visible).parent().click();
        $(byText("Архивные счета и депозиты")).click();
        $$(byText("Депозиты")).find(visible).click();
        $("#filter").$$("[data-widget-name=CatalogCard]").shouldHaveSize(5);

    }

    @Test
    void testAlfaSibling() {
        Configuration.browserSize = "1900x1200";
        open("https://alfabank.ru/");

        $(byText("Вклады")).click();
        $$(byText("Депозиты")).find(visible).parent().click();
        $("[data-test-id=tabs-list-tabTitle-0]").sibling(0).click();
        $("[data-test-id=tabs-list-tabTitle-0]").sibling(0).$("span").shouldHave(text("Страхование вкладов"));

    }

    @Test
    void testAlfaPrecending() {
        Configuration.browserSize = "1900x1200";
        open("https://alfabank.ru/");

        $(byText("Вклады")).click();
        $$(byText("Депозиты")).find(visible).parent().click();
        $("[data-test-id=tabs-list-tabTitle-2]").preceding(0).click();
        $("[data-test-id=tabs-list-tabTitle-2]").preceding(0).$("span").shouldHave(text("Страхование вкладов"));

    }

    @Test
    void testAlfaClosest() {
        Configuration.browserSize = "1900x1200";
        open("https://alfabank.ru/");

        $(byText("Вклады")).click();
        $$(byText("Депозиты")).find(visible).parent().click();
        $("#good-to-know [data-test-id=tabs-list-tabTitle-1] span").closest("button").click();
        $("[data-test-id=tabs-list-tabTitle-1] span").shouldHave(text("Страхование вкладов"));
    }

    @Test
    void testAlfaParent() {
        Configuration.browserSize = "1900x1200";
        open("https://alfabank.ru/");

        $(byText("Вклады")).click();
        $$(byText("Депозиты")).find(visible).parent().click();
        $("#good-to-know [data-test-id=tabs-list-tabTitle-1] span").parent().click();
        $("[data-test-id=tabs-list-tabTitle-1] span").shouldHave(text("Страхование вкладов"));

    }

}