package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.*;

public class WikiActionPage {
	public WebDriver driver;

	By searchOnWiki = By.xpath("//*[@type='search']");
	By searchBtn = By.xpath("//input[@id='searchButton']");
	By tableDataList = By.cssSelector(".infobox.vevent td.infobox-data");

	public WikiActionPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterMovieNameClickEnter() {
		driver.findElement(searchOnWiki).sendKeys("Pushpa: The Rise");
		driver.findElement(searchBtn).submit();

	}

	public void scrollDownfWikiPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}

	public String releaseDateListWiki() {
		String release = null;
		List<WebElement> date = driver.findElements(tableDataList);
		for (int i = 0; i < date.size(); i++) {
			release = date.get(9).getText();
		}
		// System.out.println(release);
		return release;
	}

	public String countryNameListWiki() {
		String name = null;
		List<WebElement> country = driver.findElements(tableDataList);
		for (int i = 0; i < country.size(); i++) {
			name = country.get(11).getText();
		}
		// System.out.println(name);
		return name;
	}

	/*
	 * public List<WebElement> tableDataListWipi() { List<WebElement>
	 * td=driver.findElements(tableDataList); for(int i=0;i<td.size();i++) {
	 * System.out.println(td.get(i).getText()); } return td; }
	 */

}
