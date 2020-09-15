package eleven.main;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Scrolling {
	
	private AndroidDriver<MobileElement> driver;
	
	//���߿� vo�ڵ�� ���� ���. scrolling������ ���Ÿ� ���� driver ���ٸ� �־ ��
	public AndroidDriver<MobileElement> getDriver() {
		return driver;
	}
	
	public void setDriver(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	public void scrollDown() {

		Dimension dimension = getDriver().manage().window().getSize();

		Double scrollHeightStart = dimension.getHeight()*0.5;
		int scrollStart = scrollHeightStart.intValue();
		
		Double scrollHeightEnd = dimension.getHeight()*0.2;
		int scrollEnd = scrollHeightEnd.intValue();
		
		new TouchAction((PerformsTouchActions) getDriver())
		.press(PointOption.point(0, scrollStart))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(0, scrollEnd))
		.release().perform();
		
	}

	public WebElement getElement(String xpath) {
		return getDriver().findElement(By.xpath(xpath));
	}
	
	
//	public void scrollTillElement(String xpath) throws InterruptedException {
//		getElement(xpath).click();
		
//		while (getElement(xpath).size()==0) {
						
//		}
				
//	}

}
