package eleven.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class mysqlTest {
	
	public static void main(String[] args) {
		
		
		//mysql DB ����
		String url ="jdbc:mysql://192.168.0.203:3350/test";
		String user = "vpqa01";
		String pass = "qmdlvl01!";
		
		Connection conn = null; //connection �ʱ�ȭ
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //DriverManager�� �����ͺ��̽� ���� ���
			System.out.println("����̹� �˻� ����");
			
			conn = DriverManager.getConnection(url, user, pass);
			System.out.println("���� ����");
			
			//DB ������ �ҷ�����
			//���̺� �ҷ�����
			String qu = "select * from userinfo.USERINFO_TB"; //�ʿ��� �����͸� �̾Ƽ� �����ִ� ������: select NAME, CARD_NUMBER from userinfo_tb where DEVICE='GS8'; (GS8�� �ش��ϴ� �̸�, ī��ѹ��� ������)
			
			//java statement ����
			Statement st = conn.createStatement();
			
			//���� execute, ��ü����
			ResultSet rs = st.executeQuery(qu);
			
			//�� ���� �ݺ������� ��Ÿ����
			while (rs.next()) {
				String device = rs.getString("DEVICE");
				String phone = rs.getString("PHONE");
				String name = rs.getString("NAME");
				String cardNum = rs.getString("CARD_NUMBER");
				String cardInfo = rs.getString("CARD_INFO");
				String cardPw = rs.getString("CARD_PW");
				String certDate = rs.getString("CERT_EXDATE");
				String certPw = rs.getString("CERT_PW");
				String pbPw = rs.getString("PB_PW");
				
				//����� ���� (%s�� id ���� ������ ����� ��, %s: ���ڿ� �������� ���, \n: �ٹٲ�)
				System.out.format("%s, %s, %s, %s, %s, %s, %s, %s, %s\n", device, phone, name, cardNum, cardInfo, cardPw, certDate, certPw, pbPw);
				
			}
			
			//����
			st.close();
			
		} catch (Exception e) {
			System.out.println("����̹� �˻� ����");
			e.printStackTrace(); //���� �޼����� �߻����� ã�� �ܰ躰�� �˷��ִ� ��ɾ�
		}
		
	}
		

}
