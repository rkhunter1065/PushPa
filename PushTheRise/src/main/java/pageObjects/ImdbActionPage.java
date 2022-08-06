package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ImdbActionPage {

	public WebDriver driver;

	By searchOnImdb = By.xpath("//input[@id='suggestion-search']");
	By searchBtnOnImdb = By.xpath("//button[@id='suggestion-search-button']//*[name()='svg']");
	By movieTextLink = By.xpath("//a[normalize-space()='Pushpa: The Rise - Part 1']");
	// By
	// movieTitle=By.xpath("//body/div[@id='content']/h1[@id='firstHeading']/i[1]");
	By dataListImdb = By.cssSelector(
			"section.ipc-page-section.ipc-page-section--base.celwidget[data-testid='Details'] li.ipc-inline-list__item");

	public ImdbActionPage(WebDriver driver) {
		this.driver = driver;
	}

	public void scrollDownfImdbPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,5500)", "");
	}

	public void enterMovieNameClickEnter() {
		driver.findElement(searchOnImdb).sendKeys("Pushpa: The Rise");
		driver.findElement(searchBtnOnImdb).submit();
		driver.findElement(movieTextLink).click();

	}

	public String releaseDateListImdb() {
		String release = null;
		List<WebElement> date = driver.findElements(dataListImdb);
		for (int i = 0; i < date.size(); i++) {
			release = date.get(0).getText();
		}
		// System.out.println(release);
		return release;
	}

	public String countryNameListImdb() {
		String name = null;
		List<WebElement> country = driver.findElements(dataListImdb);
		for (int i = 0; i < country.size(); i++) {
			name = country.get(1).getText();
		}
		// System.out.println(name);
		return name;
	}

}
