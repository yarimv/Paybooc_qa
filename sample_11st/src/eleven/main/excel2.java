package eleven.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class excel2 {

	public static void main(String[] args) {
		
		userInfo Device1 = new userInfo();
		userInfo Device2 = new userInfo();
			
		ArrayList<userInfo> list = new ArrayList<userInfo>();
				
//		Device1.setName("aaa");		
//		Device1.setCardnum("123456789");
//		Device1.setCardinfo("0011333");
//		Device1.setCardpw("9999");
//				
//		list.add(Device1);
//		
//		Device2.setName("bbb");
//		Device2.setCardnum("123456789");
//		Device2.setCardinfo("0011333");
//		Device2.setCardpw("9999");
//		
//		list.add(Device2);
//		
//		for (userInfo index:list) {
//			index.getCardinfo();
//			index.getCardnum();
//			index.getCardpw();
//			index.getName();
//			
//			System.out.println(index.getCardinfo());
//			System.out.println(index.getCardnum());
//			System.out.println(index.getCardpw());
//			System.out.println(index.getName());
//			
//		}
		
		//엑셀 A열(디바이스 이름) 값으로 비교해서 카드번호 리스트로 가져오기
		try {
			List listCardNum1 = new ArrayList();
			List listCardNum2 = new ArrayList();
			
			FileInputStream fis = new FileInputStream("D:\\sample_11st\\userinfo\\userinfo.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(1); //해당 엑셀파일의 시트 수
			int rows= sheet.getPhysicalNumberOfRows(); //해당 시트의 행의 개수
			//System.out.println(rows);
			
			for (int rowIndex = 1; rowIndex < rows; rowIndex++) {
				XSSFRow row = sheet.getRow(rowIndex); //각 행 읽어오기
				if (row != null) {
					int cells = row.getPhysicalNumberOfCells();
					//System.out.println(cells);
					XSSFCell testCell = row.getCell(0);
					String testValue= testCell.getStringCellValue()+"";
					if("GS8".equals(testValue)) {
						for (int columnIndex = 0; columnIndex < 7; columnIndex++) {
							XSSFCell cell = row.getCell(columnIndex); // 셀 값을 읽어오기
							String CardNum = "";
							switch (cell.getCellType()) {
								case NUMERIC:
									CardNum = String.valueOf(new Double(cell.getNumericCellValue()).intValue()); //소수점 버리기 문자값으로 변환
									break;
								case STRING:
									CardNum = cell.getStringCellValue() + "";
									break;
								case BLANK:
									CardNum = cell.getBooleanCellValue() + "";
									break;
								case ERROR:
									CardNum = cell.getErrorCellValue() + "";
									break;
							}
							listCardNum1.add(CardNum);
						}
					} else {
						for (int columnIndex = 0; columnIndex < 5; columnIndex++) {
							XSSFCell cell = row.getCell(columnIndex); // 셀 값을 읽어오기
							String CardNum = "";
							switch (cell.getCellType()) {
								case NUMERIC:
									CardNum = String.valueOf(new Double(cell.getNumericCellValue()).intValue()); //소수점 버리기 문자값으로 변환
									break;
								case STRING:
									CardNum = cell.getStringCellValue() + "";
									break;
								case BLANK:
									CardNum = cell.getBooleanCellValue() + "";
									break;
								case ERROR:
									CardNum = cell.getErrorCellValue() + "";
									break;
							}
							listCardNum2.add(CardNum);
						}
						System.out.println(listCardNum1);	
						System.out.println(listCardNum2);	
						
					}
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
				

		//엑셀에서 카드번호 4자리씩 읽어오기
		try {
			List listCardNum1 = new ArrayList();
			List listCardNum2 = new ArrayList();
			
			FileInputStream fis = new FileInputStream("D:\\sample_11st\\userinfo\\userinfo.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(1); //해당 엑셀파일의 시트 수
			int rows= sheet.getPhysicalNumberOfRows(); //해당 시트의 행의 개수
			
			for (int rowIndex = 1; rowIndex < rows; rowIndex++) {
				XSSFRow row = sheet.getRow(rowIndex); //각 행 읽어오기
				if (row != null) {
					int cells = row.getPhysicalNumberOfCells();
					//System.out.println(cells);
					XSSFCell testCell = row.getCell(0);
					String testValue= testCell.getStringCellValue()+"";
					if("GS8".equals(testValue)) {
						XSSFCell cell = row.getCell(2); // 셀 값을 읽어오기
						String CardNum = "";
						switch (cell.getCellType()) {
							case NUMERIC:
								CardNum = String.valueOf(new Double(cell.getNumericCellValue()).intValue()); //소수점 버리기 문자값으로 변환
								break;
							case STRING:
								CardNum = cell.getStringCellValue() + "";
								break;
							case BLANK:
								CardNum = cell.getBooleanCellValue() + "";
								break;
							case ERROR:
								CardNum = cell.getErrorCellValue() + "";
								break;
						}
						listCardNum1.add(CardNum);
						
//						for (int columnIndex = 2; columnIndex < 3; columnIndex++) {
//							XSSFCell cell = row.getCell(columnIndex); // 셀 값을 읽어오기
//							String CardNum = "";
//							switch (cell.getCellType()) {
//								case NUMERIC:
//									CardNum = String.valueOf(new Double(cell.getNumericCellValue()).intValue()); //소수점 버리기 문자값으로 변환
//									break;
//								case STRING:
//									CardNum = cell.getStringCellValue() + "";
//									break;
//								case BLANK:
//									CardNum = cell.getBooleanCellValue() + "";
//									break;
//								case ERROR:
//									CardNum = cell.getErrorCellValue() + "";
//									break;
//							}
//							listCardNum1.add(CardNum);
//						}
					} else {
						XSSFCell cell = row.getCell(2); // 셀 값을 읽어오기
						String CardNum = "";
						switch (cell.getCellType()) {
							case NUMERIC:
								CardNum = String.valueOf(new Double(cell.getNumericCellValue()).intValue()); //소수점 버리기 문자값으로 변환
								break;
							case STRING:
								CardNum = cell.getStringCellValue() + "";
								break;
							case BLANK:
								CardNum = cell.getBooleanCellValue() + "";
								break;
							case ERROR:
								CardNum = cell.getErrorCellValue() + "";
								break;
						}
						listCardNum2.add(CardNum);
												
					}
				}
			}
			
			// 리스트값을 문자값으로 변환하고, 한글자 한글자 자르기
			String cardNum1 = (String) listCardNum1.get(0);
			String cardNum2 = (String) listCardNum2.get(0);
			String tmp="";
			for(int i=0; i<16; i++) {
				tmp = cardNum1.substring(i,i+1);
				//System.out.println(tmp);
			}
			
			//SafeKeyboard 모듈에 카드번호16자리 넘겨주기
			//SafeKeyboard cardnumber = new SafeKeyboard();
			//cardnumber.cardnumClick(cardNum1);
			
			//System.out.println(listCardNum1);	
			//System.out.println(listCardNum2);	
			//System.out.println(cardNum1);	
			//System.out.println(cardNum2);	
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		


	}
}
