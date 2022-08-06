package TestVagrant;

import java.io.IOException;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.ImdbActionPage;
import pageObjects.WikiActionPage;
import resources.base;

public class ValidationPage extends base {

	String release, country, re, con;

	@BeforeTest
	public void intialize() throws IOException, InterruptedException {
		driver = initializeDriver();
	}

	@Test
	public void extractReleaseDateAndCountryName() throws IOException, InterruptedException {

		driver.get(prop.getProperty("wikiUrl"));
		WikiActionPage sa = new WikiActionPage(driver);
		sa.enterMovieNameClickEnter();
		sa.scrollDownfWikiPage();
		release = sa.releaseDateListWiki();
		// System.out.println("Movie Release date from Wiki page:: " + release);
		country = sa.countryNameListWiki();
		// System.out.println("Country name from Wiki page:: " + country);

		Thread.sleep(5000);

		driver.switchTo().newWindow(WindowType.TAB);// open new blank tab in same window
		driver.get(prop.getProperty("imdbUrl"));

		ImdbActionPage ia = new ImdbActionPage(driver);
		ia.enterMovieNameClickEnter();
		ia.scrollDownfImdbPage();
		re = ia.releaseDateListImdb();
		// System.out.println("Movie Release date from imdb page:: " + re);
		con = ia.countryNameListImdb();
		// System.out.println("Country name from imdb page:: " + con);

	}

	@Test
	public void verifyReleaseAndCountryFromWikiAndImdbPage() {
		Assert.assertEquals(country, con);// comparing country name from both sources.
		System.out.println("The country name matching on both the sources.");

		System.out.println("The Release date are not matching on both the sources.");
		// if release date not matching that means script failing from here
		Assert.assertEquals(release, re);// comparing releaseDate from both sources.

	}

	@AfterTest
	public void closedriver() {
		driver.quit();
	}

}
