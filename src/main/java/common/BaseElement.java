package common;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseElement {

    protected WebDriver driver;

    protected BaseElement(WebDriver driver) {
        this.driver = driver;
    }

    private int timeouts = 10;



    // Web Browser
    protected void openUrl(String url) {
        driver.get(url);
    }

    protected String getTitle() {
        return driver.getTitle();
    }

    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    protected String getPageSource() {
        return driver.getPageSource();
    }

    protected void backPage() {
        driver.navigate().back();
    }

    protected void forwardPage() {
        driver.navigate().forward();
    }

    protected void refreshPage() {
        driver.navigate().refresh();
    }

    protected void waitForIEBrowser(int Timeouts) {
        try {
            Thread.sleep(Timeouts);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Web Element
    protected void click(WebElement element) {
        element.click();
    }

    protected void click(String locator, String value) {
        String dynamicLocator = String.format(locator, value);
        WebElement element = driver.findElement(By.xpath(dynamicLocator));
        element.click();
    }

    protected void click(String locator, String value1, String value2) {
        String dynamicLocator = String.format(locator, value1, value2);
        WebElement element = driver.findElement(By.xpath(dynamicLocator));
        element.click();
    }

    protected String getTextDynamic(String value) {
        String dynamicLocator = String.format("//*[text()='%s']", value);
        WebElement element = driver.findElement(By.xpath(dynamicLocator));
        return element.getText();
    }

    // Clear and sendkey
    protected void input(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    protected void inputKeyBoard(WebElement element, Keys key) {
        element.sendKeys(key);
    }

    protected void onlyInput(WebElement element, String value) {
        element.sendKeys(value);
    }

    protected void selectCombobox(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    protected void selectComboboxSpecial(String locatorDropdown, String locator, String value) {
        WebElement dropdown = driver.findElement(By.xpath(locatorDropdown));
        dropdown.click();
        List<WebElement> list = driver.findElements(By.xpath(locator));
        for (WebElement element : list) {
            if (element.getText().equalsIgnoreCase(value)) {
                element.click();
                break;
            }
        }

    }

    protected String getFirstSelectedOption(String locator) {
        Select element = new Select(driver.findElement(By.xpath(locator)));
        return element.getFirstSelectedOption().getText();
    }

    protected String getAtribute(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

    protected String getText(WebElement element) {
        waitVisible(element);
        return element.getText();
    }

    protected int getSize(String locator) {
        List<WebElement> element = driver.findElements(By.xpath(locator));
        return element.size();
    }

    protected void uncheckCheckbox(String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        if (element.isSelected())
            element.click();
    }

    protected boolean isDisplayed(String locator, String value) {
        String dynamicLocator = String.format(locator, value);
        WebElement element = driver.findElement(By.xpath(dynamicLocator));
        return element.isDisplayed();
    }

    protected boolean isDisplayed(String locator, String value1, String value2) {
        String dynamicLocator = String.format(locator, value1, value2);
        WebElement element = driver.findElement(By.xpath(dynamicLocator));
        return element.isDisplayed();
    }

    protected boolean isDisplayed(String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        return element.isDisplayed();
    }

    protected boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    protected boolean isSelected(String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        return element.isSelected();
    }

    protected boolean isEnabled(String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        return element.isEnabled();
    }
    // Alert

    protected void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    protected void dismissAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    protected String getTextAlert() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    protected void inputAlert(String value) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(value);
    }

    // Windows
    protected void switchWindowByID(String parent) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String childWindows : allWindows) {
            if (!childWindows.equals(parent)) {
                driver.switchTo().window(childWindows);
                break;
            }
        }
    }

    protected void switchWindowByTitle(String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String childWindows : allWindows) {
            driver.switchTo().window(childWindows);
            String childTitle = driver.getTitle();
            if (childTitle.equals(title)) {
                break;
            }
        }
    }

    // Bonus
    protected boolean closeAllWindowsWithoutParent(String parent) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String childWindows : allWindows) {
            if (!childWindows.equals(parent)) {
                driver.switchTo().window(childWindows);
                driver.close();
            }
        }
        driver.switchTo().window(parent);

        if (driver.getWindowHandles().size() == 1)
            return true;
        else
            return false;
    }

    protected String getWindowParentID() {
        return driver.getWindowHandle();
    }

    // Iframe
    protected void switchIframe(String locator) {
        WebElement iframe = driver.findElement(By.xpath(locator));
        driver.switchTo().frame(iframe);
    }

    protected void switchDefaultContent() {
        driver.switchTo().defaultContent();
    }

    // Actions
    protected void doubleClick(String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        Actions action = new Actions(driver);
        action.doubleClick(element).perform();
    }

    protected void hover(String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    protected void hover(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    protected void hover(String locator, String value1, String value2) {
        String dynamicLocator = String.format(locator, value1, value2);
        WebElement element = driver.findElement(By.xpath(dynamicLocator));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    protected void rightClick(String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        Actions action = new Actions(driver);
        action.contextClick(element).perform();
    }

    protected void dragAndDrop(String locatorFrom, String locatorTarget) {
        WebElement dragFrom = driver.findElement(By.xpath(locatorFrom));
        WebElement target = driver.findElement(By.xpath(locatorTarget));
        Actions builder = new Actions(driver);
        Action dragAndDropAction = builder.clickAndHold(dragFrom).moveToElement(target).release(target).build();
        dragAndDropAction.perform();
    }

    // Bonus
    protected void clickAndHold(int itemFrom, int itemTarget, String locator) {
        List<WebElement> listItems = driver.findElements(By.xpath(locator));
        Actions action = new Actions(driver);
        action.clickAndHold(listItems.get(itemFrom)).clickAndHold(listItems.get(itemTarget)).click().perform();
        action.release();
    }

    // Key Press
    protected void keyDownElement(WebElement element, Keys pressKeyDown) {
        Actions action = new Actions(driver);
        action.keyDown(element, pressKeyDown);
    }

    protected void keyUpElement(WebElement element, Keys pressKeyUp) {
        Actions action = new Actions(driver);
        action.keyUp(element, pressKeyUp);
    }

    protected void onlyInputKeys(WebElement element, Keys key) {
        element.sendKeys(key);
    }

    protected void inputKeys(WebElement element, Keys key) {
        element.clear();
        element.sendKeys(key);
    }

    // Upload
    protected void uploadFile(String locator, String firePath) {
        WebElement element = driver.findElement(By.xpath(locator));
        element.sendKeys(firePath);
    }

    // Javascript
    protected String executeJavascriptToBrowser(String javaSript) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            return (String) js.executeScript(javaSript);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    protected Object executeJavascriptToElement(String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            return js.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    protected Object executeJavascriptToElement(String locator, String value1, String value2) {
        String dynamicLocator = String.format(locator, value1, value2);
        WebElement element = driver.findElement(By.xpath(dynamicLocator));
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            return js.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    protected Object scrollToBottomPage() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            return js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    protected Object scrollToElement(String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            return js.executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    protected void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
        }
    }

    // Wait
    protected void waitPresence(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeouts);
        By by = By.xpath(locator);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected void waitVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeouts);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitVisible(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeouts);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    protected void waitAtributeContains(WebElement element, String attribute, String value) {
        WebDriverWait wait = new WebDriverWait(driver, timeouts);
        wait.until(ExpectedConditions.attributeContains(element, attribute, value));
    }

    protected void waitVisibleDynamic(String value) {
        WebDriverWait wait = new WebDriverWait(driver, timeouts);
        String dynamicLocator = String.format("//*[text()='%s']", value);
        WebElement element = driver.findElement(By.xpath(dynamicLocator));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitIframeVisible(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeouts);
        By by = By.xpath(locator);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
    }
//
//	protected void waitVisible(String locator, String value) {
//		String dynamicLocator = String.format(locator, value);
//		WebDriverWait wait = new WebDriverWait(driver, timeouts);
//		By by = By.xpath(dynamicLocator);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
//	}

//	protected void waitVisible(String locator, String value1, String value2) {
//		String dynamicLocator = String.format(locator, value1, value2);
//		WebDriverWait wait = new WebDriverWait(driver, timeouts);
//		By by = By.xpath(dynamicLocator);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
//	}

    protected void waitClickable(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeouts);
        By by = By.xpath(locator);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    protected void waitInvisible(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeouts);
        By by = By.xpath(locator);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    protected void waitAlertPresence() {
        WebDriverWait wait = new WebDriverWait(driver, timeouts);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    protected boolean sortElementAcsending(String locator) {

        List<WebElement> list = driver.findElements(By.xpath(locator));
        int length = list.size();
        for (int i = 0; i < length; i++) {
            if (Integer.parseInt(list.get(i).getText()) <= Integer.parseInt(list.get(i + 1).getText())) {
                return true;
            }
        }
        return false;
    }

    protected boolean sortElementDescending(String locator) {

        List<WebElement> list = driver.findElements(By.xpath(locator));
        int length = list.size();
        for (int i = 0; i < length; i++) {
            if (Integer.parseInt(list.get(i).getText()) >= Integer.parseInt(list.get(i + 1).getText())) {
                return true;
            }
        }
        return false;
    }

    protected void swapElement(String locator) {

        List<WebElement> list = driver.findElements(By.xpath(locator));
        int temp;
        int position1 = Integer.parseInt(list.get(0).getText());
        int position2 = Integer.parseInt(list.get(1).getText());
        temp = position1;
        position1 = position2;
        position2 = temp;

    }

}
