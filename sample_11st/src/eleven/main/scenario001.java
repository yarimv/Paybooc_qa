package eleven.main;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;


public class scenario001 {
	
	public static URL url;
	public static DesiredCapabilities dc;
	public static AndroidDriver<MobileElement> driver;
	
	// �ð� ���
	public static SimpleDateFormat format2 = new SimpleDateFormat ( "MM/dd HH:mm:ss");
	public static Date time = new Date();
	public static String time2 = format2.format(time);
	
	
	@BeforeTest
	public void setupAppium () throws MalformedURLException {
	
		final String URL_STRING = "http://127.0.0.1:30300/wd/hub";
		url = new URL(URL_STRING);
		
		dc= new DesiredCapabilities();
		
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy S8");
		
		dc.setCapability("appPackage", "kvp.jjy.MispAndroid320");
		dc.setCapability("appActivity", "kvp.jjy.MispAndroid320.newui.icon.WinterIcon");

		//app ���� �� ������ �ʱ�ȭ ���� ��ũ��Ʈ
		dc.setCapability("noReset", true);
		dc.setCapability("fullReset", false);
									
		driver=new AndroidDriver<MobileElement>(url,dc);

	}
		
/*	
	@AfterTest
	public void closeApp () throws InterruptedException {
		driver.closeApp ();
	}
*/
	public void findElement(String elementID) throws InterruptedException {
		
		String[] array = elementID.split("/"); //elementID �ּҸ� / �������� �߶� ���
		
		try {
			driver.findElementById(elementID);
			System.out.println(array[array.length-1]+" Ȯ��");
			
		} catch (Exception e) {
			System.out.println(array[array.length-1]+" ��ã��");
		} 
		
		Thread.sleep(2000);
		
	}
	
	
	public void xPathClick(String elementID) throws InterruptedException {
		
		String[] array = elementID.split("/"); //elementID �ּҸ� / �������� �߶� ���

		try {
			driver.findElementById(elementID).click();
			System.out.println(array[array.length-1]+" Ŭ��");
			
		} catch (Exception e) {
			System.out.println(array[array.length-1]+" Ŭ�� ����");
		}
		
		Thread.sleep(2000);
	}

	
	@Test //�׽�Ʈ ���� �ð� log
	public void TC000 () {
		System.out.println("�׽�Ʈ �ó�����1 ����: "+time2);
	}
	
	
	@Test //��⿡ �����ִ� ��� APP �ݱ�
	public void TC001 () throws InterruptedException {
		
		((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
		Thread.sleep(2000);
		
		String elementID = "com.android.systemui:id/recents_close_all_button";
		xPathClick(elementID);
				
	}
	
	
	@Test //���̺� APP ���� �� Ȯ��
	public void TC002 () throws Exception {
		
		driver.launchApp();
		String elementID = "kvp.jjy.MispAndroid320:id/iv_title_menu";
		findElement(elementID);

		System.out.println("���̺� app ����");
		
	}
	
	@Test //ī���߰� ��ư ����
	public void TC003 () throws InterruptedException {
		
		String elementID = "kvp.jjy.MispAndroid320:id/iv_card_add";
		xPathClick(elementID);
		
	}
	
	@Test //ī������ �Է� ȭ�� ���� Ȯ�� �� ī�� ��ȣ 16�ڸ� �Է�
	public void TC004 () throws InterruptedException {
		
		String elementID = "kvp.jjy.MispAndroid320:id/tv_title";
		findElement(elementID);
		
		//ī�� ��ȣ 16�ڸ��� �������� �о�ͼ� 4�ڸ��� �Է��ϴ� ���
		
	}
	

			
	
}
