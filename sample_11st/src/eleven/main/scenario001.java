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
	
	// 시간 출력
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

		//app 실행 시 데이터 초기화 방지 스크립트
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
		
		String[] array = elementID.split("/"); //elementID 주소를 / 기준으로 잘라서 출력
		
		try {
			driver.findElementById(elementID);
			System.out.println(array[array.length-1]+" 확인");
			
		} catch (Exception e) {
			System.out.println(array[array.length-1]+" 못찾음");
		} 
		
		Thread.sleep(2000);
		
	}
	
	
	public void xPathClick(String elementID) throws InterruptedException {
		
		String[] array = elementID.split("/"); //elementID 주소를 / 기준으로 잘라서 출력

		try {
			driver.findElementById(elementID).click();
			System.out.println(array[array.length-1]+" 클릭");
			
		} catch (Exception e) {
			System.out.println(array[array.length-1]+" 클릭 실패");
		}
		
		Thread.sleep(2000);
	}

	
	@Test //테스트 시작 시간 log
	public void TC000 () {
		System.out.println("테스트 시나리오1 시작: "+time2);
	}
	
	
	@Test //기기에 켜져있는 모든 APP 닫기
	public void TC001 () throws InterruptedException {
		
		((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
		Thread.sleep(2000);
		
		String elementID = "com.android.systemui:id/recents_close_all_button";
		xPathClick(elementID);
				
	}
	
	
	@Test //페이북 APP 실행 및 확인
	public void TC002 () throws Exception {
		
		driver.launchApp();
		String elementID = "kvp.jjy.MispAndroid320:id/iv_title_menu";
		findElement(elementID);

		System.out.println("페이북 app 실행");
		
	}
	
	@Test //카드추가 버튼 선택
	public void TC003 () throws InterruptedException {
		
		String elementID = "kvp.jjy.MispAndroid320:id/iv_card_add";
		xPathClick(elementID);
		
	}
	
	@Test //카드정보 입력 화면 진입 확인 및 카드 번호 16자리 입력
	public void TC004 () throws InterruptedException {
		
		String elementID = "kvp.jjy.MispAndroid320:id/tv_title";
		findElement(elementID);
		
		//카드 번호 16자리를 엑셀에서 읽어와서 4자리씩 입력하는 방법
		
	}
	

			
	
}
