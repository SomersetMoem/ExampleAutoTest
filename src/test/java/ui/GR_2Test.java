package ui;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.TmsLink;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import test.org.DataGeneration;
import test.org.models.Product;
import ui.pages.BasketPage;
import ui.pages.Header;
import ui.pages.MainPage;

import java.io.IOException;

@Epic("UI")
@Feature("Main")
public class GR_2Test extends BaseSelenideTest {
    private SoftAssert soft = new SoftAssert();
    private DataGeneration dataGeneration = new DataGeneration();
    private MainPage mainPage;
    private Header header;
    private BasketPage basketPage;

    @DataProvider(name = "data-provider")
    public Object[][] testData() throws IOException {
        Product product = dataGeneration.generateTestData("src/test/resource/dataTest/GR_2.json", Product.class);
        return new Object[][]{{product}};
    }

    @TmsLink("GR-1")
    @Test(description = "Добавление товара в корзину, если пользователь не авторизирован")
    public void test(Product product) {


        soft.assertAll();
    }

    @Step("Шаг 1. Открыть главную страницу")
    private void step_1() {
        mainPage = new MainPage(true);
        header = new Header();
    }

    @Step("Шаг 2. Нажать кнопку 'Корзина'")
    private void step_2() {
      basketPage = header.clickBasketBtn(3, soft);
    }

    @Step("Шаг 3. Проверить, что корзина пустая")
    private void step_3() {
        basketPage.checkBasketIsEmpty(true, soft);
    }

    @Step("Шаг 4. Вернутся на главную страницу с помощью кнопки 'Перейти на главную'")
    private void step_4() {
        mainPage = basketPage.clickBackMainBtnBtn(3);
    }

    @Step("Шаг 5. Добавить товар в корзину")
    private void step_5(Product product) {
        basketPage.clickBackMainBtnBtn()
    }
}
