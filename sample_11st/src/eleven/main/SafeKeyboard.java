package eleven.main;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SafeKeyboard {
	
	public SafeKeyboard(){};
	
	//ī���ȣ 16�ڸ� �ޱ�
	public String cardnumClick(String cardnum, AndroidDriver<MobileElement> driver) {
		
		//ī���ȣ �ɰ���
		String tmp="";
		for(int i=0; i<16; i++) {
			tmp = cardnum.substring(i,i+1);
			System.out.println("ī���ȣ 16�ڸ�: "+tmp);
			
			switch (tmp) {
			case "0":
				System.out.println("����ġ" + tmp);
				//driver.findElementById("//android.widget.ImageView[@content-desc='0']").click();
				break;
			case "1":
				System.out.println("����ġ" + tmp);
				break;
			case "2":
				System.out.println("����ġ" + tmp);
				break;
			case "3":
				System.out.println("����ġ" + tmp);
				break;
			case "4":
				System.out.println("����ġ" + tmp);
				break;
			case "5":
				System.out.println("����ġ" + tmp);
				break;
			case "6":
				System.out.println("����ġ" + tmp);
				break;
			case "7":
				System.out.println("����ġ" + tmp);
				break;
			case "8":
				System.out.println("����ġ" + tmp);
				break;
			case "9":
				System.out.println("����ġ" + tmp);
				break;
				
			default: //�� ���̽��� ���� ��Ȳ�̸� ����Ʈ�� �Ѿ��
				System.out.println("ī���ȣ ������");
				break;
			}
			
		}
				
		return cardnum;
		
	}

	
	//ī������ 7�ڸ� �ޱ� (MM YY CVC)
	public String cardinfoClick(String cardinfo, AndroidDriver<MobileElement> driver) {
		
		//ī���ȣ �ɰ���
		String tmp="";
		for(int i=0; i<7; i++) {
			tmp = cardinfo.substring(i,i+1);
			System.out.println("ī������ MM YY CVC: "+tmp);
			
			switch (tmp) {
			case "0":
				System.out.println("����ġ" + tmp);
				//driver.findElementById("//android.widget.ImageView[@content-desc='0']").click();
				break;
			case "1":
				System.out.println("����ġ" + tmp);
				break;
			case "2":
				System.out.println("����ġ" + tmp);
				break;
			case "3":
				System.out.println("����ġ" + tmp);
				break;
			case "4":
				System.out.println("����ġ" + tmp);
				break;
			case "5":
				System.out.println("����ġ" + tmp);
				break;
			case "6":
				System.out.println("����ġ" + tmp);
				break;
			case "7":
				System.out.println("����ġ" + tmp);
				break;
			case "8":
				System.out.println("����ġ" + tmp);
				break;
			case "9":
				System.out.println("����ġ" + tmp);
				break;
				
			default: //�� ���̽��� ���� ��Ȳ�̸� ����Ʈ�� �Ѿ��
				System.out.println("ī������ ������");
				break;
			}
			
		}
				
		return cardinfo;
		
	}
	
}
