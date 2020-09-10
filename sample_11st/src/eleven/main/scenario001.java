package eleven.main;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
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
	public static SimpleDateFormat format2 = new SimpleDateFormat("MM/dd HH:mm:ss");
	public static Date time = new Date();
	public static String time2 = format2.format(time);

	public static ArrayList<userInfo> list = new ArrayList<userInfo>(); // userInfo 값을 리스트로 사용하기위해 선언

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

		dc.setCapability("appPackage", "kvp.jjy.MispAndroid320");
		dc.setCapability("appActivity", "kvp.jjy.MispAndroid320.newui.icon.WinterIcon");

		// app 실행 시 데이터 초기화 방지 스크립트
		dc.setCapability("noReset", true);
		dc.setCapability("fullReset", false);

		driver = new AndroidDriver<MobileElement>(url, dc);

	}

	/*
	 * @AfterTest public void closeApp () throws InterruptedException {
	 * driver.closeApp (); }
	 */
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

	@Test // 테스트 시작 시간 log
	public void TC000() {
		System.out.println("테스트 시나리오1 시작: " + time2);
	}

	@Test // 기기에 켜져있는 모든 APP 닫기
	public void TC001() throws InterruptedException {

		((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
		Thread.sleep(2000);

		String clearapp8 = "com.android.systemui:id/recents_close_all_button"; //안드8
		xPathClick(clearapp8);
		
		String clearapp9 = "com.sec.android.app.launcher:id/clear_all_button"; //안드9
		xPathClick(clearapp9);

	}

	@Test // 페이북 APP 실행 및 확인
	public void TC002() throws Exception {

		driver.launchApp();
		String elementID = "kvp.jjy.MispAndroid320:id/iv_title_menu";
		findElement(elementID);

		System.out.println("페이북 app 실행");
		
		Thread.sleep(3000);

	}

	@Test // 카드추가 버튼 선택
	public void TC003() throws InterruptedException {

		String elementID = "kvp.jjy.MispAndroid320:id/iv_card_add";
		xPathClick(elementID);

		Thread.sleep(3000);
		
	}

	@Test // 카드정보 입력 화면 진입 확인 및 카드 번호 16자리 입력
	public void TC004() throws InterruptedException {

		String elementID = "kvp.jjy.MispAndroid320:id/tv_title";
		findElement(elementID);

		// 연결된 디바이스에 맞는 카드번호 불러오기
		int ApplyIndex = 0;
		for (int i = 0; i < list.size(); i++) {
			if ("GS8".equals(list.get(i).getDevice())) {
				ApplyIndex = i;
			}
		}
		userInfo UserInfo = list.get(ApplyIndex);
		System.out.println("카드번호: " + UserInfo.getCardnum());

		//SafeKeyboard 모듈에 카드번호16자리 넘겨주고 보안키패드 클릭 실행
		SafeKeyboard cardnumber = new SafeKeyboard();
		cardnumber.cardnumClick(UserInfo.getCardnum(),driver);
		
		Thread.sleep(5000);
				
	}
	
	@Test // 카드 유효기간, CVC번호 7자리 입력
	public void TC005() throws InterruptedException {

		String elementID = "kvp.jjy.MispAndroid320:id/tv_cardexp_label"; //유효기간 타이틀
		findElement(elementID);
		//driver.findElements(By.xpath("유효기간")); //유효기간 찾았다는거 로그표시해야 됨, 안드로이드 9.0인지 페이북버전 7.1.1버전인지 모르지만 타이틀에 elementID 확인 가능해서 일단 주석처리
	
		// 연결된 디바이스에 맞는 카드정보 불러오기
		int ApplyIndex = 0;
		for (int i = 0; i < list.size(); i++) {
			if ("GS8".equals(list.get(i).getDevice())) {
				ApplyIndex = i;
			}
		}
		userInfo UserInfo = list.get(ApplyIndex);
		System.out.println("카드정보(mmyycvc): " + UserInfo.getCardinfo());

		//SafeKeyboard 모듈에 카드정보 7자리 넘겨주고 보안키패드 클릭 실행
		SafeKeyboard cardmmyycvc = new SafeKeyboard();
		cardmmyycvc.cardinfoClick(UserInfo.getCardinfo(),driver);
		
		Thread.sleep(3000);
				
	}
	
	@Test // 카드 비밀번호 4자리 입력
	public void TC006() throws InterruptedException {

		String elementID = "kvp.jjy.MispAndroid320:id/tv_cardpwd_label"; //카드 비밀번호 타이틀
		findElement(elementID);
		//driver.findElements(By.xpath("유효기간")); //유효기간 찾았다는거 로그표시해야 됨, 안드로이드 9.0인지 페이북버전 7.1.1버전인지 모르지만 타이틀에 elementID 확인 가능해서 일단 주석처리
		
		// 연결된 디바이스에 맞는 카드정보 불러오기
		int ApplyIndex = 0;
		for (int i = 0; i < list.size(); i++) {
			if ("GS8".equals(list.get(i).getDevice())) {
				ApplyIndex = i;
			}
		}
		userInfo UserInfo = list.get(ApplyIndex);
		System.out.println("카드비번: " + UserInfo.getCardpw());

		//SafeKeyboard 모듈에 카드정보 7자리 넘겨주고 보안키패드 클릭 실행
		SafeKeyboard cardmmyycvc = new SafeKeyboard();
		cardmmyycvc.cardpwClick(UserInfo.getCardpw(),driver);
				
		Thread.sleep(5000);
		
	}
	
	@Test // 약관 동의
	public void TC007 () throws InterruptedException {
		
		String agreementTitle = "kvp.jjy.MispAndroid320:id/tv_title"; //ISP 약관 동의 화면 타이틀
		findElement(agreementTitle);
		
		String agreementButton = "kvp.jjy.MispAndroid320:id/cb_terms1_all"; //약관 동의 전체선택 버튼
		xPathClick(agreementButton);
		
		String agreemetNext = "kvp.jjy.MispAndroid320:id/btn_ok"; //약관 동의 다음 버튼
		xPathClick(agreemetNext);		
		
		Thread.sleep(5000);
		
	}
	
	@Test // ISP 본인인증: 카드 명의 공인인증 선택 (공인인증 목록에서 만료일로 구분)
	public void TC008 () throws InterruptedException {
		
		String certTitle = "kvp.jjy.MispAndroid320:id/tv_title"; //본인인증 화면 타이틀
		findElement(certTitle);
		
		String certButton = "kvp.jjy.MispAndroid320:id/tv_pubcert"; //공인인증서 탭
		xPathClick(certButton);	
		
		Thread.sleep(3000);
		
		//공인인증서 인증 화면에서 공인인증서 선택
		String certTitle2 = "kvp.jjy.MispAndroid320:id/tv_title"; //공인인증서 인증 화면 타이틀
		findElement(certTitle2);
		
		//공인인증서 만료일 가져오기
		int ApplyIndex = 0;
		for (int i = 0; i < list.size(); i++) {
			if ("GS8".equals(list.get(i).getCertdate())) {
				ApplyIndex = i;
			}
		}
		userInfo UserInfo = list.get(ApplyIndex);
		System.out.println(UserInfo.getCertdate());
		
		//불러온 만료일과 일치하는 화면 내 만료일 txt 찾기 못찾으면 스크롤 동작으로 찾기
		//리소스 id 이용: 1. 만료일 리소스id 찾아서 리스트로 만듦 2. 그 중에 getCertdate 값이랑 일치하는 애 찾음 3. 그거 클릭
		//xpath 이용
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id='kvp.jjy.MispAndroid320:id/tv_pubcert_expireday' and contains(@text, 'UserInfo.getCertdate()')]")).click();
		//driver.findElement(By.xpath("//android.widget.TextView[@resource-id='kvp.jjy.MispAndroid320:id/tv_pubcert_expireday' and contains(@text, '2020.10.15')]")).click();//동작 확인용, 정상 동작 확인
		
	}

}
