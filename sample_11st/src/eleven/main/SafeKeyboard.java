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
				Thread.sleep(1000);
				break;
			case "1":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='1']")).click();
				System.out.println("카드번호" + tmp + "입력");
				Thread.sleep(1000);
				break;
			case "2":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='2']")).click();
				System.out.println("카드번호" + tmp + "입력");
				Thread.sleep(1000);
				break;
			case "3":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='3']")).click();
				System.out.println("카드번호" + tmp + "입력");
				Thread.sleep(1000);
				break;
			case "4":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='4']")).click();
				System.out.println("카드번호" + tmp + "입력");
				Thread.sleep(1000);
				break;
			case "5":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='5']")).click();
				System.out.println("카드번호" + tmp + "입력");
				Thread.sleep(1000);
				break;
			case "6":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='6']")).click();
				System.out.println("카드번호" + tmp + "입력");
				Thread.sleep(1000);
				break;
			case "7":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='7']")).click();
				System.out.println("카드번호" + tmp + "입력");
				Thread.sleep(1000);
				break;
			case "8":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='8']")).click();
				System.out.println("카드번호" + tmp + "입력");
				Thread.sleep(1000);
				break;
			case "9":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='9']")).click();
				System.out.println("카드번호" + tmp + "입력");
				Thread.sleep(1000);
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
				Thread.sleep(1000);
				break;
			case "1":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='1']")).click();
				System.out.println("카드정보" + tmp + "입력");
				Thread.sleep(1000);
				break;
			case "2":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='2']")).click();
				System.out.println("카드정보" + tmp + "입력");
				Thread.sleep(1000);
				break;
			case "3":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='3']")).click();
				System.out.println("카드정보" + tmp + "입력");
				Thread.sleep(1000);
				break;
			case "4":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='4']")).click();
				System.out.println("카드정보" + tmp + "입력");
				Thread.sleep(1000);
				break;
			case "5":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='5']")).click();
				System.out.println("카드정보" + tmp + "입력");
				Thread.sleep(1000);
				break;
			case "6":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='6']")).click();
				System.out.println("카드정보" + tmp + "입력");
				Thread.sleep(1000);
				break;
			case "7":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='7']")).click();
				System.out.println("카드정보" + tmp + "입력");
				Thread.sleep(1000);
				break;
			case "8":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='8']")).click();
				System.out.println("카드정보" + tmp + "입력");
				Thread.sleep(1000);
				break;
			case "9":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='9']")).click();
				System.out.println("카드정보" + tmp + "입력");
				Thread.sleep(1000);
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
				Thread.sleep(1000);
				break;
			case "1":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='1']")).click();
				System.out.println("카드비번" + tmp + "입력");
				Thread.sleep(1000);
				break;
			case "2":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='2']")).click();
				System.out.println("카드비번" + tmp + "입력");
				Thread.sleep(1000);
				break;
			case "3":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='3']")).click();
				System.out.println("카드비번" + tmp + "입력");
				Thread.sleep(1000);
				break;
			case "4":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='4']")).click();
				System.out.println("카드비번" + tmp + "입력");
				Thread.sleep(1000);
				break;
			case "5":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='5']")).click();
				System.out.println("카드비번" + tmp + "입력");
				Thread.sleep(1000);
				break;
			case "6":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='6']")).click();
				System.out.println("카드비번" + tmp + "입력");
				Thread.sleep(1000);
				break;
			case "7":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='7']")).click();
				System.out.println("카드비번" + tmp + "입력");
				Thread.sleep(1000);
				break;
			case "8":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='8']")).click();
				System.out.println("카드비번" + tmp + "입력");
				Thread.sleep(1000);
				break;
			case "9":
				driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='9']")).click();
				System.out.println("카드비번" + tmp + "입력");
				Thread.sleep(1000);
				break;
			
				
			default: //위 케이스에 없는 상황이면 디폴트로 넘어옴
				System.out.println("카드비번 입력 실패");
				break;
			}
			
		}
				
		return cardpw;
		
	}
	
	
	
	
}
