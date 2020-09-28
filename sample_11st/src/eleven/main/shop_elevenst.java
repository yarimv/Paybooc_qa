package eleven.main;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

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


	
	//resource-id ã��
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

	//resource-id Ŭ�� (xpath �ȵ�)
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
			MobileElement inputID = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='userId']"));
			inputID.click();
			inputID.sendKeys("inmanaged"); //userinfo ���� �� �־�� ��
			
			Thread.sleep(1000);
			
			//appium send text�� ���θ� pw �Է�
			MobileElement inputPW = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='userPw']"));
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
		
		
		//Ȩȭ������ �̵�
		String iconHome = "com.elevenst:id/btn_home";
		xPathClick(iconHome);
		
		Thread.sleep(3000);
		
		//Ȩȭ�� �˻��� �Է� �ȵ� ����
		String iconSearch = "com.elevenst:id/gnb_adsearch";
		xPathClick(iconSearch);
		
		Thread.sleep(1000);
		
		//�˻� ���̾�â �˻��� �Է� �ʵ� ���� �� �˻��� �Է�
		MobileElement inputSearch = (MobileElement) driver.findElement(By.id("com.elevenst:id/search_input"));
		Thread.sleep(1000);
		inputSearch.click();
		inputSearch.clear();
		inputSearch.sendKeys("������");
		
		Thread.sleep(1000);
		
		String iconSearchenter = "com.elevenst:id/icon_search";
		xPathClick(iconSearchenter);
		
		Thread.sleep(3000);
		
	}

	@Test //�˻� ��� ����Ʈ���� ��ǰ ����
	public void TC017 () throws InterruptedException, Exception {
		
		//�˻� ��� ����Ʈ ȭ�� ��ȯ Ȯ��
		driver.findElement(By.xpath("//android.widget.TextView[@text='���հ˻�']"));
		
		//ȭ�鿡 ����� ��ǰ Ÿ��Ʋ ���� ���� �� ù��°�� ����
		try {

			//List<MobileElement> product = driver.findElements(By.xpath("//android.view.ViewGroup/android.view.ViewGroup[2]")); //��ǰ Ÿ��Ʋ xpath
			//List<MobileElement> product = driver.findElements(By.id("com.elevenst:id/recentViewImages")); //catch throw Ȯ�ο�
			List<MobileElement> product = driver.findElements(By.id("com.elevenst:id/title_container")); //��ǰ Ÿ��Ʋ resource-id
			System.out.println("�˻���� ����Ʈ ��ǰ���� :" + product.size());
			product.get(0).click();
			
		} catch (Exception e) {
			
			throw new Exception("��ǰ ���� ����"); 
		}
		
		Thread.sleep(5000);
		
	}

	@Test //��ǰ �� ȭ�� �ɼ� ����
	public void TC018 () throws InterruptedException {
		
		//�ɼ� Ȯ�� �� [�����ϱ�] ��ư ����
		String payment = "com.elevenst:id/btnRight";
		xPathClick(payment);
		
		Thread.sleep(3000);
		
		
		//�ٷα��� ��ư ã��
		String paymentnow = "com.elevenst:id/btnRight";
		findElement(paymentnow);
		List<MobileElement> aa = driver.findElements(By.id(paymentnow)); //findElement ��ɾ ��ã���� �ͼ����� �ȳ��� ����Ʈ�� ����� while ���ǹ� �ϼ�
		
		int optionnum = 0;
		
		while (aa.size() == 0) {
			
			List<MobileElement> option = driver.findElements(By.id("com.elevenst:id/text5"));
			System.out.println("�ɼǰ���: " + option.size());
			option.get(optionnum).click();
			
			optionnum++;
			
			aa = driver.findElements(By.id(paymentnow));
			
			Thread.sleep(2000);
			
		}
		
		xPathClick(paymentnow);
		
		Thread.sleep(5000);
		
	}
	
	@Test //�ֹ��� ȭ�� �������� ���� �� ���� ��û
	public void TC019 () throws InterruptedException {
		
		//�ֹ��� ȭ�� �̵� Ȯ��
		driver.findElement(By.xpath("//android.view.View[@text='�ֹ�����SK pay']"));
		
		//�Ϲݰ��� ã��
		MobileElement generalpay = null; //for�� �ۿ����� Certdate ������ ����ϱ� ���� �ʱ�ȭ
		TouchAction action = new TouchAction(driver);
		
		//System.out.println(driver.manage().window().getSize());
		Dimension dimension = driver.manage().window().getSize();
		
		Double scrollingHS = dimension.getHeight()*0.7;
		int scrollStart = scrollingHS.intValue();
		
		Double scrollingHE = dimension.getHeight()*0.2;
		int scrollEnd = scrollingHE.intValue();
		
		//�Ϲݰ��� ã�Ƽ� ��ũ��
		for (int i=0; i<10; i++) {
			try {
				
				generalpay = driver.findElement(By.xpath("//android.widget.RadioButton[@text='�Ϲݰ���']"));

				break;
				
			//generalpay ��ã���� ��ũ���ϰ� 5�� ������ ��ã���� ������ ������ ��ã�� exception ����	
			} catch (NoSuchElementException e) {

				action.press(PointOption.point(115, scrollStart))
					.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
	                .moveTo(PointOption.point(115, scrollEnd))
	                .release().perform();
				
				if (i==9) {
					throw new NoSuchElementException("�Ϲݰ������� ��ã��");
				}
			}
		}
		
		//�Ϲݰ��� xpath ��ǥ Ȯ��
		Point location = generalpay.getLocation();
		//System.out.println(generalpay.getLocation()); //��ǥ�� Ȯ��
		
		int locationX = generalpay.getLocation().getX();
		int locationY = generalpay.getLocation().getY();
		System.out.println(locationX); //��ǥ�� Ȯ��
		System.out.println(locationY); //��ǥ�� Ȯ��
		
		//�Ϲݰ��� Ŭ�� �κ��� location������ �۵� �ȵǹǷ� Ŭ�� ��ǥ ����
		action.tap(PointOption.point(locationX+100, locationY+30)).perform(); //�����غ��� �� press�� ���� �� �ȵ���̵� �޴� �� (����...)
		
		Thread.sleep(2000);
		
		//�ſ�ī�� ã�Ƽ� ��ũ��
		MobileElement creditcard = null;
		for (int i=0; i<5; i++) {
			try {
				creditcard = driver.findElement(By.xpath("//android.widget.Button[@resource-id='payCard']"));
				
				break;
				
			} catch (NoSuchElementException e) {
				
				action.press(PointOption.point(0, scrollStart))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(0, scrollEnd))
                .release().perform();
			
				if (i==4) {
					throw new NoSuchElementException("�ſ�ī�� ��ã��");
				}
			}
		}
		
		creditcard.click();
		
		Thread.sleep(1000);
		
		//BCī�� ã�Ƽ� ��ũ�� �� Ŭ��
		MobileElement creditBCcard = null;
		for (int i=0; i<5; i++) {
			try {
				creditBCcard = driver.findElement(By.xpath("//android.widget.RadioButton[@resource-id='cardKind27']"));
				
				break;
				
			} catch (NoSuchElementException e) {
				
				action.press(PointOption.point(0, scrollStart))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(0, scrollEnd))
                .release().perform();
			
				if (i==4) {
					throw new NoSuchElementException("BCī�� ��ã��");
				}
			}
		}
		
		creditBCcard.click();
		Thread.sleep(1000);
		
		//������ư ����
		driver.findElement(By.xpath("//android.widget.Button[@resource-id='doPaySubmit']")).click();
		Thread.sleep(5000);
		
	}
	
	@Test //���̺�PG �����ϱ� ��ư ����
	public void TC020 () throws InterruptedException {
		
		//���̺� PG ȭ�� ��ȯ Ȯ��
		driver.findElement(By.xpath("//android.view.View[@text='���̺�']"));

		try {
			driver.findElement(By.xpath("//android.view.View[@text='�����ϱ�']")).click();
			
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("���̺� ����PG �����ϱ� ��ư ��ã��");
			
		}
		
		Thread.sleep(5000);

	}
	
	@Test //���̺� app ȣ�� �� ���ī�� ���� Ȯ��
	public void TC021 () throws InterruptedException {
		
		//���̺� ȣ�� Ȯ��
		String paypblogo = "kvp.jjy.MispAndroid320:id/iv_title_logo";
		findElement(paypblogo);
		
		//1.ī�� ��ȣ ���� ���� 2. ī�� ��ȣ �� 4�ڸ��� ������ �Է�
		//���� ����̽��� �´� ī�� ��ȣ ��������
		int ApplyIndex = 0;
		for (int i = 0; i < list.size(); i++) {
			if ("GS8".equals(list.get(i).getCardnum())) {
				ApplyIndex = i;
			}
		}
		userInfo UserInfo = list.get(ApplyIndex);
		
		//ī�� ��ȣ �� 4�ڸ� �ڸ���
		String endCardnum = UserInfo.getCardnum().substring(UserInfo.getCardnum().length()-4, UserInfo.getCardnum().length());
		//System.out.println(endCardnum); //Ȯ�ο�
		
		//���̺� ȭ�鿡�� ī���ȣ �� 4�ڸ� ��ġ Ȯ��
		try {
			
			driver.findElement(By.xpath("//android.widget.TextView[@text='" + endCardnum + "']"));
			//driver.findElement(By.xpath("//android.widget.TextView[@text='1111']")); //ī���� ���� Ȯ�ο�
			System.out.println("���ī�� Ȯ��");
			
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("���ī�� �̳���");
		}
		
		Thread.sleep(3000);
		
	}
	
	@Test //������й�ȣ �Է�
	public void TC022 () throws InterruptedException {
		
		//����� ����̽��� �´� ������й�ȣ �ҷ�����
		int ApplyIndex = 0;
		for (int i=0; i<list.size(); i++) {
			if ("GS8".equals(list.get(i).getDevice())) {
				ApplyIndex = i;
			}
		}
		userInfo UserInfo = list.get(ApplyIndex);
		System.out.println("������й�ȣ: " + UserInfo.getPbpw());
		
		//SafeKeyboard ��⿡ ������й�ȣ �Ѱ��ְ� ����Ű�е� Ŭ�� ����
		SafeKeyboard pbpw = new SafeKeyboard();
		pbpw.pbpwClick(UserInfo.getPbpw(),driver);
		
		Thread.sleep(10000);
		
	}
	
	@Test //���� ��û �Ϸ� �˾�â �ݱ�
	public void TC023 () throws InterruptedException {
		
		//���� ��û �Ϸ� �˾� Ȯ��
		String payConfirm = "kvp.jjy.MispAndroid320:id/tvMsg";
		findElement(payConfirm);
		
		//���� ��û �Ϸ� �˾� Ȯ�� ��ư Ŭ�� 
		String payConfirmbutton = "kvp.jjy.MispAndroid320:id/btnRight";
		xPathClick(payConfirmbutton);
		
		Thread.sleep(5000);
		
	}
	
	@Test //���� ��� Ȯ��
	public void TC024 () {
		
		//���� ��� ȭ�� ��ȯ Ȯ��
		driver.findElement(By.xpath("//android.view.View[@text='�ֹ�����SK pay']"));
		
		//���� ���� ���� ���
		MobileElement text = driver.findElement(By.xpath("//android.view.View/android.view.View[2]/android.widget.ListView/android.view.View/android.view.View[2]"));
		System.out.println(text.getText());
		
	}
	
	 @Test //����� ��� app ����
	 public void closeApp () throws InterruptedException {

		((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
		Thread.sleep(2000);

		String clearapp8 = "com.android.systemui:id/recents_close_all_button"; //�ȵ�8
		xPathClick(clearapp8);
		
		String clearapp9 = "com.sec.android.app.launcher:id/clear_all_button"; //�ȵ�9
		xPathClick(clearapp9);
		
		System.out.println("11���� ���� �׽�Ʈ ����");
		
		Thread.sleep(5000);
	 
	 }
	
	
}
