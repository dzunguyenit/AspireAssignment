package common;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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

	public BaseElement(WebDriver driver) {
		this.driver = driver;
	}

	private int timeouts = 20;
	String jsColorBorderElement = "arguments[0].style='border: 2px solid; border-color: red'";

	// Web Browser
	public void openUrl(String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public String getPageSource() {
		return driver.getPageSource();
	}

	public void backPage() {
		driver.navigate().back();
	}

	public void forwardPage() {
		driver.navigate().forward();
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	public void waitForIEBrowser(int Timeouts) {
		try {
			Thread.sleep(Timeouts);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Web Element
	public void click(WebElement element) {
		((JavascriptExecutor) driver).executeScript(jsColorBorderElement, element);
		element.click();
	}

	public void click(String locator, String value) {
		String dynamicLocator = String.format(locator, value);
		WebElement element = driver.findElement(By.xpath(dynamicLocator));
		element.click();
	}

	public void click(String locator, String value1, String value2) {
		String dynamicLocator = String.format(locator, value1, value2);
		WebElement element = driver.findElement(By.xpath(dynamicLocator));
		element.click();
	}

	public String getTextDynamic(String value) {
		String dynamicLocator = String.format("//*[text()='%s']", value);
		WebElement element = driver.findElement(By.xpath(dynamicLocator));
		return element.getText();
	}

	// Clear and sendkey
	public void input(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	public void onlyInput(WebElement element, String value) {
		element.sendKeys(value);
	}

	public void selectCombobox(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	public void selectComboboxSpecial(String locatorDropdown, String locator, String value) {
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

	public String getFirstSelectedOption(String locator) {
		Select element = new Select(driver.findElement(By.xpath(locator)));
		return element.getFirstSelectedOption().getText();
	}

	public String getAtribute(String locator, String attribute) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attribute);
	}

	public String getText(WebElement element) {
		waitVisible(element);
		return element.getText();
	}

	public int getSize(String locator) {
		List<WebElement> element = driver.findElements(By.xpath(locator));
		return element.size();
	}

	public void uncheckCheckbox(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		if (element.isSelected())
			element.click();
	}

	public boolean isDisplayed(String locator, String value) {
		String dynamicLocator = String.format(locator, value);
		WebElement element = driver.findElement(By.xpath(dynamicLocator));
		return element.isDisplayed();
	}

	public boolean isDisplayed(String locator, String value1, String value2) {
		String dynamicLocator = String.format(locator, value1, value2);
		WebElement element = driver.findElement(By.xpath(dynamicLocator));
		return element.isDisplayed();
	}

	public boolean isDisplayed(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	public boolean isSelected(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isSelected();
	}

	public boolean isEnabled(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}
	// Alert

	public void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void dismissAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public String getTextAlert() {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}

	public void inputAlert(String value) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);
	}

	// Windows
	public void switchWindowByID(String parent) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String childWindows : allWindows) {
			if (!childWindows.equals(parent)) {
				driver.switchTo().window(childWindows);
				break;
			}
		}
	}

	public void switchWindowByTitle(String title) {
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
	public boolean closeAllWindowsWithoutParent(String parent) {
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

	public String getWindowParentID() {
		return driver.getWindowHandle();
	}

	// Iframe
	public void switchIframe(String locator) {
		WebElement iframe = driver.findElement(By.xpath(locator));
		driver.switchTo().frame(iframe);
	}

	public void switchDefaultContent() {
		driver.switchTo().defaultContent();
	}

	// Actions
	public void doubleClick(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	public void hover(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void hover(String locator, String value1, String value2) {
		String dynamicLocator = String.format(locator, value1, value2);
		WebElement element = driver.findElement(By.xpath(dynamicLocator));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void rightClick(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	public void dragAndDrop(String locatorFrom, String locatorTarget) {
		WebElement dragFrom = driver.findElement(By.xpath(locatorFrom));
		WebElement target = driver.findElement(By.xpath(locatorTarget));
		Actions builder = new Actions(driver);
		Action dragAndDropAction = builder.clickAndHold(dragFrom).moveToElement(target).release(target).build();
		dragAndDropAction.perform();
	}

	// Bonus
	public void clickAndHold(int itemFrom, int itemTarget, String locator) {
		List<WebElement> listItems = driver.findElements(By.xpath(locator));
		Actions action = new Actions(driver);
		action.clickAndHold(listItems.get(itemFrom)).clickAndHold(listItems.get(itemTarget)).click().perform();
		action.release();
	}

	// Key Press
	public void keyDownElement(WebElement element, Keys pressKeyDown) {
		Actions action = new Actions(driver);
		action.keyDown(element, pressKeyDown);
	}

	public void keyUpElement(WebElement element, Keys pressKeyUp) {
		Actions action = new Actions(driver);
		action.keyUp(element, pressKeyUp);
	}

	public void onlyInputKeys(WebElement element, Keys key) {
		element.sendKeys(key);
	}

	public void inputKeys(WebElement element, Keys key) {
		element.clear();
		element.sendKeys(key);
	}

	// Upload
	public void uploadFile(String locator, String firePath) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.sendKeys(firePath);
	}

	// Javascript
	public Object executeJavascriptToBrowser(String javaSript) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript(javaSript);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public Object executeJavascriptToElement(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public Object executeJavascriptToElement(String locator, String value1, String value2) {
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

	public Object scrollToBottomPage() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public Object scrollToElement(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	// Wait
	public void waitPresence(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeouts);
		By by = By.xpath(locator);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public void waitVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, timeouts);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitVisibleDynamic(String value) {
		WebDriverWait wait = new WebDriverWait(driver, timeouts);
		String dynamicLocator = String.format("//*[text()='%s']", value);
		WebElement element = driver.findElement(By.xpath(dynamicLocator));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitIframeVisible(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeouts);
		By by = By.xpath(locator);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
	}
//
//	public void waitVisible(String locator, String value) {
//		String dynamicLocator = String.format(locator, value);
//		WebDriverWait wait = new WebDriverWait(driver, timeouts);
//		By by = By.xpath(dynamicLocator);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
//	}

//	public void waitVisible(String locator, String value1, String value2) {
//		String dynamicLocator = String.format(locator, value1, value2);
//		WebDriverWait wait = new WebDriverWait(driver, timeouts);
//		By by = By.xpath(dynamicLocator);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
//	}

	public void waitClickable(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeouts);
		By by = By.xpath(locator);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	public void waitInvisible(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeouts);
		By by = By.xpath(locator);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	public void waitAlertPresence() {
		WebDriverWait wait = new WebDriverWait(driver, timeouts);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public boolean sortElementAcsending(String locator) {

		List<WebElement> list = driver.findElements(By.xpath(locator));
		int length = list.size();
		for (int i = 0; i < length; i++) {
			if (Integer.parseInt(list.get(i).getText()) <= Integer.parseInt(list.get(i + 1).getText())) {
				return true;
			}
		}
		return false;
	}

	public boolean sortElementDescending(String locator) {

		List<WebElement> list = driver.findElements(By.xpath(locator));
		int length = list.size();
		for (int i = 0; i < length; i++) {
			if (Integer.parseInt(list.get(i).getText()) >= Integer.parseInt(list.get(i + 1).getText())) {
				return true;
			}
		}
		return false;
	}

	public void swapElement(String locator) {

		List<WebElement> list = driver.findElements(By.xpath(locator));
		int temp;
		int position1 = Integer.parseInt(list.get(0).getText());
		int position2 = Integer.parseInt(list.get(1).getText());
		temp = position1;
		position1 = position2;
		position2 = temp;

	}

}
