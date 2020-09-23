package eleven.main;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;

public class shop_elevenst {
	
	//따로 돌리기 위해 선언
	public static URL url;
	public static DesiredCapabilities dc;
	public static AndroidDriver<MobileElement> driver;
	
	public static ArrayList<userInfo> list = new ArrayList<userInfo>(); // userInfo 값을 리스트로 사용하기위해 선언
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

		// app 실행 시 데이터 초기화 방지 스크립트
		dc.setCapability("noReset", true);
		dc.setCapability("fullReset", false);

		driver = new AndroidDriver<MobileElement>(url, dc);

	}

	/*
	 * @AfterTest public void closeApp () throws InterruptedException {
	 * driver.closeApp (); }
	 */
	
	//resource-id 찾기
	public void findElement(String elementID) throws InterruptedException {

		String[] array = elementID.split("/"); // elementID 주소를 / 기준으로 잘라서 출력

		try {
			driver.findElementById(elementID);
			System.out.println(array[array.length - 1] + " 확인");

		} catch (Exception e) {
			System.out.println(array[array.length - 1] + " 못찾음");
		}

		Thread.sleep(2000);

	}

	//resource-id 클릭 (xpath 안됨)
	public void xPathClick(String elementID) throws InterruptedException {

		String[] array = elementID.split("/"); // elementID 주소를 / 기준으로 잘라서 출력

		try {
			driver.findElementById(elementID).click();
			System.out.println(array[array.length - 1] + " 클릭");

		} catch (Exception e) {
			System.out.println(array[array.length - 1] + " 클릭 실패");
		}

		Thread.sleep(2000);
	}
	
	
	@Test
	public void TC013 () throws InterruptedException {
		
		//열려있는 모든 앱 닫기
		((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
		Thread.sleep(2000);

		String clearapp8 = "com.android.systemui:id/recents_close_all_button"; //안드8
		xPathClick(clearapp8);
		
		String clearapp9 = "com.sec.android.app.launcher:id/clear_all_button"; //안드9
		xPathClick(clearapp9);
		
		//11번가 앱 실행 및 
		driver.launchApp();
		
		Thread.sleep(5000);
		
		String elevenLogo = "com.elevenst:id/gnb_logo";
		findElement(elevenLogo);
		
		Thread.sleep(3000);
		
	}
	
	//TC014 11번가 광고 화면, 팝업이 없어서 일단 건너 뜀
	
	@Test //11번가 로그인 확인
	public void TC015 () throws InterruptedException {
		
		//11번가 마이 화면으로 이동
		String myEleven = "com.elevenst:id/btn_my";
		xPathClick(myEleven);
		
		Thread.sleep(3000);
		
		// 마이페이지 [회원정보] 버튼 찾기 else if 로그인 프로세스 시작
		try {
			driver.findElement(By.xpath("//android.view.View[@text='나의 11번가']"));
			
		} catch (Exception e) {

			//appium send text로 쇼핑몰 id 입력
			MobileElement inputID = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='userId']"));
			inputID.click();
			inputID.sendKeys("inmanaged"); //userinfo 엑셀 값 넣어야 함
			
			Thread.sleep(1000);
			
			//appium send text로 쇼핑몰 pw 입력
			MobileElement inputPW = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='userPw']"));
			inputPW.click();
			inputPW.sendKeys("qmdlvl1!"); //userinfo 엑셀 값 넣어야 함
			
			Thread.sleep(1000);
			
			//로그인 버튼 클릭
			driver.findElement(By.xpath("//android.widget.Button[@text='로그인']")).click();
			
			Thread.sleep(5000);
			
		} finally {
			driver.findElement(By.xpath("//android.view.View[@text='나의 11번가']"));
			System.out.println("로그인 확인");
			
		}
		
		Thread.sleep(3000);
			
	}
	
	@Test //검색창 열고 검색어 입력하여 검색
	public void TC016 () throws InterruptedException {
		
		
		//홈화면으로 이동
		String iconHome = "com.elevenst:id/btn_home";
		xPathClick(iconHome);
		
		Thread.sleep(3000);
		
		//홈화면 검색어 입력 픽드 선택
		String iconSearch = "com.elevenst:id/gnb_adsearch";
		xPathClick(iconSearch);
		
		Thread.sleep(1000);
		
		//검색 레이어창 검색어 입력 필드 선택 및 검색어 입력
		MobileElement inputSearch = (MobileElement) driver.findElement(By.id("com.elevenst:id/search_input"));
		Thread.sleep(1000);
		inputSearch.click();
		inputSearch.clear();
		inputSearch.sendKeys("오리젠");
		
		Thread.sleep(1000);
		
		String iconSearchenter = "com.elevenst:id/icon_search";
		xPathClick(iconSearchenter);
		
		Thread.sleep(3000);
		
	}

	@Test //검색 결과 리스트에서 상품 선택
	public void TC017 () throws InterruptedException, Exception {
		
		//검색 결과 리스트 화면 전환 확인
		driver.findElement(By.xpath("//android.widget.TextView[@text='통합검색']"));
		
		//화면에 노출된 상품 타이틀 개수 산정 후 첫번째거 선택
		try {

			//List<MobileElement> product = driver.findElements(By.xpath("//android.view.ViewGroup/android.view.ViewGroup[2]")); //상품 타이틀 xpath
			//List<MobileElement> product = driver.findElements(By.id("com.elevenst:id/recentViewImages")); //catch throw 확인용
			List<MobileElement> product = driver.findElements(By.id("com.elevenst:id/title_container")); //상품 타이틀 resource-id
			System.out.println(product.size());
			product.get(0).click();
			
		} catch (Exception e) {
			
			throw new Exception("상품 선택 실패"); 
		}
		
		Thread.sleep(5000);
		
	}

	@Test //상품 상세 화면 옵션 선택
	public void TC018 () {
		
	}
	
}
