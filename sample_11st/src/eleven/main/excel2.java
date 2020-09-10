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
		
		//���� A��(����̽� �̸�) ������ ���ؼ� ī���ȣ ����Ʈ�� ��������
		try {
			List listCardNum1 = new ArrayList();
			List listCardNum2 = new ArrayList();
			
			FileInputStream fis = new FileInputStream("D:\\sample_11st\\userinfo\\userinfo.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(1); //�ش� ���������� ��Ʈ ��
			int rows= sheet.getPhysicalNumberOfRows(); //�ش� ��Ʈ�� ���� ����
			//System.out.println(rows);
			
			for (int rowIndex = 1; rowIndex < rows; rowIndex++) {
				XSSFRow row = sheet.getRow(rowIndex); //�� �� �о����
				if (row != null) {
					int cells = row.getPhysicalNumberOfCells();
					//System.out.println(cells);
					XSSFCell testCell = row.getCell(0);
					String testValue= testCell.getStringCellValue()+"";
					if("GS8".equals(testValue)) {
						for (int columnIndex = 0; columnIndex < 7; columnIndex++) {
							XSSFCell cell = row.getCell(columnIndex); // �� ���� �о����
							String CardNum = "";
							switch (cell.getCellType()) {
								case NUMERIC:
									CardNum = String.valueOf(new Double(cell.getNumericCellValue()).intValue()); //�Ҽ��� ������ ���ڰ����� ��ȯ
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
							XSSFCell cell = row.getCell(columnIndex); // �� ���� �о����
							String CardNum = "";
							switch (cell.getCellType()) {
								case NUMERIC:
									CardNum = String.valueOf(new Double(cell.getNumericCellValue()).intValue()); //�Ҽ��� ������ ���ڰ����� ��ȯ
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
				

		//�������� ī���ȣ 4�ڸ��� �о����
		try {
			List listCardNum1 = new ArrayList();
			List listCardNum2 = new ArrayList();
			
			FileInputStream fis = new FileInputStream("D:\\sample_11st\\userinfo\\userinfo.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(1); //�ش� ���������� ��Ʈ ��
			int rows= sheet.getPhysicalNumberOfRows(); //�ش� ��Ʈ�� ���� ����
			
			for (int rowIndex = 1; rowIndex < rows; rowIndex++) {
				XSSFRow row = sheet.getRow(rowIndex); //�� �� �о����
				if (row != null) {
					int cells = row.getPhysicalNumberOfCells();
					//System.out.println(cells);
					XSSFCell testCell = row.getCell(0);
					String testValue= testCell.getStringCellValue()+"";
					if("GS8".equals(testValue)) {
						XSSFCell cell = row.getCell(2); // �� ���� �о����
						String CardNum = "";
						switch (cell.getCellType()) {
							case NUMERIC:
								CardNum = String.valueOf(new Double(cell.getNumericCellValue()).intValue()); //�Ҽ��� ������ ���ڰ����� ��ȯ
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
//							XSSFCell cell = row.getCell(columnIndex); // �� ���� �о����
//							String CardNum = "";
//							switch (cell.getCellType()) {
//								case NUMERIC:
//									CardNum = String.valueOf(new Double(cell.getNumericCellValue()).intValue()); //�Ҽ��� ������ ���ڰ����� ��ȯ
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
						XSSFCell cell = row.getCell(2); // �� ���� �о����
						String CardNum = "";
						switch (cell.getCellType()) {
							case NUMERIC:
								CardNum = String.valueOf(new Double(cell.getNumericCellValue()).intValue()); //�Ҽ��� ������ ���ڰ����� ��ȯ
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
			
			// ����Ʈ���� ���ڰ����� ��ȯ�ϰ�, �ѱ��� �ѱ��� �ڸ���
			String cardNum1 = (String) listCardNum1.get(0);
			String cardNum2 = (String) listCardNum2.get(0);
			String tmp="";
			for(int i=0; i<16; i++) {
				tmp = cardNum1.substring(i,i+1);
				//System.out.println(tmp);
			}
			
			//SafeKeyboard ��⿡ ī���ȣ16�ڸ� �Ѱ��ֱ�
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
