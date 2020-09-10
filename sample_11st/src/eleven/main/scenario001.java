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

	// �ð� ���
	public static SimpleDateFormat format2 = new SimpleDateFormat("MM/dd HH:mm:ss");
	public static Date time = new Date();
	public static String time2 = format2.format(time);

	public static ArrayList<userInfo> list = new ArrayList<userInfo>(); // userInfo ���� ����Ʈ�� ����ϱ����� ����

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

	@Test // �׽�Ʈ ���� �ð� log
	public void TC000() {
		System.out.println("�׽�Ʈ �ó�����1 ����: " + time2);
	}

	@Test // ��⿡ �����ִ� ��� APP �ݱ�
	public void TC001() throws InterruptedException {

		((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
		Thread.sleep(2000);

		String clearapp8 = "com.android.systemui:id/recents_close_all_button"; //�ȵ�8
		xPathClick(clearapp8);
		
		String clearapp9 = "com.sec.android.app.launcher:id/clear_all_button"; //�ȵ�9
		xPathClick(clearapp9);

	}

	@Test // ���̺� APP ���� �� Ȯ��
	public void TC002() throws Exception {

		driver.launchApp();
		String elementID = "kvp.jjy.MispAndroid320:id/iv_title_menu";
		findElement(elementID);

		System.out.println("���̺� app ����");
		
		Thread.sleep(3000);

	}

	@Test // ī���߰� ��ư ����
	public void TC003() throws InterruptedException {

		String elementID = "kvp.jjy.MispAndroid320:id/iv_card_add";
		xPathClick(elementID);

		Thread.sleep(3000);
		
	}

	@Test // ī������ �Է� ȭ�� ���� Ȯ�� �� ī�� ��ȣ 16�ڸ� �Է�
	public void TC004() throws InterruptedException {

		String elementID = "kvp.jjy.MispAndroid320:id/tv_title";
		findElement(elementID);

		// ����� ����̽��� �´� ī���ȣ �ҷ�����
		int ApplyIndex = 0;
		for (int i = 0; i < list.size(); i++) {
			if ("GS8".equals(list.get(i).getDevice())) {
				ApplyIndex = i;
			}
		}
		userInfo UserInfo = list.get(ApplyIndex);
		System.out.println("ī���ȣ: " + UserInfo.getCardnum());

		//SafeKeyboard ��⿡ ī���ȣ16�ڸ� �Ѱ��ְ� ����Ű�е� Ŭ�� ����
		SafeKeyboard cardnumber = new SafeKeyboard();
		cardnumber.cardnumClick(UserInfo.getCardnum(),driver);
		
		Thread.sleep(5000);
				
	}
	
	@Test // ī�� ��ȿ�Ⱓ, CVC��ȣ 7�ڸ� �Է�
	public void TC005() throws InterruptedException {

		String elementID = "kvp.jjy.MispAndroid320:id/tv_cardexp_label"; //��ȿ�Ⱓ Ÿ��Ʋ
		findElement(elementID);
		//driver.findElements(By.xpath("��ȿ�Ⱓ")); //��ȿ�Ⱓ ã�Ҵٴ°� �α�ǥ���ؾ� ��, �ȵ���̵� 9.0���� ���̺Ϲ��� 7.1.1�������� ������ Ÿ��Ʋ�� elementID Ȯ�� �����ؼ� �ϴ� �ּ�ó��
	
		// ����� ����̽��� �´� ī������ �ҷ�����
		int ApplyIndex = 0;
		for (int i = 0; i < list.size(); i++) {
			if ("GS8".equals(list.get(i).getDevice())) {
				ApplyIndex = i;
			}
		}
		userInfo UserInfo = list.get(ApplyIndex);
		System.out.println("ī������(mmyycvc): " + UserInfo.getCardinfo());

		//SafeKeyboard ��⿡ ī������ 7�ڸ� �Ѱ��ְ� ����Ű�е� Ŭ�� ����
		SafeKeyboard cardmmyycvc = new SafeKeyboard();
		cardmmyycvc.cardinfoClick(UserInfo.getCardinfo(),driver);
		
		Thread.sleep(3000);
				
	}
	
	@Test // ī�� ��й�ȣ 4�ڸ� �Է�
	public void TC006() throws InterruptedException {

		String elementID = "kvp.jjy.MispAndroid320:id/tv_cardpwd_label"; //ī�� ��й�ȣ Ÿ��Ʋ
		findElement(elementID);
		//driver.findElements(By.xpath("��ȿ�Ⱓ")); //��ȿ�Ⱓ ã�Ҵٴ°� �α�ǥ���ؾ� ��, �ȵ���̵� 9.0���� ���̺Ϲ��� 7.1.1�������� ������ Ÿ��Ʋ�� elementID Ȯ�� �����ؼ� �ϴ� �ּ�ó��
		
		// ����� ����̽��� �´� ī������ �ҷ�����
		int ApplyIndex = 0;
		for (int i = 0; i < list.size(); i++) {
			if ("GS8".equals(list.get(i).getDevice())) {
				ApplyIndex = i;
			}
		}
		userInfo UserInfo = list.get(ApplyIndex);
		System.out.println("ī����: " + UserInfo.getCardpw());

		//SafeKeyboard ��⿡ ī������ 7�ڸ� �Ѱ��ְ� ����Ű�е� Ŭ�� ����
		SafeKeyboard cardmmyycvc = new SafeKeyboard();
		cardmmyycvc.cardpwClick(UserInfo.getCardpw(),driver);
				
		Thread.sleep(5000);
		
	}
	
	@Test // ��� ����
	public void TC007 () throws InterruptedException {
		
		String agreementTitle = "kvp.jjy.MispAndroid320:id/tv_title"; //ISP ��� ���� ȭ�� Ÿ��Ʋ
		findElement(agreementTitle);
		
		String agreementButton = "kvp.jjy.MispAndroid320:id/cb_terms1_all"; //��� ���� ��ü���� ��ư
		xPathClick(agreementButton);
		
		String agreemetNext = "kvp.jjy.MispAndroid320:id/btn_ok"; //��� ���� ���� ��ư
		xPathClick(agreemetNext);		
		
		Thread.sleep(5000);
		
	}
	
	@Test // ISP ��������: ī�� ���� �������� ���� (�������� ��Ͽ��� �����Ϸ� ����)
	public void TC008 () throws InterruptedException {
		
		String certTitle = "kvp.jjy.MispAndroid320:id/tv_title"; //�������� ȭ�� Ÿ��Ʋ
		findElement(certTitle);
		
		String certButton = "kvp.jjy.MispAndroid320:id/tv_pubcert"; //���������� ��
		xPathClick(certButton);	
		
		Thread.sleep(3000);
		
		//���������� ���� ȭ�鿡�� ���������� ����
		String certTitle2 = "kvp.jjy.MispAndroid320:id/tv_title"; //���������� ���� ȭ�� Ÿ��Ʋ
		findElement(certTitle2);
		
		//���������� ������ ��������
		int ApplyIndex = 0;
		for (int i = 0; i < list.size(); i++) {
			if ("GS8".equals(list.get(i).getCertdate())) {
				ApplyIndex = i;
			}
		}
		userInfo UserInfo = list.get(ApplyIndex);
		System.out.println(UserInfo.getCertdate());
		
		//�ҷ��� �����ϰ� ��ġ�ϴ� ȭ�� �� ������ txt ã�� ��ã���� ��ũ�� �������� ã��
		//���ҽ� id �̿�: 1. ������ ���ҽ�id ã�Ƽ� ����Ʈ�� ���� 2. �� �߿� getCertdate ���̶� ��ġ�ϴ� �� ã�� 3. �װ� Ŭ��
		//xpath �̿�
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id='kvp.jjy.MispAndroid320:id/tv_pubcert_expireday' and contains(@text, 'UserInfo.getCertdate()')]")).click();
		//driver.findElement(By.xpath("//android.widget.TextView[@resource-id='kvp.jjy.MispAndroid320:id/tv_pubcert_expireday' and contains(@text, '2020.10.15')]")).click();//���� Ȯ�ο�, ���� ���� Ȯ��
		
	}

}
