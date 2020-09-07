package eleven.main;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SafeKeyboard {
	
	public SafeKeyboard(){};
	
	//카드번호 16자리 받기
	public String cardnumClick(String cardnum, AndroidDriver<MobileElement> driver) {
		
		//카드번호 쪼개기
		String tmp="";
		for(int i=0; i<16; i++) {
			tmp = cardnum.substring(i,i+1);
			System.out.println("카드번호 16자리: "+tmp);
			
			switch (tmp) {
			case "0":
				System.out.println("스위치" + tmp);
				//driver.findElementById("//android.widget.ImageView[@content-desc='0']").click();
				break;
			case "1":
				System.out.println("스위치" + tmp);
				break;
			case "2":
				System.out.println("스위치" + tmp);
				break;
			case "3":
				System.out.println("스위치" + tmp);
				break;
			case "4":
				System.out.println("스위치" + tmp);
				break;
			case "5":
				System.out.println("스위치" + tmp);
				break;
			case "6":
				System.out.println("스위치" + tmp);
				break;
			case "7":
				System.out.println("스위치" + tmp);
				break;
			case "8":
				System.out.println("스위치" + tmp);
				break;
			case "9":
				System.out.println("스위치" + tmp);
				break;
				
			default: //위 케이스에 없는 상황이면 디폴트로 넘어옴
				System.out.println("카드번호 못읽음");
				break;
			}
			
		}
				
		return cardnum;
		
	}

	
	//카드정보 7자리 받기 (MM YY CVC)
	public String cardinfoClick(String cardinfo, AndroidDriver<MobileElement> driver) {
		
		//카드번호 쪼개기
		String tmp="";
		for(int i=0; i<7; i++) {
			tmp = cardinfo.substring(i,i+1);
			System.out.println("카드정보 MM YY CVC: "+tmp);
			
			switch (tmp) {
			case "0":
				System.out.println("스위치" + tmp);
				//driver.findElementById("//android.widget.ImageView[@content-desc='0']").click();
				break;
			case "1":
				System.out.println("스위치" + tmp);
				break;
			case "2":
				System.out.println("스위치" + tmp);
				break;
			case "3":
				System.out.println("스위치" + tmp);
				break;
			case "4":
				System.out.println("스위치" + tmp);
				break;
			case "5":
				System.out.println("스위치" + tmp);
				break;
			case "6":
				System.out.println("스위치" + tmp);
				break;
			case "7":
				System.out.println("스위치" + tmp);
				break;
			case "8":
				System.out.println("스위치" + tmp);
				break;
			case "9":
				System.out.println("스위치" + tmp);
				break;
				
			default: //위 케이스에 없는 상황이면 디폴트로 넘어옴
				System.out.println("카드정보 못읽음");
				break;
			}
			
		}
				
		return cardinfo;
		
	}
	
}
