package eleven.main;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;

public class shop_elevenst {
	
	//���� ������ ���� ����
	public static URL url;
	public static DesiredCapabilities dc;
	public static AndroidDriver<MobileElement> driver;
	
	public static ArrayList<userInfo> list = new ArrayList<userInfo>(); // userInfo ���� ����Ʈ�� ����ϱ����� ����
	public static Scrolling scrolling = new Scrolling();
	

	@BeforeTest
	public void setupAppium() throws MalformedURLException {
		Userexcel info = new Userexcel();
		list = info.excelUserinfo();

		final String URL_STRING = "http://127.0.0.1:30300/wd/hub";
		url = new URL(URL_STRING);

		dc = new DesiredCapabilities();

		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy Note8");

		dc.setCapability("appPackage", "com.elevenst");
		dc.setCapability("appActivity", "com.elevenst.intro.Intro");

		// app ���� �� ������ �ʱ�ȭ ���� ��ũ��Ʈ
		dc.setCapability("noReset", true);
		dc.setCapability("fullReset", false);

		driver = new AndroidDriver<MobileElement>(url, dc);

	}

	/*
	 * @AfterTest public void closeApp () throws InterruptedException {
	 * driver.closeApp (); }
	 */
	public void findElement(String elementID) throws InterruptedException {

		String[] array = elementID.split("/"); // elementID �ּҸ� / �������� �߶� ���

		try {
			driver.findElementById(elementID);
			System.out.println(array[array.length - 1] + " Ȯ��");

		} catch (Exception e) {
			System.out.println(array[array.length - 1] + " ��ã��");
		}

		Thread.sleep(2000);

	}

	public void xPathClick(String elementID) throws InterruptedException {

		String[] array = elementID.split("/"); // elementID �ּҸ� / �������� �߶� ���

		try {
			driver.findElementById(elementID).click();
			System.out.println(array[array.length - 1] + " Ŭ��");

		} catch (Exception e) {
			System.out.println(array[array.length - 1] + " Ŭ�� ����");
		}

		Thread.sleep(2000);
	}
	
	@Test
	public void TC013 () throws InterruptedException {
		
		//�����ִ� ��� �� �ݱ�
		((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
		Thread.sleep(2000);

		String clearapp8 = "com.android.systemui:id/recents_close_all_button"; //�ȵ�8
		xPathClick(clearapp8);
		
		String clearapp9 = "com.sec.android.app.launcher:id/clear_all_button"; //�ȵ�9
		xPathClick(clearapp9);
		
		//11���� �� ���� �� 
		driver.launchApp();
		
		Thread.sleep(5000);
		
		String elevenLogo = "com.elevenst:id/gnb_logo";
		findElement(elevenLogo);
		
		Thread.sleep(3000);
		
	}
	
	//TC014 11���� ���� ȭ��, �˾��� ��� �ϴ� �ǳ� ��
	
	@Test //11���� �α��� Ȯ��
	public void TC015 () throws InterruptedException {
		
		//11���� ���� ȭ������ �̵�
		String myEleven = "com.elevenst:id/btn_my";
		xPathClick(myEleven);
		
		Thread.sleep(3000);
		
		// ���������� [ȸ������] ��ư ã�� else if �α��� ���μ��� ����
		try {
			driver.findElement(By.xpath("//android.view.View[@text='���� 11����']"));
			
		} catch (Exception e) {

			//appium send text�� ���θ� id �Է�
			MobileElement inputID = (MobileElement) driver.findElement(By.xpath("//android.widget.EditText[@resource-id='userId']"));
			inputID.click();
			inputID.sendKeys("inmanaged"); //userinfo ���� �� �־�� ��
			
			Thread.sleep(1000);
			
			//appium send text�� ���θ� pw �Է�
			MobileElement inputPW = (MobileElement) driver.findElement(By.xpath("//android.widget.EditText[@resource-id='userPw']"));
			inputPW.click();
			inputPW.sendKeys("qmdlvl1!"); //userinfo ���� �� �־�� ��
			
			Thread.sleep(1000);
			
			//�α��� ��ư Ŭ��
			driver.findElement(By.xpath("//android.widget.Button[@text='�α���']")).click();
			
			Thread.sleep(5000);
			
		} finally {
			driver.findElement(By.xpath("//android.view.View[@text='���� 11����']"));
			System.out.println("�α��� Ȯ��");
			
		}
		
		Thread.sleep(3000);
			
	}
	
	@Test //�˻�â ���� �˻��� �Է��Ͽ� �˻�
	public void TC016 () throws InterruptedException {
		
		//���� ȭ������ �ͼ� �˻��� ��ư(resourceid ���ߵ�) �����ؾ��� �������������� �˻��� ��ư Ŭ���ص� �˻�â �ȿ���
		
		String iconSearch = "com.elevenst:id/gnb_text_search";
		xPathClick(iconSearch);
		
		Thread.sleep(1000);
		
		
	}

	
	

}
