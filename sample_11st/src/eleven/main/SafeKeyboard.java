package eleven.main;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SafeKeyboard {
	
	public SafeKeyboard(){};
	
	//ī���ȣ 16�ڸ� �ޱ�
	public String cardnumClick(String cardnum, AndroidDriver<MobileElement> driver) throws InterruptedException {
		
		//ī���ȣ �ɰ���
		String tmp="";
		for(int i=0; i<16; i++) {
			tmp = cardnum.substring(i,i+1);
			//System.out.println("ī���ȣ 16�ڸ�: "+tmp);
			
			switch (tmp) {
			case "0":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='0']")).click();
				System.out.println("ī���ȣ" + tmp + "�Է�");
				Thread.sleep(300);
				break;
			case "1":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='1']")).click();
				System.out.println("ī���ȣ" + tmp + "�Է�");
				Thread.sleep(300);
				break;
			case "2":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='2']")).click();
				System.out.println("ī���ȣ" + tmp + "�Է�");
				Thread.sleep(300);
				break;
			case "3":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='3']")).click();
				System.out.println("ī���ȣ" + tmp + "�Է�");
				Thread.sleep(300);
				break;
			case "4":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='4']")).click();
				System.out.println("ī���ȣ" + tmp + "�Է�");
				Thread.sleep(300);
				break;
			case "5":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='5']")).click();
				System.out.println("ī���ȣ" + tmp + "�Է�");
				Thread.sleep(300);
				break;
			case "6":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='6']")).click();
				System.out.println("ī���ȣ" + tmp + "�Է�");
				Thread.sleep(300);
				break;
			case "7":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='7']")).click();
				System.out.println("ī���ȣ" + tmp + "�Է�");
				Thread.sleep(300);
				break;
			case "8":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='8']")).click();
				System.out.println("ī���ȣ" + tmp + "�Է�");
				Thread.sleep(300);
				break;
			case "9":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='9']")).click();
				System.out.println("ī���ȣ" + tmp + "�Է�");
				Thread.sleep(300);
				break;
				
			default: //�� ���̽��� ���� ��Ȳ�̸� ����Ʈ�� �Ѿ��
				System.out.println("ī���ȣ �Է� ����");
				break;
			}
			
		}
				
		return cardnum;
		
	}

	
	//ī������ 7�ڸ� �ޱ� (MM YY CVC)
	public String cardinfoClick(String cardinfo, AndroidDriver<MobileElement> driver) throws InterruptedException {
		
		//ī���ȣ �ɰ���
		String tmp="";
		for(int i=0; i<7; i++) {
			tmp = cardinfo.substring(i,i+1);
			//System.out.println("ī������ MM YY CVC: "+tmp);
			
			switch (tmp) {
			case "0":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='0']")).click();
				System.out.println("ī������" + tmp + "�Է�");
				Thread.sleep(300);
				break;
			case "1":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='1']")).click();
				System.out.println("ī������" + tmp + "�Է�");
				Thread.sleep(300);
				break;
			case "2":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='2']")).click();
				System.out.println("ī������" + tmp + "�Է�");
				Thread.sleep(300);
				break;
			case "3":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='3']")).click();
				System.out.println("ī������" + tmp + "�Է�");
				Thread.sleep(300);
				break;
			case "4":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='4']")).click();
				System.out.println("ī������" + tmp + "�Է�");
				Thread.sleep(300);
				break;
			case "5":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='5']")).click();
				System.out.println("ī������" + tmp + "�Է�");
				Thread.sleep(300);
				break;
			case "6":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='6']")).click();
				System.out.println("ī������" + tmp + "�Է�");
				Thread.sleep(300);
				break;
			case "7":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='7']")).click();
				System.out.println("ī������" + tmp + "�Է�");
				Thread.sleep(300);
				break;
			case "8":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='8']")).click();
				System.out.println("ī������" + tmp + "�Է�");
				Thread.sleep(300);
				break;
			case "9":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='9']")).click();
				System.out.println("ī������" + tmp + "�Է�");
				Thread.sleep(300);
				break;
			
				
			default: //�� ���̽��� ���� ��Ȳ�̸� ����Ʈ�� �Ѿ��
				System.out.println("ī������ �Է� ����");
				break;
			}
			
		}
				
		return cardinfo;
		
	}
	
	//ī���й�ȣ 4�ڸ� �ޱ�
	public String cardpwClick(String cardpw, AndroidDriver<MobileElement> driver) throws InterruptedException {
		
		//ī���ȣ �ɰ���
		String tmp="";
		for(int i=0; i<4; i++) {
			tmp = cardpw.substring(i,i+1);
			//System.out.println("ī���й�ȣ: "+tmp);
			
			switch (tmp) {
			case "0":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='0']")).click();
				System.out.println("ī����" + tmp + "�Է�");
				Thread.sleep(300);
				break;
			case "1":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='1']")).click();
				System.out.println("ī����" + tmp + "�Է�");
				Thread.sleep(300);
				break;
			case "2":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='2']")).click();
				System.out.println("ī����" + tmp + "�Է�");
				Thread.sleep(300);
				break;
			case "3":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='3']")).click();
				System.out.println("ī����" + tmp + "�Է�");
				Thread.sleep(300);
				break;
			case "4":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='4']")).click();
				System.out.println("ī����" + tmp + "�Է�");
				Thread.sleep(300);
				break;
			case "5":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='5']")).click();
				System.out.println("ī����" + tmp + "�Է�");
				Thread.sleep(300);
				break;
			case "6":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='6']")).click();
				System.out.println("ī����" + tmp + "�Է�");
				Thread.sleep(300);
				break;
			case "7":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='7']")).click();
				System.out.println("ī����" + tmp + "�Է�");
				Thread.sleep(300);
				break;
			case "8":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='8']")).click();
				System.out.println("ī����" + tmp + "�Է�");
				Thread.sleep(300);
				break;
			case "9":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='9']")).click();
				System.out.println("ī����" + tmp + "�Է�");
				Thread.sleep(300);
				break;
			
				
			default: //�� ���̽��� ���� ��Ȳ�̸� ����Ʈ�� �Ѿ��
				System.out.println("ī���� �Է� ����");
				break;
			}
			
		}
				
		return cardpw;
		
	}
	
	//���������� ��й�ȣ �ޱ�
		public String certpwClick(String certpw, AndroidDriver<MobileElement> driver) throws InterruptedException {
			
			//������� �ɰ���
			String tmp="";
			for(int i=0; i<certpw.length(); i++) {
				tmp = certpw.substring(i,i+1);
				//System.out.println("�������: "+tmp);
				
				switch (tmp) {
				case "d":
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='d ����']")).click();
					System.out.println("�������" + tmp + "�Է�");
					Thread.sleep(300);
					break;
				case "e":
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='e ���']")).click();
					System.out.println("�������" + tmp + "�Է�");
					Thread.sleep(300);
					break;
				case "f":
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='f ����']")).click();
					System.out.println("�������" + tmp + "�Է�");
					Thread.sleep(300);
					break;
				case "h":
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='h ��']")).click();
					System.out.println("�������" + tmp + "�Է�");
					Thread.sleep(300);
					break;
				case "i":
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='i ��']")).click();
					System.out.println("�������" + tmp + "�Է�");
					Thread.sleep(300);
					break;
				case "k":
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='k ��']")).click();
					System.out.println("�������" + tmp + "�Է�");
					Thread.sleep(300);
					break;
				case "m":
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='m ��']")).click();
					System.out.println("�������" + tmp + "�Է�");
					Thread.sleep(300);
					break;
				case "s":
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='s ����']")).click();
					System.out.println("�������" + tmp + "�Է�");
					Thread.sleep(300);
					break;
				case "E":
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='�빮�� Ű���� ����']")).click();
					Thread.sleep(500);
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='�빮�� E �ֵ��']")).click();
					Thread.sleep(500);
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='�ҹ��� Ű���� ����']")).click();
					System.out.println("�������" + tmp + "�Է�");
					Thread.sleep(300);
					break;
				case "1":
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='1']")).click();
					System.out.println("�������" + tmp + "�Է�");
					Thread.sleep(300);
					break;
				
				case "!":
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Ư�����ں���']")).click();
					Thread.sleep(500);
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='����ǥ']")).click();
					Thread.sleep(500);
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='�����ں���']")).click();
					System.out.println("�������" + tmp + "�Է�");
					Thread.sleep(300);
					break;	
					
				default: //�� ���̽��� ���� ��Ȳ�̸� ����Ʈ�� �Ѿ��
					System.out.println("������� �Է� ����");
					break;
				}
				
			}
					
			return certpw;
			
		}
	
		//������й�ȣ 6�ڸ� �ޱ�
		public String pbpwClick(String pbpw, AndroidDriver<MobileElement> driver) throws InterruptedException {
			
			//������й�ȣ �ɰ���
			String tmp="";
			for(int i=0; i<6; i++) {
				tmp = pbpw.substring(i,i+1);
				//System.out.println("������й�ȣ: "+tmp);
				
				switch (tmp) {
				case "0":
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='0']")).click();
					System.out.println("�������" + tmp + "�Է�");
					Thread.sleep(300);
					break;
				case "1":
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='1']")).click();
					System.out.println("�������" + tmp + "�Է�");
					Thread.sleep(300);
					break;
				case "2":
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='2']")).click();
					System.out.println("�������" + tmp + "�Է�");
					Thread.sleep(300);
					break;
				case "3":
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='3']")).click();
					System.out.println("�������" + tmp + "�Է�");
					Thread.sleep(300);
					break;
				case "4":
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='4']")).click();
					System.out.println("�������" + tmp + "�Է�");
					Thread.sleep(300);
					break;
				case "5":
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='5']")).click();
					System.out.println("�������" + tmp + "�Է�");
					Thread.sleep(300);
					break;
				case "6":
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='6']")).click();
					System.out.println("�������" + tmp + "�Է�");
					Thread.sleep(300);
					break;
				case "7":
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='7']")).click();
					System.out.println("�������" + tmp + "�Է�");
					Thread.sleep(300);
					break;
				case "8":
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='8']")).click();
					System.out.println("�������" + tmp + "�Է�");
					Thread.sleep(300);
					break;
				case "9":
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='9']")).click();
					System.out.println("�������" + tmp + "�Է�");
					Thread.sleep(300);
					break;
				
					
				default: //�� ���̽��� ���� ��Ȳ�̸� ����Ʈ�� �Ѿ��
					System.out.println("������й�ȣ �Է� ����");
					break;
				}
				
			}
					
			return pbpw;
			
		}
	
}
