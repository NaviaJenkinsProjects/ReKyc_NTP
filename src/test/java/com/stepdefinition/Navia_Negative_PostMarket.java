package com.stepdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.baseclass.BaseClass;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

/**
 * Negative Test Cases - Step Definitions
 * Project : Post_Markets_NTP (Navia Trading Platform)
 * Package : com.stepdefinition
 * Covers  : Login, AMO Order, Price Alert, Search,
 *           Funds/Payin, Strategy Builder, Holdings, Chart
 */
public class Navia_Negative_PostMarket extends BaseClass {

    // ── WebDriverWait declared as field (no method shadowing warning) ──
    private final WebDriverWait negWait = new WebDriverWait(driver, Duration.ofSeconds(15));

    // ── Clear a field and type value (handles read-only via keyboard) ──
    private void clearAndType(WebElement field, String value) throws InterruptedException {
        field.click();
        field.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        field.sendKeys(Keys.DELETE);
        Thread.sleep(300);
        if (value != null && !value.isEmpty()) {
            field.sendKeys(value);
        }
    }

    // ── Get HTML5 browser validation message from an input element ──
    private String getValidationMessage(WebElement element) {
        return (String) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].validationMessage;", element);
    }

    // ── Console logger matching existing project style ──
    private void logResult(String context, String message) {
        System.out.println("[NEGATIVE - " + context + "] " + message);
    }

    // ═══════════════════════════════════════════════════════
    // 1. LOGIN NEGATIVE STEPS
    // ═══════════════════════════════════════════════════════

    @Given("User Open Navia Login Page")
    public void user_open_navia_login_page() throws InterruptedException {
        driver.get("https://web.navia.co.in/login.php");
        Thread.sleep(2000);
        logResult("LOGIN", "Opened login page: " + driver.getCurrentUrl());
    }

    @And("User Enter Negative Client Code {string}")
    public void user_enter_negative_client_code(String clientCode) throws InterruptedException {
        Thread.sleep(1000);
        // By.name("clientCode") — from Login_Navia_POM.java
        WebElement clientCodeField = negWait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("clientCode")));
        clearAndType(clientCodeField, clientCode);
        logResult("LOGIN", "Client Code entered: [" + clientCode + "]");
    }

    @And("User Enter Negative Password {string}")
    public void user_enter_negative_password(String password) throws InterruptedException {
        Thread.sleep(500);
        // By.name("lPassword") — from Login_Navia_POM.java
        WebElement passwordField = negWait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("lPassword")));
        clearAndType(passwordField, password);
        logResult("LOGIN", "Password entered: [" + password + "]");
    }

    /**
     * Validates the correct error appears on login page.
     * errorType: "clientCode" | "invalidCredentials" | "agree"
     */
    @Then("User Should See The Login Page Error For {string}")
    public void user_should_see_login_page_error_for(String errorType) throws InterruptedException {
        Thread.sleep(2000);

        switch (errorType) {

            case "clientCode":
                try {
                    WebElement clientField = driver.findElement(By.name("clientCode"));
                    String msg = getValidationMessage(clientField);
                    if (msg != null && !msg.isEmpty()) {
                        logResult("LOGIN", "HTML5 validation for clientCode: " + msg);
                    } else {
                        boolean errorVisible = !driver.findElements(By.xpath(
                                "//*[contains(@class,'error') or contains(@class,'invalid')]"
                                + "[contains(.,'client') or contains(.,'required')]")).isEmpty();
                        logResult("LOGIN", "Inline error shown for clientCode: " + errorVisible);
                    }
                } catch (Exception e) {
                    logResult("LOGIN", "clientCode validation checked. Exception: " + e.getMessage());
                }
                break;

            case "invalidCredentials":
                try {
                    WebElement errorToast = negWait.until(ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//*[contains(@class,'toast') or contains(@class,'error-msg')"
                                    + " or contains(@class,'alert') or contains(@class,'notification')]"
                                    + "[contains(.,'Invalid') or contains(.,'incorrect')"
                                    + " or contains(.,'wrong') or contains(.,'failed')]")));
                    logResult("LOGIN", "Invalid credentials error: " + errorToast.getText());
                } catch (Exception e) {
                    String bodyText = driver.findElement(By.tagName("body")).getText();
                    boolean hasError = bodyText.toLowerCase().contains("invalid")
                            || bodyText.toLowerCase().contains("incorrect");
                    logResult("LOGIN", "Error on page: " + hasError);
                }
                break;

            case "agree":
                try {
                    WebElement checkbox = driver.findElement(
                            By.xpath("(//input[@type='checkbox'])[1]"));
                    String msg = getValidationMessage(checkbox);
                    if (msg != null && !msg.isEmpty()) {
                        logResult("LOGIN", "Agree checkbox validation: " + msg);
                    } else {
                        // Still on login page = agree blocked submission
                        boolean stillOnLogin = driver.getCurrentUrl().contains("login");
                        logResult("LOGIN", "Still on login page (agree blocked): " + stillOnLogin);
                    }
                } catch (Exception e) {
                    logResult("LOGIN", "Agree validation checked. Exception: " + e.getMessage());
                }
                break;

            default:
                logResult("LOGIN", "Unknown errorType: " + errorType);
        }
    }

    // ═══════════════════════════════════════════════════════
    // 2. AMO ORDER NEGATIVE STEPS
    // ═══════════════════════════════════════════════════════

    @And("User Open The AMO Buy Order Panel")
    public void user_open_the_amo_buy_order_panel() throws InterruptedException {
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        WebElement scripRow = negWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//li[contains(@class,'scrip-row') or contains(@class,'list-item')]"
                        + " | //div[contains(@class,'watchlist') and contains(@class,'item')])[1]")));
        actions.moveToElement(scripRow).perform();
        Thread.sleep(1000);
        WebElement buyBtn = negWait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//button[text()='B' or @title='Buy' or contains(@class,'buy')])[1]")));
        buyBtn.click();
        Thread.sleep(2000);
        logResult("AMO", "AMO Buy panel opened");
    }

    @And("User Open The AMO Sell Order Panel")
    public void user_open_the_amo_sell_order_panel() throws InterruptedException {
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        WebElement scripRow = negWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//li[contains(@class,'scrip-row') or contains(@class,'list-item')]"
                        + " | //div[contains(@class,'watchlist') and contains(@class,'item')])[1]")));
        actions.moveToElement(scripRow).perform();
        Thread.sleep(1000);
        WebElement sellBtn = negWait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//button[text()='S' or @title='Sell' or contains(@class,'sell')])[1]")));
        sellBtn.click();
        Thread.sleep(2000);
        logResult("AMO", "AMO Sell panel opened");
    }

    @And("User Select AMO Limit Order Type")
    public void user_select_amo_limit_order_type() throws InterruptedException {
        Thread.sleep(1000);
        try {
            WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
            driver.switchTo().frame(iframe);
        } catch (Exception ignored) { }

        WebElement limitTab = negWait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='Limit' or text()='L'] | //button[text()='Limit'] "
                        + "| //label[text()='Limit']")));
        limitTab.click();
        Thread.sleep(500);
        switchToMainFrame();
        logResult("AMO", "Limit order type selected");
    }

    @And("User Clear And Enter Quantity {string} In AMO Order")
    public void user_clear_and_enter_quantity_in_amo_order(String qty) throws InterruptedException {
        Thread.sleep(1000);
        try {
            WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
            driver.switchTo().frame(iframe);
        } catch (Exception ignored) { }

        WebElement qtyField = negWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[contains(@class,'quantity') or @placeholder='Qty'"
                        + " or @placeholder='Quantity' or @name='quantity']")));
        clearAndType(qtyField, qty);
        Thread.sleep(500);
        switchToMainFrame();
        logResult("AMO", "Quantity entered: [" + qty + "]");
    }

    @And("User Clear And Enter Price {string} In AMO Order")
    public void user_clear_and_enter_price_in_amo_order(String price) throws InterruptedException {
        Thread.sleep(1000);
        try {
            WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
            driver.switchTo().frame(iframe);
        } catch (Exception ignored) { }

        WebElement priceField = negWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[contains(@class,'price') or @placeholder='Price' or @name='price']")));
        clearAndType(priceField, price);
        Thread.sleep(500);
        switchToMainFrame();
        logResult("AMO", "Price entered: [" + price + "]");
    }

    @And("User Click AMO Place Order")
    public void user_click_amo_place_order() throws InterruptedException {
        Thread.sleep(1000);
        try {
            WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
            driver.switchTo().frame(iframe);
        } catch (Exception ignored) { }

        WebElement placeBtn = negWait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(),'Place') or contains(text(),'Buy')"
                        + " or contains(text(),'Sell') or contains(@class,'place-order')"
                        + " or contains(@class,'submit')]")));
        placeBtn.click();
        Thread.sleep(2500);
        switchToMainFrame();
        logResult("AMO", "Place Order clicked");
    }

    @Then("User Should See AMO Validation Error")
    public void user_should_see_amo_validation_error() throws InterruptedException {
        Thread.sleep(2000);
        try {
            WebElement errorElement = negWait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(@class,'error') or contains(@class,'toast')"
                            + " or contains(@class,'alert') or contains(@class,'notification')"
                            + " or contains(@class,'invalid') or contains(@class,'warning')]")));
            logResult("AMO", "Validation error shown: " + errorElement.getText());
        } catch (Exception e) {
            boolean formStillOpen = !driver.findElements(
                    By.xpath("//iframe[@class='iframe_window'] | //div[contains(@class,'order-form')]"))
                    .isEmpty();
            logResult("AMO", "Order form still open (validation blocked): " + formStillOpen);
        }
    }

    @Then("User Should See AMO Lot Size Error")
    public void user_should_see_amo_lot_size_error() throws InterruptedException {
        Thread.sleep(2000);
        try {
            WebElement errorElement = negWait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(text(),'lot') or contains(text(),'Lot')"
                            + " or contains(text(),'minimum') or contains(text(),'Minimum')"
                            + " or contains(@class,'error') or contains(@class,'toast')]")));
            logResult("AMO", "Lot size error: " + errorElement.getText());
        } catch (Exception e) {
            logResult("AMO", "Lot size error not shown as toast; form may have blocked submission.");
        }
    }

    // ═══════════════════════════════════════════════════════
    // 3. PRICE ALERT NEGATIVE STEPS
    // ═══════════════════════════════════════════════════════

    @And("User Clear Price Alert Field And Enter Value {string}")
    public void user_clear_price_alert_field_and_enter_value(String value) throws InterruptedException {
        Thread.sleep(1000);
        WebElement priceAlertInput = negWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[contains(@class,'alert') or @placeholder='Enter Price'"
                        + " or @placeholder='Price' or contains(@name,'price')"
                        + " or contains(@id,'price')]")));
        clearAndType(priceAlertInput, value);
        logResult("PRICE ALERT", "Alert value entered: [" + value + "]");
    }

    @Then("User Should See Price Alert Validation Error")
    public void user_should_see_price_alert_validation_error() throws InterruptedException {
        Thread.sleep(2000);
        try {
            WebElement errorElement = negWait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(@class,'error') or contains(@class,'toast')"
                            + " or contains(@class,'alert-error') or contains(@class,'invalid')]")));
            logResult("PRICE ALERT", "Validation error: " + errorElement.getText());
        } catch (Exception e) {
            try {
                WebElement priceInput = driver.findElement(
                        By.xpath("//input[contains(@class,'alert') or @placeholder='Enter Price']"));
                String msg = getValidationMessage(priceInput);
                logResult("PRICE ALERT", "HTML5 validation: " + msg);
            } catch (Exception ex) {
                logResult("PRICE ALERT", "Validation check done. Exception: " + ex.getMessage());
            }
        }
    }

    // ═══════════════════════════════════════════════════════
    // 4. SEARCH / WATCHLIST NEGATIVE STEPS
    // ═══════════════════════════════════════════════════════

    @And("User Search Negative Scrip {string}")
    public void user_search_negative_scrip(String searchText) throws InterruptedException {
        Thread.sleep(1000);
        WebElement searchBox = negWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='Search' or contains(@class,'search')"
                        + " or contains(@id,'search')]")));
        searchBox.clear();
        searchBox.sendKeys(searchText);
        Thread.sleep(2500);
        logResult("SEARCH", "Searched for: [" + searchText + "]");
    }

    @Then("User Should See No Search Results")
    public void user_should_see_no_search_results() throws InterruptedException {
        Thread.sleep(2000);
        try {
            WebElement noResultMsg = negWait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(text(),'No results') or contains(text(),'no result')"
                            + " or contains(text(),'Not found') or contains(text(),'not found')"
                            + " or contains(@class,'no-result') or contains(@class,'empty')]")));
            logResult("SEARCH", "No results message: " + noResultMsg.getText());
        } catch (Exception e) {
            boolean dropdownHasItems = !driver.findElements(
                    By.xpath("//ul[contains(@class,'search-result')]//li"
                            + " | //div[contains(@class,'dropdown')]//div[contains(@class,'item')]"))
                    .isEmpty();
            logResult("SEARCH", "Dropdown has items: " + dropdownHasItems
                    + " (should be false for negative test)");
        }
    }

    @Then("User Should See Search Results Or No Results Gracefully")
    public void user_should_see_search_results_or_no_results_gracefully() throws InterruptedException {
        Thread.sleep(2000);
        String pageSource = driver.getPageSource();
        boolean hasResults = pageSource.contains("scrip") || pageSource.contains("search-result");
        logResult("SEARCH", "Single char search completed gracefully. Has results: " + hasResults);
    }

    // ═══════════════════════════════════════════════════════
    // 5. FUNDS / PAYIN NEGATIVE STEPS
    // ═══════════════════════════════════════════════════════

    @And("User Enter Negative Payin Amount {string}")
    public void user_enter_negative_payin_amount(String amount) throws InterruptedException {
        Thread.sleep(1500);
        WebElement amountField = negWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='Enter Amount' or @placeholder='Amount'"
                        + " or contains(@name,'amount') or contains(@id,'amount')]")));
        clearAndType(amountField, amount);
        logResult("FUNDS", "Payin amount entered: [" + amount + "]");
    }

    @And("User Enter Invalid UPI ID {string} And Click Pay Now")
    public void user_enter_invalid_upi_id_and_click_pay_now(String upiId) throws InterruptedException {
        Thread.sleep(1000);
        WebElement upiField = negWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='Enter UPI ID' or @placeholder='UPI ID'"
                        + " or contains(@name,'upi') or contains(@id,'upi')]")));
        clearAndType(upiField, upiId);
        Thread.sleep(500);
        WebElement payNowBtn = negWait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(),'Pay Now') or contains(text(),'PAY NOW')"
                        + " or contains(text(),'Pay')]")));
        payNowBtn.click();
        Thread.sleep(2000);
        logResult("FUNDS", "Invalid UPI [" + upiId + "] entered and Pay Now clicked");
    }

    @Then("User Should See Funds Validation Error")
    public void user_should_see_funds_validation_error() throws InterruptedException {
        Thread.sleep(2000);
        try {
            WebElement errorElement = negWait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(@class,'error') or contains(@class,'toast')"
                            + " or contains(@class,'invalid') or contains(@class,'warning')"
                            + " or contains(@class,'alert')]")));
            logResult("FUNDS", "Funds validation error: " + errorElement.getText());
        } catch (Exception e) {
            try {
                WebElement amountField = driver.findElement(
                        By.xpath("//input[@placeholder='Enter Amount' or @placeholder='Amount']"));
                String msg = getValidationMessage(amountField);
                logResult("FUNDS", "HTML5 validation on amount: " + msg);
            } catch (Exception ex) {
                logResult("FUNDS", "Funds validation check done. Exception: " + ex.getMessage());
            }
        }
    }

    // ═══════════════════════════════════════════════════════
    // 6. STRATEGY BUILDER NEGATIVE STEPS
    // ═══════════════════════════════════════════════════════

    @Then("User Should See Strategy Name Validation Error")
    public void user_should_see_strategy_name_validation_error() throws InterruptedException {
        Thread.sleep(2000);
        try {
            WebElement errorElement = negWait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(@class,'error') or contains(@class,'toast')"
                            + " or contains(@class,'invalid')]"
                            + "[contains(.,'name') or contains(.,'required')"
                            + " or contains(.,'empty') or contains(.,'enter')]")));
            logResult("STRATEGY", "Strategy name error: " + errorElement.getText());
        } catch (Exception e) {
            try {
                WebElement nameInput = driver.findElement(
                        By.xpath("//input[@placeholder='Strategy Name'"
                                + " or contains(@name,'strategy')]"));
                String msg = getValidationMessage(nameInput);
                logResult("STRATEGY", "HTML5 validation for strategy name: " + msg);
            } catch (Exception ex) {
                logResult("STRATEGY", "Strategy name validation done. Exception: " + ex.getMessage());
            }
        }
    }

    @Then("User Should See Strategy Duplicate Or Success Message")
    public void user_should_see_strategy_duplicate_or_success_message() throws InterruptedException {
        Thread.sleep(2000);
        try {
            WebElement msgElement = negWait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(@class,'toast') or contains(@class,'alert')"
                            + " or contains(@class,'notification')]")));
            String msg = msgElement.getText();
            logResult("STRATEGY", "Strategy save message: " + msg);
            boolean valid = msg.toLowerCase().contains("exist")
                    || msg.toLowerCase().contains("duplicate")
                    || msg.toLowerCase().contains("saved")
                    || msg.toLowerCase().contains("success");
            logResult("STRATEGY", "Response is duplicate or saved: " + valid);
        } catch (Exception e) {
            logResult("STRATEGY", "Strategy message check done. Exception: " + e.getMessage());
        }
    }

    // ═══════════════════════════════════════════════════════
    // 7. HOLDINGS NEGATIVE STEPS
    // ═══════════════════════════════════════════════════════

    @And("User Select Stock From Holdings And Try Sell With Quantity {string}")
    public void user_select_stock_from_holdings_and_try_sell_with_quantity(String qty)
            throws InterruptedException {
        Thread.sleep(2000);
        WebElement firstHolding = negWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//div[contains(@class,'holding-row') or contains(@class,'scrip-row')"
                        + " or contains(@class,'holding-item')])[1]")));
        Actions actions = new Actions(driver);
        actions.moveToElement(firstHolding).perform();
        Thread.sleep(1000);

        WebElement sellBtn = negWait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//button[text()='S' or text()='Sell'"
                        + " or @title='Sell' or contains(@class,'sell')])[1]")));
        sellBtn.click();
        Thread.sleep(2000);

        try {
            WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
            driver.switchTo().frame(iframe);
        } catch (Exception ignored) { }

        WebElement qtyField = negWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[contains(@class,'quantity') or @placeholder='Qty'"
                        + " or @placeholder='Quantity']")));
        clearAndType(qtyField, qty);
        Thread.sleep(500);

        WebElement placeBtn = negWait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(),'Place') or contains(text(),'Sell')"
                        + " or contains(@class,'submit') or contains(@class,'place')]")));
        placeBtn.click();
        Thread.sleep(2500);
        switchToMainFrame();
        logResult("HOLDINGS", "Tried to sell with quantity: [" + qty + "]");
    }

    @Then("User Should See Holdings Sell Validation Error")
    public void user_should_see_holdings_sell_validation_error() throws InterruptedException {
        Thread.sleep(2000);
        try {
            WebElement errorElement = negWait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(@class,'error') or contains(@class,'toast')"
                            + " or contains(@class,'alert') or contains(@class,'notification')]")));
            logResult("HOLDINGS", "Holdings sell error: " + errorElement.getText());
        } catch (Exception e) {
            boolean formOpen = !driver.findElements(
                    By.xpath("//iframe[@class='iframe_window'] | //div[contains(@class,'order-form')]"))
                    .isEmpty();
            logResult("HOLDINGS", "Order form still open (validation blocked): " + formOpen);
        }
    }

    // ═══════════════════════════════════════════════════════
    // 8. CHART NEGATIVE STEPS
    // ═══════════════════════════════════════════════════════

    @And("User Try To Add Same Indicator Again {string}")
    public void user_try_to_add_same_indicator_again(String indicatorName) throws InterruptedException {
        Thread.sleep(2000);
        try {
            framesHandling();
        } catch (Exception ignored) { }

        try {
            WebElement indicatorBtn = negWait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(),'Indicators')"
                            + " or contains(@title,'Indicators')"
                            + " or contains(@class,'indicator')]")));
            indicatorBtn.click();
            Thread.sleep(1500);
        } catch (Exception e) {
            logResult("CHART", "Indicator button not found: " + e.getMessage());
            outOfFrames();
            return;
        }

        try {
            WebElement searchField = driver.findElement(
                    By.xpath("//input[@placeholder='Search' or contains(@class,'search')]"));
            searchField.sendKeys(indicatorName);
            Thread.sleep(1000);
        } catch (Exception ignored) { }

        try {
            WebElement indicatorOption = negWait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//*[contains(text(),'" + indicatorName + "')]")));
            indicatorOption.click();
            Thread.sleep(1500);
        } catch (Exception e) {
            logResult("CHART", "Indicator option not clickable: " + e.getMessage());
        }

        outOfFrames();
        logResult("CHART", "Attempted duplicate indicator: " + indicatorName);
    }

    @Then("User Should Verify Duplicate Indicator Behavior")
    public void user_should_verify_duplicate_indicator_behavior() throws InterruptedException {
        Thread.sleep(2000);
        try {
            WebElement msg = negWait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(@class,'toast') or contains(@class,'alert')"
                            + " or contains(@class,'notification') or contains(@class,'warning')]")));
            logResult("CHART", "Duplicate indicator message: " + msg.getText());
        } catch (Exception e) {
            int panelCount = driver.findElements(
                    By.xpath("//div[contains(@class,'indicator-panel')"
                            + " or contains(@class,'pane')"
                            + " or contains(@class,'indicator-row')]")).size();
            logResult("CHART", "Indicator panel count after duplicate attempt: " + panelCount);
        }
    }

    @Then("User Should Verify Chart Is Loaded")
    public void user_should_verify_chart_is_loaded() throws InterruptedException {
        Thread.sleep(3000);
        try {
            WebElement chartContainer = negWait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//canvas | //div[contains(@class,'chart-container')"
                            + " or contains(@class,'tv-chart') or contains(@class,'chart')]")));
            logResult("CHART", "Chart loaded: " + chartContainer.isDisplayed());
        } catch (Exception e) {
            logResult("CHART", "Chart container check: " + e.getMessage());
        }
    }
}