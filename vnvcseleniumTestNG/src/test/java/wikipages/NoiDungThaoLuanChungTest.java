package wikipages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NoiDungThaoLuanChungTest {
	public String baseUrl = "https://vi.wikipedia.org/wiki/Trang_Ch%C3%ADnh";
	public WebDriver driver ; 
	
	@BeforeTest
	 public void launchBrowser() {
        System.out.println("launching firefox browser"); 
		String project_path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", project_path + "/src/test/resources/drivers/chromedriver.exe"); 
		driver = new ChromeDriver();
		driver.get(baseUrl);
    }
	
	@Test
	public void kiemTraNoiDungTrangThaoLuanChung() {
		//driver.findElement(By.cssSelector("#vector-main-menu-dropdown-checkbox")).click();
		driver.findElement(By.id("vector-main-menu-dropdown-checkbox")).click();
		driver.findElement(By.cssSelector("li[id='n-wikipedia-villagepump'] a span")).click();
		String expectedTitle = "Wikipedia:Thảo luận – Wikipedia tiếng Việt";
		String actualTitle = driver.getTitle();
		System.out.printf("Title %s", actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test
	public void kiemTraChuyenNgonNgu() {
		driver.findElement(By.id("vector-main-menu-dropdown-checkbox")).click();
		driver.findElement(By.cssSelector("#n-wikipedia-villagepump span")).click();
		driver.findElement(By.id("p-lang-btn-checkbox")).isDisplayed();
	}
	
	@Test
	public void kiemTraXemLichSu() {
		driver.findElement(By.id("vector-main-menu-dropdown-checkbox")).click();
		driver.findElement(By.cssSelector("#n-wikipedia-villagepump span")).click();
		driver.findElement(By.id("p-lang-btn-checkbox")).click();
		driver.findElement(By.cssSelector("a[title='Các phiên bản cũ của trang này [alt-shift-h]'] span")).click();
		//driver.findElement(By.id("content")).isDisplayed();
		driver.findElement(By.xpath("//div[@id='mw-content-text']")).isDisplayed();
	}
	
    @AfterTest
    public void terminateBrowser(){
        driver.close();
    }
}
