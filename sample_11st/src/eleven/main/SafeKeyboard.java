package eleven.main;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SafeKeyboard {
	
	public SafeKeyboard(){};
	
	//카드번호 16자리 받기
	public String cardnumClick(String cardnum, AndroidDriver<MobileElement> driver) throws InterruptedException {
		
		//카드번호 쪼개기
		String tmp="";
		for(int i=0; i<16; i++) {
			tmp = cardnum.substring(i,i+1);
			//System.out.println("카드번호 16자리: "+tmp);
			
			switch (tmp) {
			case "0":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='0']")).click();
				System.out.println("카드번호" + tmp + "입력");
				Thread.sleep(300);
				break;
			case "1":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='1']")).click();
				System.out.println("카드번호" + tmp + "입력");
				Thread.sleep(300);
				break;
			case "2":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='2']")).click();
				System.out.println("카드번호" + tmp + "입력");
				Thread.sleep(300);
				break;
			case "3":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='3']")).click();
				System.out.println("카드번호" + tmp + "입력");
				Thread.sleep(300);
				break;
			case "4":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='4']")).click();
				System.out.println("카드번호" + tmp + "입력");
				Thread.sleep(300);
				break;
			case "5":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='5']")).click();
				System.out.println("카드번호" + tmp + "입력");
				Thread.sleep(300);
				break;
			case "6":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='6']")).click();
				System.out.println("카드번호" + tmp + "입력");
				Thread.sleep(300);
				break;
			case "7":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='7']")).click();
				System.out.println("카드번호" + tmp + "입력");
				Thread.sleep(300);
				break;
			case "8":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='8']")).click();
				System.out.println("카드번호" + tmp + "입력");
				Thread.sleep(300);
				break;
			case "9":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='9']")).click();
				System.out.println("카드번호" + tmp + "입력");
				Thread.sleep(300);
				break;
				
			default: //위 케이스에 없는 상황이면 디폴트로 넘어옴
				System.out.println("카드번호 입력 실패");
				break;
			}
			
		}
				
		return cardnum;
		
	}

	
	//카드정보 7자리 받기 (MM YY CVC)
	public String cardinfoClick(String cardinfo, AndroidDriver<MobileElement> driver) throws InterruptedException {
		
		//카드번호 쪼개기
		String tmp="";
		for(int i=0; i<7; i++) {
			tmp = cardinfo.substring(i,i+1);
			//System.out.println("카드정보 MM YY CVC: "+tmp);
			
			switch (tmp) {
			case "0":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='0']")).click();
				System.out.println("카드정보" + tmp + "입력");
				Thread.sleep(300);
				break;
			case "1":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='1']")).click();
				System.out.println("카드정보" + tmp + "입력");
				Thread.sleep(300);
				break;
			case "2":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='2']")).click();
				System.out.println("카드정보" + tmp + "입력");
				Thread.sleep(300);
				break;
			case "3":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='3']")).click();
				System.out.println("카드정보" + tmp + "입력");
				Thread.sleep(300);
				break;
			case "4":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='4']")).click();
				System.out.println("카드정보" + tmp + "입력");
				Thread.sleep(300);
				break;
			case "5":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='5']")).click();
				System.out.println("카드정보" + tmp + "입력");
				Thread.sleep(300);
				break;
			case "6":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='6']")).click();
				System.out.println("카드정보" + tmp + "입력");
				Thread.sleep(300);
				break;
			case "7":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='7']")).click();
				System.out.println("카드정보" + tmp + "입력");
				Thread.sleep(300);
				break;
			case "8":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='8']")).click();
				System.out.println("카드정보" + tmp + "입력");
				Thread.sleep(300);
				break;
			case "9":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='9']")).click();
				System.out.println("카드정보" + tmp + "입력");
				Thread.sleep(300);
				break;
			
				
			default: //위 케이스에 없는 상황이면 디폴트로 넘어옴
				System.out.println("카드정보 입력 실패");
				break;
			}
			
		}
				
		return cardinfo;
		
	}
	
	//카드비밀번호 4자리 받기
	public String cardpwClick(String cardpw, AndroidDriver<MobileElement> driver) throws InterruptedException {
		
		//카드번호 쪼개기
		String tmp="";
		for(int i=0; i<4; i++) {
			tmp = cardpw.substring(i,i+1);
			//System.out.println("카드비밀번호: "+tmp);
			
			switch (tmp) {
			case "0":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='0']")).click();
				System.out.println("카드비번" + tmp + "입력");
				Thread.sleep(300);
				break;
			case "1":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='1']")).click();
				System.out.println("카드비번" + tmp + "입력");
				Thread.sleep(300);
				break;
			case "2":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='2']")).click();
				System.out.println("카드비번" + tmp + "입력");
				Thread.sleep(300);
				break;
			case "3":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='3']")).click();
				System.out.println("카드비번" + tmp + "입력");
				Thread.sleep(300);
				break;
			case "4":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='4']")).click();
				System.out.println("카드비번" + tmp + "입력");
				Thread.sleep(300);
				break;
			case "5":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='5']")).click();
				System.out.println("카드비번" + tmp + "입력");
				Thread.sleep(300);
				break;
			case "6":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='6']")).click();
				System.out.println("카드비번" + tmp + "입력");
				Thread.sleep(300);
				break;
			case "7":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='7']")).click();
				System.out.println("카드비번" + tmp + "입력");
				Thread.sleep(300);
				break;
			case "8":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='8']")).click();
				System.out.println("카드비번" + tmp + "입력");
				Thread.sleep(300);
				break;
			case "9":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='9']")).click();
				System.out.println("카드비번" + tmp + "입력");
				Thread.sleep(300);
				break;
			
				
			default: //위 케이스에 없는 상황이면 디폴트로 넘어옴
				System.out.println("카드비번 입력 실패");
				break;
			}
			
		}
				
		return cardpw;
		
	}
	
	//공인인증서 비밀번호 받기
		public String certpwClick(String certpw, AndroidDriver<MobileElement> driver) throws InterruptedException {
			
			//공증비번 쪼개기
			String tmp="";
			for(int i=0; i<certpw.length(); i++) {
				tmp = certpw.substring(i,i+1);
				//System.out.println("공증비번: "+tmp);
				
				switch (tmp) {
				case "d":
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='d 이응']")).click();
					System.out.println("공증비번" + tmp + "입력");
					Thread.sleep(300);
					break;
				case "e":
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='e 디귿']")).click();
					System.out.println("공증비번" + tmp + "입력");
					Thread.sleep(300);
					break;
				case "f":
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='f 리을']")).click();
					System.out.println("공증비번" + tmp + "입력");
					Thread.sleep(300);
					break;
				case "h":
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='h 오']")).click();
					System.out.println("공증비번" + tmp + "입력");
					Thread.sleep(300);
					break;
				case "i":
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='i 야']")).click();
					System.out.println("공증비번" + tmp + "입력");
					Thread.sleep(300);
					break;
				case "k":
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='k 아']")).click();
					System.out.println("공증비번" + tmp + "입력");
					Thread.sleep(300);
					break;
				case "m":
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='m 으']")).click();
					System.out.println("공증비번" + tmp + "입력");
					Thread.sleep(300);
					break;
				case "s":
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='s 니은']")).click();
					System.out.println("공증비번" + tmp + "입력");
					Thread.sleep(300);
					break;
				case "E":
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='대문자 키보드 변경']")).click();
					Thread.sleep(500);
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='대문자 E 쌍디귿']")).click();
					Thread.sleep(500);
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='소문자 키보드 변경']")).click();
					System.out.println("공증비번" + tmp + "입력");
					Thread.sleep(300);
					break;
				case "1":
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='1']")).click();
					System.out.println("공증비번" + tmp + "입력");
					Thread.sleep(300);
					break;
				
				case "!":
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='특수문자변경']")).click();
					Thread.sleep(500);
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='느낌표']")).click();
					Thread.sleep(500);
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='영문자변경']")).click();
					System.out.println("공증비번" + tmp + "입력");
					Thread.sleep(300);
					break;	
					
				default: //위 케이스에 없는 상황이면 디폴트로 넘어옴
					System.out.println("공증비번 입력 실패");
					break;
				}
				
			}
					
			return certpw;
			
		}
	
		//결제비밀번호 6자리 받기
		public String pbpwClick(String pbpw, AndroidDriver<MobileElement> driver) throws InterruptedException {
			
			//결제비밀번호 쪼개기
			String tmp="";
			for(int i=0; i<6; i++) {
				tmp = pbpw.substring(i,i+1);
				//System.out.println("결제비밀번호: "+tmp);
				
				switch (tmp) {
				case "0":
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='0']")).click();
					System.out.println("결제비번" + tmp + "입력");
					Thread.sleep(300);
					break;
				case "1":
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='1']")).click();
					System.out.println("결제비번" + tmp + "입력");
					Thread.sleep(300);
					break;
				case "2":
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='2']")).click();
					System.out.println("결제비번" + tmp + "입력");
					Thread.sleep(300);
					break;
				case "3":
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='3']")).click();
					System.out.println("결제비번" + tmp + "입력");
					Thread.sleep(300);
					break;
				case "4":
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='4']")).click();
					System.out.println("결제비번" + tmp + "입력");
					Thread.sleep(300);
					break;
				case "5":
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='5']")).click();
					System.out.println("결제비번" + tmp + "입력");
					Thread.sleep(300);
					break;
				case "6":
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='6']")).click();
					System.out.println("결제비번" + tmp + "입력");
					Thread.sleep(300);
					break;
				case "7":
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='7']")).click();
					System.out.println("결제비번" + tmp + "입력");
					Thread.sleep(300);
					break;
				case "8":
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='8']")).click();
					System.out.println("결제비번" + tmp + "입력");
					Thread.sleep(300);
					break;
				case "9":
					driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='9']")).click();
					System.out.println("결제비번" + tmp + "입력");
					Thread.sleep(300);
					break;
				
					
				default: //위 케이스에 없는 상황이면 디폴트로 넘어옴
					System.out.println("결제비밀번호 입력 실패");
					break;
				}
				
			}
					
			return pbpw;
			
		}
	
}
