package eleven.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Userexcel {

	public Userexcel() {};

	public ArrayList<userInfo> excelUserinfo() {

		ArrayList<userInfo> list = new ArrayList<userInfo>();

		// �������� ���� �о����
		try {
			FileInputStream fis = new FileInputStream("D:\\sample_11st\\userinfo\\userinfo.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(1); // �ش� ���������� ��Ʈ ��
			int rows = sheet.getPhysicalNumberOfRows(); // �ش� ��Ʈ�� ���� ����

			for (int rowIndex = 1; rowIndex < rows; rowIndex++) {
				XSSFRow row = sheet.getRow(rowIndex); // �� �� �о����
				if (row != null) {
					int cells = row.getPhysicalNumberOfCells();
					// System.out.println(cells);
					XSSFCell testCell = row.getCell(0);
					String testValue = testCell.getStringCellValue() + "";
					userInfo Device = new userInfo();
					for (int columIndex = 0; columIndex < 5; columIndex++) {

						XSSFCell cell = row.getCell(columIndex); // �� ���� �о����
						String Value = "";
						switch (cell.getCellType()) {
						case NUMERIC:
							Value = String.valueOf(new Double(cell.getNumericCellValue()).intValue()); // �Ҽ��� ������ ���ڰ�����
																										// ��ȯ
							break;
						case STRING:
							Value = cell.getStringCellValue() + "";
							break;
						case BLANK:
							Value = cell.getBooleanCellValue() + "";
							break;
						case ERROR:
							Value = cell.getErrorCellValue() + "";
							break;
						}
						if (columIndex == 0) {
							Device.setDevice(Value);
						}
						if (columIndex == 1) {
							Device.setName(Value);
						} else if (columIndex == 2) {
							Device.setCardnum(Value);
						} else if (columIndex == 3) {
							Device.setCardinfo(Value);
						} else if (columIndex == 4) {
							Device.setCardpw(Value);
						}
					}
					list.add(Device);

//					}
				}
			}
			int ApplyIndex = 0;
			for (int i = 0; i < list.size(); i++) {
				if ("GS8".equals(list.get(i).getDevice())) {
					ApplyIndex = i;
				}
			}
			userInfo UserInfo = list.get(ApplyIndex);
			System.out.println(UserInfo.getCardnum());

			// ����Ʈ ���
			for (userInfo index : list) {
				System.out.println(index.getDevice());
				System.out.println(index.getName());
				System.out.println(index.getCardnum());
				System.out.println(index.getCardinfo());
				System.out.println(index.getCardpw());
			}
			System.out.println(list.get(0).getName()); // list���� 0��° �׷쿡�� ���ϴ� �׸񰪸� ���

		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;
	}
}
